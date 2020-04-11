package it.intersistemi.corsojava.networkingprogramming.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	public static void main(String[] args) {
		getServerChat();
	}
	
	public static void getServerChat() {
		Socket connection = null;
		int port = 2345;
		String messageToSend;
		String receivedMessage;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("In attesa di connessioni..... ");
			while(true) {
				connection = serverSocket.accept();
				OutputStream outputStream = connection.getOutputStream();
				PrintWriter printWriter = new PrintWriter(outputStream);
				InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader keyboard = new BufferedReader(input);
				System.out.println("Chat inizializzata ");
				while(true) {
					receivedMessage = bufferedReader.readLine();
					if(receivedMessage == null) {
						System.out.println("Il client ha chiuso la chat");
						break;
					}
					System.out.println(">> "+receivedMessage);
					messageToSend = keyboard.readLine();
					printWriter.println(messageToSend);
					printWriter.flush();
				}
			}
		}catch (IOException e) {
			System.out.println(e);
		}
		try{
			connection.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
