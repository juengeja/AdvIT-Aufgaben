package Testat1.ErzeugerVerbraucher;

import java.util.concurrent.Semaphore;

public class Abschnittskontrolle {

    private Semaphore full;
    private Semaphore empty;

    public Abschnittskontrolle(int size){
        // Initialisierung der Semaphore zur Nutzung des gemeinsamen Streckenabschnitts
        this.full = new Semaphore(0, true);
        this.empty = new Semaphore(size, true);
    }

    public void enterLok0(){
        try {
            System.out.println("Lok0 beantragt Einfahrerlaubnis in gemeinsamen Abschnitt!");
            empty.acquire();
            System.out.println("Lok0 fährt in gemeinsamen Abschnitt ein!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exitLok0(){
        System.out.println("Lok 0 fährt aus gemeinsamen Abschnitt aus!");
        full.release();
    }

    public void enterLok1(){
        try{
            System.out.println("Lok 1 beantragt Einfahrerlaubnis in gemeinsamen Abschnitt!");
            full.acquire();
            System.out.println("Lok 1 fährt in gemeinsamen Abschnitt ein!");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void exitLok1(){
        System.out.println("Lok 1 fährt aus gemeinsamen Abschnitt aus!");
        empty.release();
    }

}
