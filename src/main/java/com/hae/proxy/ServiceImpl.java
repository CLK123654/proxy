package com.hae.proxy;

public class ServiceImpl implements Service{
  @Override
  public void eat(String food) {
    System.out.println(food + " is delicious!");
  }
}
