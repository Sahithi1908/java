package org.sahithi;

public class InheritanceMainClass {
    public static void main(String[] args) {
        //Single level inheritance
        InheritanceClass.Dog dog = new InheritanceClass.Dog();
        dog.bark();
        dog.eat();

        //Multi level inheritance
        InheritanceClass.Speakers speakers= new InheritanceClass.Speakers();
        speakers.speakerBrand();
        speakers.carBrand();
        speakers.vehicleType();

        //hierarchial inheritance
        InheritanceClass.Rectangle rectangle= new InheritanceClass.Rectangle();
        rectangle.drawRectangle();
        rectangle.draw();

        InheritanceClass.Circle circle= new InheritanceClass.Circle();
        circle.drawCircle();
        circle.draw();

        //multiple inheritance
        MultipleInheritanceImplementation multipleInheritanceImplementation = new MultipleInheritanceImplementation();
        multipleInheritanceImplementation.swim();
        multipleInheritanceImplementation.fly();




    }
}
