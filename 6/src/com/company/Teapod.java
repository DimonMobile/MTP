package com.company;


public class Teapod extends Electrical{

    Teapod(){
        amperage = 5;
        voltage = 60;
        System.out.println("Teapod created");
    }

    @Override
    public String name() {
        return "Teapod";
    }

    @Override
    public void turnOn() {
        if (!active)
            System.out.println("Teapod turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            System.out.println("Teapod turnOff");
        super.turnOff();
    }
}
