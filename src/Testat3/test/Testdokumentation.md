##Test mit manuell erstelltem File

Verbindung zum Server wird hergestellt. Server nimmt den READ-Auftrag entgegen, öffnet den manuell erstellten File, 
liest die File aus der manuell erstellten Zeile und schickt den Inhalt an den Client zurück.

    Befehl an Server senden:
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,1  
    Manuell erstellte ZServer nimmt den WRITE-Auftrag entgegen und ersetzt die leere zweite Zeile mit neuen Daten. 

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,2, Zweite Zeile!  
    SUCCESS : Line was written to file  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file, lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,3, Dritte Zeile!  
    SUCCESS : Line was written to file  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,4, Vierte Zeile!  
    SUCCESS : Line was written to file  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,4  
    Vierte Zeile!  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    WRITE ManuelCreatedFile,50, Zeile 50  
    SUCCESS : Line was written to file  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
    READ ManuelCreatedFile,50  
    Zeile 50  

    Befehl an Server senden:  
    ('READ file,lineNo' or 'WRITE file,lineNo,data' or 'x' to exit)  
