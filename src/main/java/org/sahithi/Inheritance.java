package org.sahithi;
/*
Inheritance:
1. Get the properties from parent class
Types: Single level, Multi level, Multiple, Hierarchical
 */

//Animal is Parent
class AnimalParent{
    void eat(){
        System.out.println("Animals eat meat");
    }
}
class ChildDog extends AnimalParent{
    void bark(){
        System.out.println("Dog is Barking in the street");
    }
}
class DogBreed extends ChildDog{
    void breedName(){
        System.out.println("Labrador");
    }
}
class ChildLion extends AnimalParent{
    void lionRoar(){
        System.out.println("Lion roaring in the jungle");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        //Single level Inheritance
        ChildDog childDog = new ChildDog();
        childDog.eat();
        childDog.bark();

        //multilevel
        DogBreed dogBreed = new DogBreed();
        dogBreed.eat();
        dogBreed.bark();
        dogBreed.breedName();

        //hierachical inheritance
        ChildLion childLion = new ChildLion();
        childLion.eat();
        childLion.lionRoar();
    }
}
