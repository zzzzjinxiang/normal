package com.company.TestModel;

import com.company.AopModelSta.IUserDao;
import com.company.AopModelSta.ProxyFactory;
import com.company.AopModelSta.UserDao;

public class DynTest {
    public static void main(String[] args){
        IUserDao target = new UserDao();
        System.out.println("目标对象"+target.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理对象"+ proxy.getClass());
        proxy.find();
        proxy.save();
    }
}
