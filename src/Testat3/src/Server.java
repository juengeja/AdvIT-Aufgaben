package Testat3.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Server {

    final int DEFAULT_PORT = 5999;
    final static int MAX_PACKET_SIZE = 65507;
    final static int NUMBER_OF_WORKERS = 8;
    RingBuffer buffer;
    ArrayList<Thread> workerPool = new ArrayList<>();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {

        // Socket als Ressource erstellen, wird nach try-Block automatisch geschlossen
        try (DatagramSocket datagramSocket = new DatagramSocket(DEFAULT_PORT)) {

            // Erstellen eines Puffers
            buffer = new RingBuffer(NUMBER_OF_WORKERS);

            // Anlegen der Worker
            for(int i = 0; i < NUMBER_OF_WORKERS; i++) {
                workerPool.add(new Thread(new Worker(datagramSocket, buffer)));
            }

            // Starten der Worker
            for (Thread worker: workerPool) {
                worker.start();
            }

            while (true) {
                // Neues DatagramPacket erzeugen
                DatagramPacket data = new DatagramPacket(new byte[MAX_PACKET_SIZE], MAX_PACKET_SIZE);
                // Auf Empfang eines Packets warten
                datagramSocket.receive(data);
                // Packet in Puffer legen
                buffer.put(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
