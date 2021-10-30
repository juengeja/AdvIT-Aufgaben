# Testat 3
Diese Testataufgabe haben **Rebekka Miguez** und **Jannis Jüngert**
gemeinsam bearbeitet.
## Aufbau
Im Ordner **src** befinden sich die Klassen **Client**,
**MonitorAdministration**, **MonitorFile**, **RingBuffer**, 
**Server** und **Worker**. Diese enthalten den kompilierbaren und
kommentierten Java Code zu den entsprechenden Komponenten.  
Im Ordner **class** befinden sich entsprechend die .class Dateien
mit dem lauffähigen Code.  
Im Ordner **test** befinden sich die Testdokumentation, sowie
das Verzeichnis **Files**, in welchem sich die zur Dokumentation 
gehörenden Dateien befinden, die bei den Testfällen angelegt wurden.
##Bearbeitung
Beim Start des Clients wird man dazu aufgefordert, einen
Befehl zum Senden an den Server einzugeben. Wird dann ein
String eingegeben und die Eingabe mit Enter bestätigt,
verpackt der Client diese Eingabe in einem DatagramPacket
und versendet diese über UDP an den Server auf Port 5999.  
Beim Starten des Servers erstellt dieser zunächst einen
Ringpuffer und eine ArrayList, die mit WorkerThreads gefüllt 
wird. Die Größe des Puffers und die Anzahl der WorkerThreads 
hängen zusammen und können über die Variable *NUMBER_OF_WORKERS*
geändert werden. Die Threads werden dann über eine for-Schleife
gestartet.  
Nach dem Start aller Threads wartet der Server auf eingehende
DatagramPackets und gibt diese bei Erhalt in den Puffer. Die 
Worker-Threads holen sich diese Packets dann und Bearbeiten die 
enthaltenen Anfragen.  
Über die Klasse **MonitorAdministration** werden Instanzen des 
**MonitorFiles** erstellt, und über den Filename als Key ausgegeben.
In MonitorFile sind die READ- und WRITE-Zugriffe auf die einzelnen
Dateien unter Synchronisation nach Schreiber-Priorität implementiert.
Da über den Namen der Datei unterschiedliche Monitore
verwendet werden, kann gleichzeitig in unterschiedliche 
Dateien, aber nicht in dieselbe Datei geschrieben werden.
##Korrekte Verwendung
