package com.company;


public class TV extends Electrical {

    TV(){
        amperage = 2;
        voltage = 80;
        System.out.println("TV created");
    }

    @Override
    public String name() {
        return "TV";
    }

    @Override
    public void turnOn() {
        if (!active)
            System.out.println("TV turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            System.out.println("TV turnOff");
        super.turnOff();
    }
}
