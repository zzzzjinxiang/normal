package com.company.DynmicMake;

class Car{
    void run(){
        System.out.println("这是一辆车");
        run2();
    }
    void run2(){
        System.out.println("车在跑");
    }
}
public class ThreadPoolImp extends Car{
    void run(){
        System.out.println("这不是车");
    }
    void run2(){
        System.out.println("车跑关我什么事");
    }
    public static void main(String[] args){
        Car h = new ThreadPoolImp();
        h.run();
    }
}
