package org.sahithi;

public class EncapsulationMainClass {
    public static void main(String[] args) {
        EncapsulationClass encapsulationClass =  new EncapsulationClass();
        encapsulationClass.setName("Sahithi");
        encapsulationClass.setSalary(10000);
        System.out.println(encapsulationClass.getName());
        System.out.println(encapsulationClass.getSalary());
    }
}
