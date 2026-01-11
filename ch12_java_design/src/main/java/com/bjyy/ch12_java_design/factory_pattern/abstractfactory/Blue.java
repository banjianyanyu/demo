package com.bjyy.ch12_java_design.factory_pattern.abstractfactory;

public class Blue implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}