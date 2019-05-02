package com.company.TestPoolMet;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CycBari {
    public static void main(String[] args){
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for(int i=0;i<3;i++){
            new tools(barrier).start();
        }
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        new tools(barrier).start();
    }

}

class tools extends Thread{
    private CyclicBarrier barrier;
    public tools(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    @Override
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+"正在运行");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"运行完毕");
            try{
                barrier.await(2000, TimeUnit.MILLISECONDS);
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完毕，处理其他事务");
    }
}
