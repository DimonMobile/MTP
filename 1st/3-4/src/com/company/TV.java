package com.company;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TV extends Electrical {

    private static final Logger log = LogManager.getRootLogger();

    TV(){
        amperage = 2;
        voltage = 80;
        log.debug("TV created");
    }

    @Override
    public String name() {
        return "TV";
    }

    @Override
    public void turnOn() {
        if (!active)
            log.info("TV turnOn");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if (active)
            log.info("TV turnOn");
        super.turnOff();
    }
}
