package com.company;

public abstract class Electrical implements ElectricalDevice {
    protected double amperage;
    protected double voltage;
    protected boolean active;

    @Override
    public double getAmperage() {
        return amperage;
    }

    @Override
    public void setAmperage(double amperage) {
        this.amperage = amperage;
    }

    @Override
    public double getVoltage() {
        return voltage;
    }

    @Override
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public double getPower() {
        return voltage * amperage;
    }

    public abstract String name();
    public boolean isActive()
    {
        return active;
    }
    public void turnOn()
    {
        active = true;
    }
    public void turnOff()
    {
        active = false;
    }
}