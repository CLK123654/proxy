package com.hae.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
  public static void main(String[] args) {
   Producer producer = new Producer();
    Producer proxy = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法增强------");
        method.invoke(producer, objects);
        return null;
      }
    });
    proxy.eat("blana");
  }
}
