package com.bjyy.ch12_java_design.observer;

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}