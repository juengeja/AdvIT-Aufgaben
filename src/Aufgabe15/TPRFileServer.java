package Aufgabe15;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TPRFileServer {

    public final int DEFAULT_PORT = 5999;
    int port;

    public static void main(String[] args) {
        new TPRFileServer();
    }

    public TPRFileServer() {
        new TPRFileServer(DEFAULT_PORT);
    }

    public TPRFileServer(int port) {
        this.port = port;

        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {

            DatagramPacket data = new DatagramPacket(new byte[65507], 65507);

            while (true) {
                datagramSocket.receive(data);
                new ThreadPerRequest(datagramSocket, data.getAddress(), data.getPort(), new String(data.getData(), 0, data.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
