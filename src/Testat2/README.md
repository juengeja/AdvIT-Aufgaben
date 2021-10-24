# Testat 2
Diese Testataufgabe haben **Rebekka Miguez** und **Jannis Jüngert**
gemeinsam bearbeitet.
## Aufbau
Im Ordner **src** befinden sich die Klassen
**TCPServer** und **TCPClient**, diese enthalten
den kompilierbaren und kommentierten Java-Code
für die Server- Client-Seite.  
Im Ordner **class** befindet sich entsprechend der kompilierbare Code
in **.class**-Dateien.  
Im Ordner **test** befindet sich die Testdokumentation bzw.
die Konsolenausgabe der Tests. Zusätzlich befindet sich der 
im Testdurchlauf gefüllte **Messages**-Ordner in dem Verzeichnis.
## Bearbeitung
Der Client baut beim Start die Verbindung zum bereits
gestarteten Server auf, nach jedem Kommunikationszylus
(Nachricht senden, Antwort empfangen) muss die Verbindung erneut
aufgebaut werden.  
Mit *SAVE Nachricht* wird die Nachricht unter einem zufälligen, 
einzigartigen Schlüssel gespeichert und kann mittels *GET Schlüssel*
wieder abgerufen werden. Sollte ein Befehl falsch eingegeben 
werden oder zu sonst einem Fehler kommen, antwortet der Server 
mit *FAILED*.
Auf ein GET kommt normalerweise die Antwort *OK* mit entsprechender Nachricht,
auf ein SAVE kommt die Antwort *KEY* mit entsprechendem Schlüssel.
## Korrekte Verwendung
Zum korrekten Verwenden der Server-Client Verbindung und 
dem Speichern von Nachrichten **muss sich im user-Home-Desktop
Verzeichnis ein Ordner Namens Messages befinden**. In diesem 
werden die gesendeten Nachrichten gespeichert und können 
mit dem entsprechenden Schlüssel wieder abgerufen werden.