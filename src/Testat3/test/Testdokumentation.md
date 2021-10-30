##Test mit unterschiedlichen Kommandos (TestFile1)

Verbindung zum Server wird hergestellt. Server nimmt den WRITE-Auftrag entgegen, erstellt eine neue File (TestFile1), öffnet diese und ersetzt die leere gewählte Zeile mit neuen Daten. 

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile1,1,Guten Tag!
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen, öffnet den File, liest die gewählte Zeile von der File und schickt den Inhalt an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile1,1
    Guten Tag!

Server nimmt den x-Auftrag entgegen. Die User-Eingabe wird beendet.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    x

##Test mit unterschiedlichen Dateneingaben (TestFile2)

Server nimmt den WRITE-Auftrag entgegen. Server erstellt eine neue File und ersetzt die leere Zeile mit neuen Daten.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,1,Guten Tag!
    SUCCESS : Line was written to file

Server nimmt den WRITE-Auftrag entgegen, öffnet die File und ersetzt die leere Zeile mit einer sehr hohen Zeilennummer mit neuen Daten.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,1000,Bye bye
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen und schickt den Inhalt aus einer hohen Zeilennummer an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,1000
    Bye bye

Server nimmt den WRITE-Auftrag entgegen und ersetzt die leere Zeile mit neuen Daten.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,50, Heute ist starkes Regenwetter
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen und schickt den Inhalt an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,50
    Heute ist starkes Regenwetter

Server nimmt WRITE-Auftrag entgegen, öffnet die File und überschreibt eine Zeile mit neuen Daten.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,50, Heute gibt es schönes Sonnenwetter.
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen und schickt den Inhalt der veränderten Zeile zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,50
    Heute gibt es schönes Sonnenwetter.

Server nimmt den WRITE-Auftrag entgegen und ersetzt die Zeile mit keinen Daten.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,2,
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen und schickt den Inhalt der leeren Zeile zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,2

Server nimmt den READ-Auftrag entgegen und schickt den Inhalt der leeren Zeile zurück, auch wenn diese vorher nicht überschrieben wurde.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,3

Server nimmt den WRITE-Auftrag entgegen und ersetzt die Zeile mit einer sehr langen Text.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,12,Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen und schickt die Zeile mit dem sehr langen Text an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,12
    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.

##Test mit Fehlerausgaben (FailedTest)

Server nimmt den READ-Auftrag nicht entgegen und schickt eine Fehlerausgabe an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    read FailedTest,1
    ERROR : Not a correct input!

Server nimmt den READ-Auftrag nicht entgegen und schickt eine Fehlerausgabe an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READFailedTest,1
    ERROR : Not a correct input!

Server nimmt den WRITE-Auftrag nicht entgegen und schickt eine Fehlerausgabe an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    write FailedTest2,2,Hallo
    ERROR : Not a correct input!

Server nimmt den READ-Auftrag entgegen, findet aber den File nicht und schickt deswegen den Client eine Fehlerausgabe zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ FailedTest2,4
    File not found.

Server nimmt den READ-Auftrag entgegen und schickt eine Fehlerausgabe zurück, weil diese Zeilenummer nicht existiert.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ FailedTest,-12
    ERROR : Line number must be higher than 0. -12 is not a valid lineNumber!

Server nimmt den WRITE-Auftrag entgegen und schickt eine Fehlerausgabe zurück, weil diese Zeilennummer nicht existiert.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE FailedTest,-12,Kein Text
    ERROR : Writing to file failed

##Test der Nebenläufigkeit 1 (NebenTest1)

Um die Nebenläufigkeit von READ- und WRITE-Zugriffen besser
testen zu können, wurden in den kritischen Abschnitten
der Methoden *writeLine()* und *readLine()* sleeps eingebaut,
die sie Threads im kritischen Abschnitt für 3 Sekunden in den Ruhemodus 
versetzen.  
Erzeugen einer Testdatei mit den Daten "Zweite Zeile." in der 
zweiten Zeile:

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE NebenTest1,2,Zweite Zeile.  
    SUCCESS : Line was written to file  

Nun werden 3 Clients parallel gestartet, die gleichzeitig versuchen die zweite
Zeile der Datei auszulesen:

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ NebenTest1,2

Nach 3 Sekunden (die Zeit, die jeder Thread im kritischen Abschnitt
wartet) kommt gleichzeitig die Antwort auf allen Clients:

    Zweite Zeile.

Damit konnten die READ-Anfragen parallel ausgeführt werden.

##Test der Nebenläufigkeit 2 (NebenTest2)

Ein Client schreibt in eine Datei, kurz darauf versuchen 2 
weitere Clients aus derselben Datei zu lesen:

    **Writer-Client**
    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE NebenTest2,5,Ich schreibe gerne Texte in 5. Zeilen! :)
    SUCCESS : Line was written to file

    **Reader-Client-1**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ NebenTest2,5
    Ich schreibe gerne Texte in 5. Zeilen! :)

    **Reader-Client-2**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ NebenTest2,5
    Ich schreibe gerne Texte in 5. Zeilen! :)

