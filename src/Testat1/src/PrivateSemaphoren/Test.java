package Testat1.src.PrivateSemaphoren;

public class Test {

    private Lok lok0;
    private Lok lok1;
    private Abschnittskontrolle abschnittskontrolle;

    public static void main(String[] args) {

        Test test = new Test();

        // Testfall erstellen
        test.ausserhalbSchneller();
        // Einen Test starten
        test.startTest();
    }

    public Test(){
        abschnittskontrolle = new Abschnittskontrolle(2);
    }

    private void startTest(){
        // Verpacken der Loks in Threads und starten dieser
        Thread t0 = new Thread(lok0);
        Thread t1 = new Thread(lok1);
        t0.start();
        t1.start();
    }

    public void gleichSchnell(){
        // Lok 0 und Lok 1 sind gleich schnell.
        this.lok0 = new Lok0(abschnittskontrolle, 1000, 1000);
        this.lok1 = new Lok1(abschnittskontrolle, 1000, 1000);
    }

    public void lok0Langsamer(){
        // Lok 0 ist langsamer als Lok 1.
        this.lok0 = new Lok0(abschnittskontrolle, 3000, 3000);
        this.lok1 = new Lok1(abschnittskontrolle, 1000, 1000);
    }

    public void lok0Schneller(){
        // Lok 0 ist schneller als Lok 1.
        this.lok0 = new Lok0(abschnittskontrolle, 1000, 1000);
        this.lok1 = new Lok1(abschnittskontrolle, 3000, 3000);
    }

    public void lok0VielSchneller(){
        // Lok 0 ist sehr viel schneller als Lok 1.
        this.lok0 = new Lok0(abschnittskontrolle, 10, 10);
        this.lok1 = new Lok1(abschnittskontrolle, 3000, 3000);
    }

    public void lok0VielLangsamer(){
        // Lok 0 ist sehr viel langsamer als Lok 1.
        this.lok0 = new Lok0(abschnittskontrolle, 3000, 3000);
        this.lok1 = new Lok1(abschnittskontrolle, 10, 10);
    }

    public void innerhalbSchneller(){
        // Lok 0 und Lok 1 sind innerhalb des gemeinsamen Abschnitts schneller als außerhalb
        this.lok0 = new Lok0(abschnittskontrolle, 10, 3000);
        this.lok1 = new Lok1(abschnittskontrolle, 10, 3000);
    }

    public void ausserhalbSchneller(){
        // Lok 0 und Lok 1 sind außerhalb des gemeinsamen Abschnitts schneller als innerhalb
        this.lok0 = new Lok0(abschnittskontrolle, 3000, 10);
        this.lok1 = new Lok1(abschnittskontrolle, 3000, 10);
    }
}
