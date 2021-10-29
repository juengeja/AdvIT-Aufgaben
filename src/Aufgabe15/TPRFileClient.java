package Aufgabe15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class TPRFileClient {

    public static void main(String[] args) {
        new TPRFileClient();
    }

    public TPRFileClient() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            byte[] addr = new byte[] {(byte) 141, 72, 16, (byte) 255};
            byte[] dat = new byte[65000];
            DatagramPacket p = null;
            while (true) {
                System.out.println("Befehl an Server senden: ");
                byte[] input = in.readLine().getBytes();
                socket.send(new DatagramPacket(input,input.length, InetAddress.getByName("localhost"), 5999));
                p = new DatagramPacket(dat, dat.length, InetAddress.getByName("localhost"), 5999);
                socket.receive(p);
                System.out.println(new String(p.getData(), 0, p.getLength()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}