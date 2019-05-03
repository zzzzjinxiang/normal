package com.company.TestPoolMet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CntLatch {
    public static void main(String[] args){
        Application result = new Application();
        result.StartApp();
    }

    static class tools extends Thread{
        private CountDownLatch latch;
        private int i;
        public tools(CountDownLatch latch,int i){
            super();
            this.latch = latch;
            this.i = i;
        }
        @Override
        public void run(){
            try{
                System.out.println(Thread.currentThread().getName()+"正在运行"+i);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"运行完毕"+i);
                if(latch!=null)
                    latch.countDown();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Application{
    private final static Application INSTANCE = new Application();
    public static Application getInstance(){
        return INSTANCE;
    }

    public void StartApp(){
        int poolSize = 4;
        int needThr = 4;
        CountDownLatch latch = new CountDownLatch(2);
        Executor executor = Executors.newFixedThreadPool(2);

        for(int i=0;i<needThr;i++){
            executor.execute(new CntLatch.tools(latch,i));
        }

        try{
            System.out.println("等待子线程执行完毕");
            latch.await();
            System.out.println("子线程执行完毕，继续主线程");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

