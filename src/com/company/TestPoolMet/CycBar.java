package com.company.TestPoolMet;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycBar {
    public static void main(String[] args){
        CycBar cycBar = new CycBar();
        cycBar.startCyc();
    }

    public void startCyc(){
        int N=4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"随机选择线程执行额外操作");//随机挑选线程工作
            }
        });
        for(int i=0;i<N+N;i++){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                new Writer(barrier).start();
            }
        }

    }


    static class Writer extends Thread{
        private CyclicBarrier barrier;
        public Writer(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"准备就绪");
            try{
                Thread.sleep(5000);//模拟写入操作
                //System.out.println(Thread.currentThread().getName()+"doing something");
                barrier.await();
            } catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("All done");
        }
    }
}
