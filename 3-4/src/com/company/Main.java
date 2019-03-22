package com.company;

import java.rmi.UnexpectedException;

public class Main {

    public static void main(String[] args) {
        Room room = new Room(100);
        try {
            room.turnOnAll();
        } catch(UnexpectedException e){
            System.out.println("aaaaa");
        }
    }
}
