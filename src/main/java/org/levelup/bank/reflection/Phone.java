package org.levelup.bank.reflection;

public class Phone {

    private int ram;
    public String model;
    String brand;

    public Phone(int ram, String phoneName) {
        this(phoneName.split(" ")[0], phoneName.split(" ")[1], ram);
    }

    private Phone(String brand, String model, int ram) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
    }

    private void printPhone(){
        System.out.println(brand + " " + model);
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

}
