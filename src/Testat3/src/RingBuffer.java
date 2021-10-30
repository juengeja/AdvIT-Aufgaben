package Testat3.src;

import java.net.DatagramPacket;

public class RingBuffer {

    private final int size;
    private final DatagramPacket[] buffer;
    private int ctr = 0;
    private int nextfree = 0;
    private int nextfull = 0;

    public RingBuffer(int size) {
        this.size = size;
        buffer = new DatagramPacket[size];
    }

    public synchronized void put(DatagramPacket datagramPacket) {
        // Warten, solange der Buffer voll ist
        while (ctr == size) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        buffer[nextfree] = datagramPacket;
        nextfree = (nextfree + 1) % size;
        ctr++;
        notifyAll();
    }

    public synchronized DatagramPacket get() {
        // Warten, solange der Buffer leer ist
        while(ctr == 0){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        DatagramPacket datagramPacket = buffer[nextfull];
        nextfull = (nextfull + 1) % size;
        ctr--;
        notifyAll();
        return datagramPacket;
    }

}
