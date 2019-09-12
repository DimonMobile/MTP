package com.company;

import java.rmi.UnexpectedException;
import java.util.LinkedList;


public class Room {

    private LinkedList<Electrical> devices;

    public double getMaxPower() {
        return maxPower;
    }

    private double maxPower;

    public Room(double maxPower){
        this.maxPower = maxPower;
        devices = new LinkedList<>();
     //   devices.add(new Teapod());
     //   devices.add(new TV());
     //   devices.add(new TV());
     //   devices.add(new Fridge());
    }

    LinkedList<Electrical> getDevices() {
        return devices;
    }

    void turnOnAll() throws UnexpectedException{
        double power = 0.0;
        for(Electrical item : devices) {
            item.turnOn();
            power += item.getPower();
        }

        for(Electrical item : devices) {
            item.turnOff();
            power += item.getPower();
        }

        if (power > this.maxPower)
            throw new UnexpectedException("<BOM>");

    }
}
