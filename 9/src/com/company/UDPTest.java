package com.company;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UDPTest {
    UdpClient client;
    UdpServerThread server;

    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        server = new UdpServerThread();
        server.start();
        client = new UdpClient();
        Thread.sleep(1000);
    }

    @Test(timeOut = 1000)
    public void test1() throws IOException {
        String testMsg = "Test";
        String echo = client.sendEcho(testMsg);
        assertEquals(echo, testMsg);
    }

    @Test(timeOut = 1000)
    public void test2() throws IOException {
        String testMsg = " ";
        String echo = client.sendEcho(testMsg);
        assertEquals(echo, testMsg);
    }

    @Test(timeOut = 1000)
    public void test3() throws IOException {
        String testMsg = "ASDSADASDASASDSADASDASASDSADASDASASSDSADASDASASDSADASDASASDSADASDASASDSADASDASSDSADASDASASSDSADASDASASDSADASDASASDSADASDASASDSADASDAS";
        String echo = client.sendEcho(testMsg);
        assertEquals(echo, testMsg);
    }

    @AfterTest
    public void end()  throws IOException, InterruptedException{
        client.sendEcho("end");
        client.close();
        server.join(1000);
    }
}
