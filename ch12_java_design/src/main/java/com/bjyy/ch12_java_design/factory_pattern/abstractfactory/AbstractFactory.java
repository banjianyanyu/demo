package com.bjyy.ch12_java_design.factory_pattern.abstractfactory;

public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape);
}