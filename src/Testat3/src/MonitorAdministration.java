package Testat3.src;

import java.util.HashMap;

public class MonitorAdministration {

    // Liste der erzeugten MonitorFile-Objekte zu entsprechenden Filenames
    private static HashMap<String, MonitorFile> monitorFiles = new HashMap<>();

    public static synchronized MonitorFile getMonitorFile(String filename){

        // MonitorFile zu Filename aus Liste holen
        MonitorFile monitorFile = monitorFiles.get(filename);

        if(monitorFile == null){
            // Wenn kein MonitorFile zu diesem Filename existiert, soll ein neues erzeugt und zur Liste hinzugefügt werden
            monitorFile = new MonitorFile(filename);
            monitorFiles.put(filename, monitorFile);
        }
        return monitorFile;
    }
}
