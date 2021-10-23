package Testat2.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static final int serverPort = 7777; // Server Port

	public static void main(String[] args) {
		// Variablen deklarieren
		String hostname = "localhost";
		PrintWriter networkOut = null;
		BufferedReader networkIn = null;
		Socket s = null;

		try {
			while(true) {
				// Verbindung zum Server aufbauen
				s = new Socket(hostname, serverPort);
				System.out.println("Connected to Server");
				// Reader und Writer initialisieren
				networkIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
				networkOut = new PrintWriter(s.getOutputStream());
				// Eingabe lesen, bei "." schließt sich der Client
				String theLine = userIn.readLine();
				if(theLine.equals(".")) {break;}
				// Nachricht an Server senden
				networkOut.println(theLine);
				networkOut.flush();
				// Antwort ausgeben
				System.out.println(networkIn.readLine());
			}

		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				// Verbindungen schließen
				if(s != null && networkOut != null) {
					s.close();
					networkOut.close();
					networkIn.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
