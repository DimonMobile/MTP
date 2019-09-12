package com.company;

public class Fridge extends Electrical {


    Fridge(){
        voltage = 220;
        amperage = 1;
        System.out.println("Fridge created");
    }

    @Override
    public String name() {
        return "Fridge";
    }

    @Override
    public void turnOn() {
        if (!active)
            System.out.println("Fridge turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            System.out.println("Fridge turnOff");
        super.turnOff();
    }
}
