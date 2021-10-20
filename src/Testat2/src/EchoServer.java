package Testat2.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static final int DEFAULT_PORT = 7005;

	public static void main(String[] args) {

		int port = DEFAULT_PORT;
		PrintWriter out = null;
		Socket connection = null;
		BufferedReader networkIn = null;

		try {
			ServerSocket server = new ServerSocket(port);
			connection = server.accept();
			networkIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out = new PrintWriter(connection.getOutputStream());

			while(true) {
				try {
					out.println(networkIn.readLine());
					out.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e) {
			System.err.println(e);
		}finally {
					try {
						if(connection != null) connection.close();
					}catch(IOException e) {}
				}
	}
}
