package com.company.AopModelSta;

public class UserDao implements IUserDao {
    @Override
    public void save(){
        System.out.println("模拟：保存操作");
    }
    @Override
    public void find(){
        System.out.println("模拟：查找操作");
    }
}
