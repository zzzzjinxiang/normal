package com.company.TestPoolMet;

import java.util.concurrent.CountDownLatch;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CntLatch {
    public static void main(String[] args){
        int poolSize = 4;
        int needThr = 4;
        CountDownLatch latch = new CountDownLatch(poolSize);

        for(int i=0;i<needThr;i++){
            new tools().start();
        }

        try{
            System.out.println("等待子线程执行完毕");
            latch.await(2,SECONDS);
            System.out.println("子线程执行完毕，继续主线程");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    static class tools extends Thread{
        @Override
        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+"正在运行");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"运行完毕");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


