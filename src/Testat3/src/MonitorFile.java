package Testat3.src;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class MonitorFile {

    private final String FILEPATH = "src" + File.separator + "Testat3" + File.separator + "Files";
    private final String filename;
    BufferedReader fileIn = null;
    PrintWriter fileOut = null;
    // Monitorvariablen
    boolean activeWriter = false;
    private int readcount = 0;
    private int writecount = 0;

    public MonitorFile(String filename){
        this.filename = filename;
    }

    public boolean newFile(String name) {
        // Anlegen eines neuen Files
        File file = new File(FILEPATH, name);
        try {
            return file.createNewFile();
        } catch(IOException e) {
            return false;
        }
    }

    public String readLine(int lineNr) {

        // Zeile soll gelesen werden
        startRead();
        // Datei wird eingelesen
        File file = new File(FILEPATH, filename);
        try {
            fileIn = new BufferedReader(new FileReader(file));
            for (int i = 1; i < lineNr; i++) {
                fileIn.readLine();
            }
            return fileIn.readLine();
        } catch (FileNotFoundException e) {
            return "File not found.";
        } catch (IOException e) {
            return "Line not found.";
        } finally {
            // Beenden des Lesens, schließen des Readers
            endRead();
            try {
                if(fileIn != null) {
                    fileIn.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String writeLine(int lineNr, String data) {

        // Auf der Zeile soll geschrieben werden
        startWrite();
        // Dateiobjekt wird angelegt
        File file = new File(FILEPATH, filename);

        try {
            // Wenn Datei nicht existiert und nicht angelegt werden kann, wird die Methode mit Fehlernachricht abgebrochen
            if(!file.exists() && !newFile(filename)){
                return "ERROR : File doesn't exist, couldn't create a new one.";
            }
            // Dateiinhalt in ArrayList einlesen
            List<String> fileContent = Files.readAllLines(file.toPath());
            // Wenn nötig ArrayList mit Leerzeilen auffüllen
            while(fileContent.size() < lineNr - 1){
                fileContent.add("");
            }
            // Neuen Inhalt in entsprechende Zeile einfügen
            fileContent.set(lineNr - 1, data);
            // Datei mit angepasstem Inhalt überschreiben
            fileOut = new PrintWriter(new FileWriter(file));
            for (String string : fileContent) {
                fileOut.println(string);
            }
            fileOut.flush();
            // Antwort an Client übergeben: Schreiben war erfolgreich
            return "SUCCESS : Line was written to file";

        } catch(Exception e) {
            // Wenn Exception auftritt, Fehlermeldung zurückgeben
            e.printStackTrace();
            return "ERROR : Writing to file failed";
        } finally {
            // Beenden des Schreibens, schließen des Writers
            endWrite();
            if(fileOut != null) {
                fileOut.close();
            }
        }
    }

    //Zweiter Leser-Schreiber-Problem mit Monitorkonzept bereitstellen

    private synchronized void startRead(){
        while(activeWriter || writecount > 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        readcount ++;
    }

    private synchronized void endRead(){
        readcount --;
        notifyAll();
    }

    private synchronized void startWrite(){
        writecount ++;
        while(activeWriter || readcount > 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        activeWriter = true;
    }

    private synchronized void endWrite(){
        activeWriter = false;
        writecount --;
        notifyAll();
    }
}
