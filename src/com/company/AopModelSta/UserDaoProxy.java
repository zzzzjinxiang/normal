package com.company.AopModelSta;

public class UserDaoProxy implements IUserDao{
    /**
     * @维护目标对象
     */
    private IUserDao target = new UserDao();
        @Override
        public void save() {
            System.out.println("开启事务");
            target.save();
            System.out.println("事务完成");
        }

        @Override
        public void find() {
            target.find();
            System.out.println("查找完成，返回结果");
        }
}
