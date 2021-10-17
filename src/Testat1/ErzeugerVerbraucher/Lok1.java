package Testat1.ErzeugerVerbraucher;

public class Lok1 implements Lok{

    private final Abschnittskontrolle abschnittskontrolle;
    private final int millisekundenImAbschnitt;
    private final int millisekundenAusserhalb;

    public Lok1(Abschnittskontrolle abschnittskontrolle, int millisekundenImAbschnitt, int millisekundenAusserhalb){
        // Initialisierung der Abschnittskontrolle für Lok1
        this.abschnittskontrolle = abschnittskontrolle;
        // Festlegen der von Lok1 benötigten Zeit zum Durchfahren des gemeinsamen Abschnitts
        this.millisekundenImAbschnitt = millisekundenImAbschnitt;
        // Festlegen der von Lok1 benötigten Zeit zum Durchfahren des eigenen Abschnitts
        this.millisekundenAusserhalb = millisekundenAusserhalb;
    }

    @Override
    public void run() {
        System.out.println("Lok1 fährt los!");
        while(true){
            try {
                // Fahren im eigenen Streckenabschnitt
                Thread.sleep(millisekundenAusserhalb);
                // Beantragen der Einfahrt in gemeinsam genutzten Streckenabschnitt
                abschnittskontrolle.enterLok1();
                // Lok 0 fährt im mittleren (gemeinsam genutzten) Teilstück
                Thread.sleep(millisekundenImAbschnitt);
                // Lok 0 verlässt den gemeinsam genutzten Streckenabschnitt
                abschnittskontrolle.exitLok1();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
