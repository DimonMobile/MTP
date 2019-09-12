package com.company;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Fridge extends Electrical {

    private static final Logger log = LogManager.getRootLogger();

    Fridge(){
        voltage = 220;
        amperage = 1;
        log.debug("Fridge created");
    }

    @Override
    public String name() {
        return "Fridge";
    }

    @Override
    public void turnOn() {
        if (!active)
            log.info("Fridge turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            log.info("Fridge turnOn");
        super.turnOff();
    }
}
