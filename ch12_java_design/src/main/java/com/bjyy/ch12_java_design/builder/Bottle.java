package com.bjyy.ch12_java_design.builder;

public class Bottle implements Packing {
 
   @Override
   public String pack() {
      return "Bottle";
   }
}