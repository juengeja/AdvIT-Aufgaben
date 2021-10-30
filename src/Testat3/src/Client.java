package Testat3.src;

import java.io.*;
import java.net.*;

public class Client {

    public final static int DEFAULT_PORT = 5999;
    public final static int MAX_PACKET_SIZE = 65507;

    public static void main(String[] args) {
        new Client();
    }

    public Client(){
        // DatagramSocket als Ressource anlegen, wird bei Verlassen des Try-Blocks wieder geschlossen
        try (DatagramSocket socket = new DatagramSocket()) {
            // Vorbereitungen
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            byte[] dat = new byte[MAX_PACKET_SIZE];
            DatagramPacket p;
            InetAddress host = InetAddress.getByName("localhost");

            while (true) {
                // Eingabe abfragen, an Server senden und auf Antwort warten
                System.out.println("Befehl an Server senden: ");
                System.out.println("('READ file, lineNo' or 'WRITE file, lineNo, data' or 'x' to exit)");
                String input = in.readLine();
                if(input == null || input.equals("x")){
                    break;
                }
                byte[] byteInput = input.getBytes();
                socket.send(new DatagramPacket(byteInput, byteInput.length, host, DEFAULT_PORT));
                p = new DatagramPacket(dat, dat.length, host, DEFAULT_PORT);
                socket.receive(p);
                System.out.println(new String(p.getData(), 0, p.getLength()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}