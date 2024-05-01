package org.sahithi;

public class MultipleInheritanceImplementation implements MultipleInheritanceSwim,MultipleInheritanceFly{

String name =  "Duck";
    @Override
    public void fly() {
        System.out.println(name+" fly");
    }

    @Override
    public void swim() {
        System.out.println(name+" swim");
    }
}
