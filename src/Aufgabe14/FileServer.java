package Aufgabe14;

import java.io.*;
import java.net.*;

public class FileServer {

    public final int DEFAULT_PORT = 5999;
    private final String FILEPATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Files" + File.separator;
    int port;

    public static void main(String[] args) {
        new FileServer();
    }

    public FileServer() {
        new FileServer(DEFAULT_PORT);
    }

    public FileServer(int port) {
        this.port = port;

        String reply = "";
        MyFile file = new MyFile();

        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {

            DatagramPacket data = new DatagramPacket(new byte[65507], 65507);

            while (true) {
                datagramSocket.receive(data);
                String input = new String(data.getData(), 0, data.getLength());
                String[] message;

                if (input.startsWith("READ ")) {

                    input = input.substring(5);
                    message = input.split(",");
                    reply = file.readLine(FILEPATH, message[0], Integer.parseInt(message[1]));

                } else if (input.startsWith("WRITE ")) {
                    input = input.substring(6);
                    message = input.split(",");
                    file.writeLine(FILEPATH, message[0], Integer.parseInt(message[1]), message[2]);
                    reply = "Written!";

                } else {
                    reply = "Not a correct input!";
                }
                InetAddress inetAddress = data.getAddress();
                byte[] byteData = reply.getBytes();
                datagramSocket.send(new DatagramPacket(byteData, byteData.length, inetAddress, data.getPort()));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
