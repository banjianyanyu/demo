package com.bjyy.ch12_java_design.factory_pattern.simpleFactory;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}