Die Reader warten auf den Abschluss des Writers, danach lesen sie parallel.

Ein Reader Client ließt aus einer Datei, kurz darauf versucht 
ein Writer Client in die Datei zu schreiben, direkt danach 
will ein weiterer Reader lesen:

    **Reader-Client-1**
    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ NebenTest2,3

    **Writer-Client**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE NebenTest2,3, Ich schreibe sehr spät in die dritte Zeile :(
    SUCCESS : Line was written to file

    **Reader-Client-2**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ NebenTest2,3
    Ich schreibe sehr spät in die dritte Zeile :(

Der erste Reader ließt hier eine leere Zeile aus, der Writer
wartet bis er damit fertig ist und schreibt dann in diese
Zeile. Der zweite Reader wartet darauf, dass der Writer
fertig wird und ließt die Zeile dann aus. Die Anfragen wurden innerhalb
einer Sekunde versendet, die Antworten kamen im Abstand von 
3 Sekunden.

3 Writer versuchen gleichzeitig in eine Datei zu schreiben:

    **Writer 1**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE NebenTest2,15,Writer 1 füllt Zeile 15
    SUCCESS : Line was written to file

    **Writer 2**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE NebenTest2,16,Writer 2 füllt Zeile 16!
    SUCCESS : Line was written to file

    **Writer 3**
    Befehl an Server senden: 
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE NebenTest2,17,Writer 3 füllt Zeile 17 :D
    SUCCESS : Line was written to file

Writer 1 schreibt zuerst in die Datei, Writer 2 wartet bis
Writer 1 fertig ist, Writer 3 wartet auf Writer 2. Die Datei enthält alle 3
Sätze, die Antworten kommen im Abstand von ca. 3 Sekunden.

## Test der SchreiberPriorität (SchreiberPrio)

Ein Writer schreibt in eine Datei, als nächstes möchte ein
Reader aus einer leeren Zeile dieser Datei lesen, kurz darauf
sendet ein zweiter Writer eine Anfrage in diese leere Zeile zu
schreiben:

    **Writer 1**
    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE SchreiberPrio,5,Ich schreibe zuerst und alle müssen warten! >:)
    SUCCESS : Line was written to file

    **Reader**
    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ SchreiberPrio,6
    Dieser Befehl kommt nach dem Read, wird aber vorher ausgeführt!

    **Writer 2**
    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE SchreiberPrio,6,Dieser Befehl kommt nach dem Read, wird aber vorher ausgeführt!
    SUCCESS : Line was written to file

Reader und Writer 2 müssen auf Fertigstellen von Writer 1
warten, Reader stellt seine Anfrage zuerst, kommt aber aufgrund
der Schreiberpriorität erst nach Writer 2 an die Reihe und
kann den von Writer 2 geschriebenen Text auslesen.

##Test, ob mehr als 8 Anfragen gestellt werden können (MassenTest)

Es werden mehr als 8 Anfragen (Die Puffergröße beträgt 8 und der 
Server besitzt 8 Worker-Threads) gestellt:

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,1,Erste Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,2,Zweite Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,3,Dritte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,4,Vierte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,5,Fünfte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,6,Sechste Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,7,Siebte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,8,Achte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,9,Neunte Zeile
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE MassenTest,10,Zehnte Zeile
    SUCCESS : Line was written to file

Mehr als 8 Anfragen sind möglich und werden auch abgearbeitet,
der Buffer und der Worker-Pool funktionieren also.

##Test mit manuell erstelltem File (ManuelCreatedFile)

Verbindung zum Server wird hergestellt. Server nimmt den READ-Auftrag entgegen, öffnet den manuell erstellten File, 
liest die aus der File manuell erstellten Zeile und schickt den Inhalt an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,1  
    Manuell erstellte Zeile  

Server nimmt den WRITE-Auftrag entgegen und ersetzt die leere Zeile mit neuen Daten.  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,2, Zweite Zeile!  
    SUCCESS : Line was written to file  

Server nimmt den WRITE-Auftrag entgegen und ersetzt die leere Zeile mit neuen Daten.

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file, lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,3, Dritte Zeile!  
    SUCCESS : Line was written to file  

Server nimmt den WRITE-Auftrag entgegen und ersetzt die leere Zeile mit neuen Daten.

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,4, Vierte Zeile!  
    SUCCESS : Line was written to file

Server nimmt den READ-Auftrag entgegen, öffnet den ManuelCreatedFile, liest aus der File die Zeile 4 aus und schickt den Inhalt dieser Zeile an den Client zurück.

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,4  
    Vierte Zeile!  

Server nimmt den WRITE-Auftrag entgegen und ersetzt die leere Zeile mit hoher Zeilnummer mit neuen Daten.

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,50, Zeile 50  
    SUCCESS : Line was written to file  

Server nimmt den READ-Auftrag entgegen, öffnet den ManuelCreatedFile, liest die Daten aus der hohen Zeilnummer aus und schickt den Inhalt an den Client zurück.

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,50  
    Zeile 

