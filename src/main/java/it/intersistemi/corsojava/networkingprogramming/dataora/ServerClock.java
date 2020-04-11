package it.intersistemi.corsojava.networkingprogramming.dataora;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerClock {
	public static void main(String[] args){
		ServerSocket serverSocket;
		Socket connection;
		int port = 3333;
		OutputStream outputStream;
		PrintWriter printWriter;
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("In attesa di connessioni.... ");
				connection = serverSocket.accept();
				System.out.println("Connessione stabilita ");
				outputStream = connection.getOutputStream();
				printWriter = new PrintWriter(outputStream);
				Date data = new Date();
				String info = data.toString();
				printWriter.println(info);
				printWriter.close();
				connection.close();
				System.out.println("Connessione chiusa ");
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
