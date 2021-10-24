#Testdokumentation

Z. 1: Bestehende Verbindung zum Server

Z. 2 - 3: Client sendet eine Nachricht. Server empfängt die Nachricht, dann generiert sich der Server ein Schlüssel und speichert die Nachricht in dem **Messages** Verzeichnis. Danach sendet der Server den Schlüssel ans Client zurück.

Z. 6 - 7: Client ruft die Nachricht auf, indem es den Schlüssel des entsprechende Files an den Server sendet. Der Server findet den File und sendet die Nachricht an den Client.

Z. 10 - 11: Client sendet zum zweiten Mal den gleichen Schlüssel. Server sendet die gleiche Nachricht zurück.

Z. 14 - 15: Client sendet eine leere Nachricht. Server speichert sich nicht die Nachricht und benachrichtigt den fehlgeschlagenen Vorgang.

Z. 18 - 19: Client ruft ein Nachricht auf ohne ein Schlüssel zu senden. Server schickt die Nachricht nicht zurück und benachrichtigt den fehlgeschlagenen Vorgang.

Z. 22 - 23: Client sendet eine Nachricht mit zwei Leerzeichen. Server speichert die Nachricht und sendet den Schlüssel.

Z. 26 - 27: Client erhält vom Server die Nachricht mit zwei Leerzeichen.

Z. 30 - 31: Client sendet eine Nachricht mit einem Leerzeichen. Server schickt ein **Failed** zurück.

Z. 34 - 35: Client sendet eine sehr lange Nachricht. Server speichert die Nachricht und sendet den Schlüssel.

Z. 38 - 39: Client erhält vom Server die sehr lange Nachricht.

Z. 46 - 47: Client sendet den **SAVE**-Befehl mit der Nachricht ohne ein Leerzeichen dazwischen an den Server. Server schickt ein **Failed** zurück.

Z. 50 - 51: Client sendet einen nicht existierenden Schlüssel. Server schickt ein **Failed** zurück.

Z. 54 - 59: Client sendet eine Nachricht. Server speichert die Nachricht und sendet den Schlüssel an den Client. Die gespeicherte Nachricht wird manuell im Verzeichnis verändert. Client sendet den Schlüssel und erhält vom Server die veränderte Nachricht.

Z. 62 - 63: Client sendet einen manuell erstellten Schlüssel. Server sendet die manuell erstellte Nachricht zurück.

Z. 66 - 67: Client sendet einen manuell erstellten Schlüssel, welches nicht aus Zahlen bestehet. Server sendet die manuell erstellte Nachricht zurück.
