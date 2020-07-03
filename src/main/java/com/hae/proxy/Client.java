package com.hae.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
  public static void main(String[] args) {
    Service service = new ServiceImpl();
    Service proxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
            new InvocationHandler() {
              @Override
              public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("wash your hand before");
                method.invoke(service, args);
                return null;
              }
            });
    proxy.eat("apple");
  }
}
