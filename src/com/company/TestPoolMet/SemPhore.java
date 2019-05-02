package com.company.TestPoolMet;

import java.util.concurrent.Semaphore;

public class SemPhore {
    public static void main(String[] args){
        int N=8;
        Semaphore semaphore = new Semaphore(3);
        for(int i=0;i<N;i++){
            new tools(i,semaphore).start();
        }
    }
    static class tools extends Thread{
        private int num;
        private Semaphore semaphore;
        public tools(int num,Semaphore semaphore){
            this.semaphore = semaphore;
            this.num = num;
        }
        @Override
        public void run(){
            try{
                semaphore.acquire();
                System.out.println(this.num+"正在生产");
                System.out.println("ok-"+this.num);
                Thread.sleep(2000);
                System.out.println(this.num+"生产结束");
                semaphore.release(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
