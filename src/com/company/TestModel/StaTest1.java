package com.company.TestModel;

import com.company.AopModelSta.IUserDao;
import com.company.AopModelSta.UserDaoProxy;

public class StaTest1 {
    public static void main(String[] args){
        IUserDao proxy = new UserDaoProxy();
        proxy.save();
        proxy.find();
    }
}
