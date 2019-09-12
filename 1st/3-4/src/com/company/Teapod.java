package com.company;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Teapod extends Electrical{

    private static final Logger log = LogManager.getRootLogger();

    Teapod(){
        amperage = 5;
        voltage = 60;
        log.debug("Teapod created");
    }

    @Override
    public String name() {
        return "Teapod";
    }

    @Override
    public void turnOn() {
        if (!active)
            log.info("teapod turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            log.info("teapod turnOff");
        super.turnOff();
    }
}
