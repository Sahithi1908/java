package org.sahithi;
/*
Abstraction - show necessary feature and hide implementation of an object

 */
abstract class Shape{
    abstract  void draw();

}
class Circle extends Shape {
    @Override
    void draw(){
        System.out.println("Circle shape");
    }
}
class Rectangle extends Shape{
    @Override
    void draw(){
        System.out.println("Rectangle shape");
    }
}
public class Abstraction {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        circle.draw();
        rectangle.draw();
    }
}
