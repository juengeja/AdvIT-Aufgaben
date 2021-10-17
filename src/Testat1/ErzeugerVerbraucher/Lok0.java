package Testat1.ErzeugerVerbraucher;

public class Lok0 implements Lok{

    private final Abschnittskontrolle abschnittskontrolle;
    private final int millisekundenImAbschnitt;
    private final int millisekundenAusserhalb;

    public Lok0(Abschnittskontrolle abschnittskontrolle, int millisekundenImAbschnitt, int millisekundenAusserhalb){
        // Initialisierung der Abschnittskontrolle für Lok0
        this.abschnittskontrolle = abschnittskontrolle;
        // Festlegen der von Lok0 benötigten Zeit zum Durchfahren des gemeinsamen Abschnitts
        this.millisekundenImAbschnitt = millisekundenImAbschnitt;
        // Festlegen der von Lok0 benötigten Zeit zum Durchfahren des eigenen Abschnitts
        this.millisekundenAusserhalb = millisekundenAusserhalb;
    }

    @Override
    public void run() {
        System.out.println("Lok0 fährt los!");
        while(true){
            try {
                // Fahren im eigenen Streckenabschnitt
                Thread.sleep(millisekundenAusserhalb);
                // Beantragen der Einfahrt in gemeinsam genutzten Streckenabschnitt
                abschnittskontrolle.enterLok0();
                // Lok 0 fährt im mittleren (gemeinsam genutzten) Teilstück
                Thread.sleep(millisekundenImAbschnitt);
                // Lok 0 verlässt den gemeinsam genutzten Streckenabschnitt
                abschnittskontrolle.exitLok0();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
