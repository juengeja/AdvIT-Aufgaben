package Testat2.src;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {

    static final int DEFAULT_PORT = 7777;
    // Pfad, unter dem Nachrichten gespeichert werden
    static final String FILEPATH = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Messages" + File.separator;

    // Variablen initialisieren
    Socket connection = null;
    PrintWriter out = null;
    BufferedReader in = null;
    String reply = "";

    public static void main(String[] args) {
        new TCPServer();
    }

    public TCPServer() {

        ServerSocket server = null;

        try {
            server = new ServerSocket(DEFAULT_PORT);
            while (true) {
                try {
                    //Serverabfrage
                    connection = server.accept();
                    //Ein- und Ausgaberoutine
                    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    out = new PrintWriter(connection.getOutputStream());
                    //Nachricht lesen
                    String message = in.readLine();
                    // Splitten der Nachricht in Array
                    String[] messages = message.split(" ");

                    // Mögliche abgerufene Nachrichten
                    switch (messages[0]) {
                        case "SAVE":
                            if (message.length() > 5) {
                                reply = saveNewValue(message.substring(5));
                            }else{
                                reply = "FAILED";
                            }
                            break;
                        case "GET":
                            if (message.length() > 4) {
                                reply = getValue(message.substring(4));
                            }else{
                                reply = "FAILED";
                            }
                            break;
                        default:
                            reply = "FAILED";
                            break;
                    }
                    // Gesendete Nachrichten
                    out.println(reply);
                    out.flush();
                }catch (IOException e){
                    // Server soll bei Verbindungsabbruch des Clients weiterlaufen
                }finally {
                    // Verbindungen schließen
                    try {
                        if (connection != null && in != null && out != null) {
                            connection.close();
                            in.close();
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Verbindungen schließen
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getValue(String key) {
        // Nachrichtendatei hinzufügen
        File file = new File(FILEPATH, key);
        BufferedReader messageReader = null;
        try {
            // Lesezugriff der Datei
            messageReader = new BufferedReader(new FileReader(file));
            // Die Nachricht innerhalb der Datei kann gelesen werden, wenn der Zugriff erfolgreich war
            return "OK " + messageReader.readLine();
        } catch (IOException e) {
            // Die Nachricht kann nicht gelesen werden, wenn der Zugriff nicht erfolgreich war
            return "FAILED";
        } finally {
            // Reader schließen
            try {
                if (messageReader != null) {
                    messageReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String saveNewValue(String value) {
        // Erstellen eines zufälligen Schlüssels
        String key = generateKey();

        File file = new File(FILEPATH, key);
        FileWriter filewriter = null;

        try {
            // Datei speichern
            filewriter = new FileWriter(file);
            filewriter.write(value);
            filewriter.flush();
            // Key wird zurückgegeben, wenn Speichern erfolgreich war
            return "KEY " + key;
        } catch (IOException e) {
            // "FAILED" wird zurückgegeben, wenn Speichern fehlgeschlagen ist
            return "FAILED";
        } finally {
            // FileWriter schließen
            if (filewriter != null) {
                try {
                    filewriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Generieren eines noch nicht vergebenen zufälligen Schlüssels
    private String generateKey() {
        // Getting a random positive Number
        int randomNumber = new Random().nextInt();
        // Prüfen, ob generierte Zahl negativ oder bereits vergeben ist
        if (randomNumber < 0 || !getValue(Integer.toString(randomNumber)).equals("FAILED")) {
            return generateKey();
        } else {
            return Integer.toString(randomNumber);
        }
    }
}
