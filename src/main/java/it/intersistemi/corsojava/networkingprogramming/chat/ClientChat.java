package it.intersistemi.corsojava.networkingprogramming.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientChat {
	public static void main(String[] args) {
		getClientChat();
	}
	
	public static void getClientChat() {
		Socket connection = null;
		String serverName = "localhost";
		int port = 2345;
		String messageToSend;
		String receivedMessage;
		try {
			connection = new Socket(serverName, port);
			System.out.println("Connessione eseguita con successo ");
		}catch(IOException e) {
			System.out.println(e);
			System.exit(-1);
		}
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			OutputStream outputStream = connection.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader keyboard = new BufferedReader(input);
			System.out.println("Chat inizializzata. ");
			while(true) {
				messageToSend = keyboard.readLine();
				if(messageToSend.equals("FINE")) {
					break;
				}
				printWriter.println(messageToSend);
				printWriter.flush();
				receivedMessage = bufferedReader.readLine();
				System.out.println(">> "+receivedMessage);
			}
		}catch(IOException e) {
			System.out.println(e);
		}
		try {
			connection.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
