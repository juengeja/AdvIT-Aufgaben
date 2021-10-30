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

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,1,Guten Tag!
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,1000,Bye bye
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile,1000
    File not found.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,1000
    Bye bye

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,50, Heute ist starkes Regenwetter
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,50

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,50
    Heute ist starkes Regenwetter

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,55, Guten Tag
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,55
    Guten Tag

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,20, Heute gibt es starkes Regenwetter.
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,20
    Heute gibt es starkes Regenwetter.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    WRITE TestFile2,50, Heute gibt es schönes Sonnenwetter.
    SUCCESS : Line was written to file

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)
    READ TestFile2,50
    Heute gibt es schönes Sonnenwetter.


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



## Test der SchreiberPriorität


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

