package org.sahithi;

/*
Encapsulation:
1. Bundles the data and methods into a single unit
2. Restrict the access to the data from outside the class

 */
public class Encapsulation {
    String name = "Sahithi";
    String address="Hyderabad";
    private int salary;

    public Encapsulation(String name, String address, int salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public Encapsulation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class EncapsulationMain {

    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation();
        System.out.println(encapsulation.name);
        System.out.println(encapsulation.address);

        encapsulation.setSalary(10);
        System.out.println(encapsulation.getSalary());

    }
}
