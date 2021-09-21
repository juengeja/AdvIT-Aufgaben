package Aufgabe8;

public class MyThread1 extends Thread{

    private final int id;
    public MyThread1( int id){
        this.id = id;
    }

    public void run(){
        try{
            Thread.sleep( (int) (Math.random() * 1000) );
        }catch (Exception e){
            System.out.println("Fehler! ID: " + id);
        }
        System.out.println("Hello World (ID = " + id + ")");
    }

    public static void main(String[] args) {
        Thread[] myThreads = new Thread[11];
        for( int i = 1; i < 10; i++) {
            Thread t = new MyThread1(i);
            t.start();
            myThreads[i-1] = t;
        }
        for(int i = 0; i < 9; i++){
            try{
                myThreads[i].join();
            }catch(Exception e){
                System.out.println("Fehler!");
            }
        }
        System.out.println("Alle fertig!");
    }
}
