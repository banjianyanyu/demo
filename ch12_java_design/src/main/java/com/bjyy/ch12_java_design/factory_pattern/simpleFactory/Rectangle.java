package com.bjyy.ch12_java_design.factory_pattern.simpleFactory;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}