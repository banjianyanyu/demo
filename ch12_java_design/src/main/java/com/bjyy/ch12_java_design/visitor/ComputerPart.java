package com.bjyy.ch12_java_design.visitor;

public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}