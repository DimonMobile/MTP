package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServerThread extends Thread {
    private DatagramSocket socket;
    private boolean running;

    public UdpServerThread() {
        try {
            socket = new DatagramSocket(7777);
        } catch (SocketException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    @Override
    public void run(){
        try {
            running = true;
            while(running) {
                byte buf[] = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received
                        = new String(packet.getData(), 0, packet.getLength());

                if (received.equals("end")) {
                    running = false;
                    continue;
                }
                socket.send(packet);
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
