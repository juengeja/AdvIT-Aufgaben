package Testat3.src;

import java.io.*;
import java.net.*;

public class Worker implements Runnable{

    DatagramSocket socket;
    DatagramPacket packet;
    RingBuffer buffer;

    public Worker(DatagramSocket socket, RingBuffer buffer){
        this.buffer = buffer;
        this.socket = socket;
    }

    @Override
    public void run() {

        String reply;
        String[] message;
        MonitorFile file;

        while(true) {
            // Neuen Auftrag aus Puffer holen
            packet = buffer.get();
            String request = new String(packet.getData(), 0, packet.getLength());

            try {
                // Verarbeitung der Read Anfrage
                if (request.startsWith("READ ")) {

                    request = request.substring(5);
                    message = request.split(",", 2);
                    file = MonitorAdministration.getMonitorFile(message[0]);
                    reply = file.readLine(Integer.parseInt(message[1]));

                    // Verarbeitung der Write Anfrage
                } else if (request.startsWith("WRITE ")) {

                    request = request.substring(6);
                    message = request.split(",", 3);
                    file = MonitorAdministration.getMonitorFile(message[0]);
                    reply = file.writeLine(Integer.parseInt(message[1]), message[2]);

                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                reply = "ERROR : Not a correct input!";
            }
            // Umwandlung in ByteArray
            byte[] byteData = reply.getBytes();

            try {
                // Senden der Antwort
                socket.send(new DatagramPacket(byteData, byteData.length, packet.getAddress(), packet.getPort()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
