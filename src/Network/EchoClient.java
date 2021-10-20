package Network;

import java.net.*;
import java.io.*;

public class EchoClient {

	public static final int serverPort = 7005; // echo Server

	public static void main(String[] args) {
		// declaring variables
		String hostname = "localhost";
		PrintWriter networkOut = null;
		BufferedReader networkIn = null;
		Socket s = null;

		try {
			s = new Socket(hostname, serverPort);
			System.out.println("Connected to Echo Server");
			networkIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			networkOut = new PrintWriter(s.getOutputStream());

			while(true) {
				String theLine = userIn.readLine();
				if(theLine.equals(".")) {break;}
				networkOut.println(theLine);
				networkOut.flush();
				System.out.println(networkIn.readLine());
			}

		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(s != null) s.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
