package com.bjyy.ch12_java_design.factory_pattern.simpleFactory;

public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}