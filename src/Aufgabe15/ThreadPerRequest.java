package Aufgabe15;

import java.io.*;
import java.net.*;

public class ThreadPerRequest extends Thread{

    DatagramSocket datagramSocket;
    InetAddress inetAddress;
    String request;
    int port;

    private final String FILEPATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Files" + File.separator;
    public ThreadPerRequest(DatagramSocket datagramsocket, InetAddress inetAddress, int port, String request){

        this.datagramSocket = datagramsocket;
        this.request = request;
        this.inetAddress = inetAddress;
        this.port = port;

        this.start();
    }

    @Override
    public void run() {

        String reply = "";
        String[] message;
        TPRMyFile file = new TPRMyFile();

        if (request.startsWith("READ ")) {

            request = request.substring(5);
            message = request.split(",");
            reply = file.readLine(FILEPATH, message[0], Integer.parseInt(message[1]));

        } else if (request.startsWith("WRITE ")) {
            request = request.substring(6);
            message = request.split(",");
            file.writeLine(FILEPATH, message[0], Integer.parseInt(message[1]), message[2]);
            reply = "Written!";

        } else {
            reply = "Not a correct input!";
        }

        byte[] byteData = reply.getBytes();

        try {
            datagramSocket.send(new DatagramPacket(byteData, byteData.length, inetAddress, port));
        }catch(IOException e){
            e.printStackTrace();
        }

        Thread.currentThread().interrupt();
    }
}
