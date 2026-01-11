package com.bjyy.ch12_java_design.factory_pattern.abstractfactory;

public class Red implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}