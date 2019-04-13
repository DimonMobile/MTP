package com.company;

import org.testng.Assert;
import org.testng.annotations.*;

import java.rmi.UnexpectedException;

public class RoomTest {

    @AfterSuite
    public void afterS() {
        System.out.println("AfterSuite test");
    }

    @BeforeSuite
    public void beforeS() {
        System.out.println("BeforeSuite test");
    }

    @BeforeTest
    public void before() {
        System.out.println("BeforeTest test");
    }

    @AfterTest
    public void after() {
        System.out.println("AfterTest test");
    }

    @Test
    public void test1() {
        Room room = new Room(10000);
        double currentPower = room.getInnerPower();
        Fridge fridge = new Fridge();
        fridge.setAmperage(100);
        fridge.setVoltage(1);
        room.getDevices().add(fridge);
        Assert.assertEquals(room.getInnerPower(), currentPower + fridge.getPower());
    }

    @Test(expectedExceptions = UnexpectedException.class)
    public void test2() throws Exception{
        Room room = new Room(1);
        room.turnOnAll();
    }
}
