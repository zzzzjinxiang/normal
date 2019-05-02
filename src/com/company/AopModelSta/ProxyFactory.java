package com.company.AopModelSta;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    /**
     * 动态代理
     */

    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    public Object getProxyInstance(){
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        Object result = null;
                        if("find".equals(methodName))
                            result = method.invoke(target,args);
                        else {
                            System.out.println("开启事务");
                            result = method.invoke(target,args);
                            System.out.println("事务完成");
                        }
                        return result;
                    }
                }
        );
          return proxy;
    }
}
