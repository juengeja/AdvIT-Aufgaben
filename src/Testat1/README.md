# Testat 1  
## Aufbau  
Im Ordner **src** befinden sich die Unterverzeichnisse 
**ErzeugerVerbraucher** und **PrivateSemaphoren**, diese enthalten 
den kompilierbaren und kommentierten Java-Code 
der Aufgabenteile **a** und **b**.  
Im Ordner **class** befindet sich entsprechend der kompilierbare Code 
in **.class**-Dateien.  
Im Ordner **test** befindet sich die Testdokumentation bzw.
die Ausgabe der Tests.
## Bearbeitung
Das Fahren der Loks wurde mittels **sleep()**-Methoden implementiert,
um zu zeigen, dass die Loks auch bei unterschiedlichen
Geschwindigkeiten nur abwechselnd den gemeinsamen
Streckenabschnitt befahren, wurden einige mögliche Testfälle 
mit verschiedenen Geschwindigkeitsunterschieden angelegt.  
Die Geschwindigkeit der Loks wird über die Zeit, die diese 
zum Durchfahren der Abschnitte benötigen, festgelegt.
Die Ausgaben sind zur besseren Lesbarkeit bei Lok 1 eingerückt.
### Aufgabenteil a)
Gemäß der Aufgabenstellung wurde im Aufgabenteil **a)** das
Problem unter Verwendung des Erzeuger-Verbraucher Konzepts 
gelöst.
### Aufgabenteil b)
Im Aufgabenteil **b)** wurden wie gefordert private Semaphore
zur Implementierung der *enter-* und *exit-*Methoden genutzt.
