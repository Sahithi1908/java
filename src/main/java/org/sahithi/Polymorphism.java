package org.sahithi;
/*
1. Multiple forms for an object
2. Method overloading and overriding
 */
class OverloadingExample{
    //method add with 2 parameters
    public void add(int a, int b){
        int sum= a+b;
        System.out.println("sum is: "+sum);
    }
    //same method add with two different types of parameters
    public void add(int a, double b){
        double sum= a+b;
        System.out.println("sum is: "+sum);
    }

}
class Animal{
    public void makeSound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    //overriding with same method name
    @Override
    public void makeSound(){
        System.out.println("Dog barkinng");
    }
}
class Lion extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Lion roar");
    }
}



public class Polymorphism {
    public static void main(String[] args) {
        //overloading
        OverloadingExample mathOperations = new OverloadingExample();
        mathOperations.add(2,3);
        mathOperations.add(2,2.0);

        //Overriding
        Dog dog = new Dog();
        Lion lion = new Lion();
        dog.makeSound();
        lion.makeSound();

    }
}
