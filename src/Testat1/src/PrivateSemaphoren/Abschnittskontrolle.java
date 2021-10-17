package Testat1.src.PrivateSemaphoren;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Abschnittskontrolle {

    Semaphore[] privateSemaphore;
    boolean abschnittFrei;
    Semaphore mutex = new Semaphore(1, true);
    boolean[] waiting;
    int lastLok; // letzte Lok, die gemeinsamen Abschnitt verlassen hat

    public Abschnittskontrolle(int size){
        // Abschnitt ist zu Beginn frei
        abschnittFrei = true;
        // Lok 0 soll zuerst in Abschnitt einfahren
        lastLok = 1;
        // Initialisierung der pivaten Semaphore
        privateSemaphore = new Semaphore[5];
        for(int i = 0; i < size; i++){
            privateSemaphore[i] = new Semaphore(0, true);
        }
        waiting = new boolean[size];
        Arrays.fill(waiting, false);
    }

    public void enterLok0(){
        try{
            System.out.println("Lok 0 will gemeinsamen Abschnitt befahren!");
            // Kritischen Abschnitt betreten, evtl. warten
            mutex.acquire();

            // Der Abschnitt muss frei und zuletzt von Lok 1 verlassen worden sein
            System.out.println("Lok 0 prüft Einfahrtsbedingungen...");

            if(abschnittFrei && lastLok == 1){
                privateSemaphore[0].release();
                // Lok 0 setzt gemeinsamen Abschnitt auf belegt
                abschnittFrei = false;
                System.out.println("Lok 0 darf Abschnitt befahren!");
            }else{
                // Abschnitt kann nicht befahren werden, Vermerk dass Lok 0 wartet
                waiting[0] = true;
                System.out.println("Lok 0 muss auf Erlaubnis warten, den Abschnitt zu befahren...");
            }
            // Mutex verlassen
            mutex.release();

            // Prüfen des privaten Semaphors, evtl. daran warten
            System.out.println("Lok 0 prüft privaten Semaphor...");
            privateSemaphore[0].acquire();
            System.out.println("Lok 0 befährt gemeinsam genutzten Abschnitt!");

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void exitLok0(){
        try {
            // Kritischen Abschnitt betreten, evtl. warten
            mutex.acquire();
            System.out.println("Lok 0 verlässt gemeinsamen Abschnitt!");

            // Abschnitt freigeben
            abschnittFrei = true;

            // angeben, dass Lok 0 zuletzt durchgefahren ist
            lastLok = 0;

            // Prüfen, ob Lok 1 wartet
            if(waiting[1]){
                System.out.println("Lok 0 weckt Lok 1...");
                abschnittFrei = false;
                waiting[1] = false;
                privateSemaphore[1].release();
            }

            // Kritischen Abschnitt verlassen
            mutex.release();

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void enterLok1(){
        try{
            System.out.println("     Lok 1 will gemeinsamen Abschnitt befahren!");
            // Kritischen Abschnitt betreten, evtl. warten
            mutex.acquire();

            // Der Abschnitt muss frei und zuletzt von Lok 0 verlassen worden sein
            System.out.println("     Lok 1 prüft Einfahrtsbedingungen...");

            if(abschnittFrei && lastLok == 0){
                privateSemaphore[1].release();
                // Lok 1 setzt gemeinsamen Abschnitt auf belegt
                abschnittFrei = false;
                System.out.println("     Lok 1 darf Abschnitt befahren!");
            }else{
                // Abschnitt kann nicht befahren werden, Vermerk dass Lok 1 wartet
                waiting[1] = true;
                System.out.println("     Lok 1 muss auf Erlaubnis warten, den Abschnitt zu befahren...");
            }
            // Mutex verlassen
            mutex.release();

            // Prüfen des privaten Semaphors, evtl. daran warten
            System.out.println("     Lok 1 prüft privaten Semaphor...");
            privateSemaphore[1].acquire();
            System.out.println("     Lok 1 befährt gemeinsam genutzten Abschnitt!");

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void exitLok1(){
        try {
            // Kritischen Abschnitt betreten, evtl. warten
            mutex.acquire();
            System.out.println("     Lok 1 verlässt gemeinsamen Abschnitt!");

            // Abschnitt freigeben
            abschnittFrei = true;

            // angeben, dass Lok 1 zuletzt durchgefahren ist
            lastLok = 1;

            // Prüfen, ob Lok 1 wartet
            if(waiting[0]){
                System.out.println("     Lok 1 weckt Lok 0...");
                abschnittFrei = false;
                waiting[0] = false;
                privateSemaphore[0].release();
            }

            // Kritischen Abschnitt verlassen
            mutex.release();

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
