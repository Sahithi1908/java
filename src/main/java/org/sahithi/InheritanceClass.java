package org.sahithi;

public class InheritanceClass {
//Single Inheritance
    static class Animal{
        public void eat(){
            System.out.println("Animal eats meat");
        }
    }

    public static class Dog extends Animal{
        public void bark(){
            System.out.println("Dog barks...");
        }
    }

    //multilevel inheritance
    static class Vehicle{
        public void vehicleType(){
            System.out.println("4 wheeler vehicle");
        }
    }

    static class Car extends Vehicle{
        public void carBrand(){
            System.out.println("Car brand is Audi");
        }

    }
    static class Speakers extends Car{
        public void speakerBrand(){
            System.out.println("Speaker using in car is Boat");
        }
    }

    //Hierarchial
    static class Shape{
        public void draw(){
            System.out.println("Drawing shape");
        }
    }
    static class Circle extends Shape{
        public void drawCircle(){
            System.out.println("Drawing circle");
        }
    }
    static class Rectangle extends Shape{
        public void drawRectangle(){
            System.out.println("Drawing rectangle");
        }
    }
}
