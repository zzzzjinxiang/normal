package com.company.DynmicMake;

class Car{
    void run(){
        System.out.println("这是一辆车");
    }
}
public class ThreadPoolImp extends Car{
    void run(){
        System.out.println("这不是车");
    }
    public static void main(String[] args){
        Car h = new ThreadPoolImp();
        h.run();
    }
}
