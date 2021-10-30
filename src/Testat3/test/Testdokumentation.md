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


##Test der Nebenläufigkeit


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

