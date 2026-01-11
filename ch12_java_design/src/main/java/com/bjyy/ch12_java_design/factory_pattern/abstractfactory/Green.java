package com.bjyy.ch12_java_design.factory_pattern.abstractfactory;

public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}