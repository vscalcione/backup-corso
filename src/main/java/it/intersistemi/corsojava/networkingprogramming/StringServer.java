package it.intersistemi.corsojava.networkingprogramming;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class StringServer {
	Socket socket = null;
	String receivedString, toSendString;
	BufferedReader inputFromClient;
	DataOutputStream outToClient;
	
	public void listen() {
		try {
			System.out.println("Server in esecuzione....");
			ServerSocket socketServer = new ServerSocket(80); //creazione di un server sulla porta 80
			socket = socketServer.accept();  /*il server in questione rimane in attesa della richiesta di un client e all'arrivo di tale, si chiude
												per dare spazio a quest'ultimo */
			socketServer.close();
			InputStreamReader streamFromClient = new InputStreamReader(socket.getInputStream()); /* oggetto che leggere la richiesta inviata dal
																								cleint */
			inputFromClient = new BufferedReader(streamFromClient);
			outToClient = new DataOutputStream(socket.getOutputStream()); //istanza di un oggetto per inviare al client la risposta richiesta
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Errore durante l'istanza del server! ");
			System.exit(1);
		}
	}
	
	public void respond() {
		try {
			receivedString = inputFromClient.readLine(); //viene presa la stringa ricevuta dal client attraverso un buffer
			toSendString = "<html><body bgcolor='yellow'><h1><center> Buongiorno dal Server <br> " + receivedString
					+ " </center><h1></body></html>"; //creazione della stringa da reinviare al client attraverso un p� di HTML
			outToClient.writeBytes(toSendString+"\n"); //invio effettivo della stringa al client
			socket.close(); //chiusura del socket
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Errore durante la comunicazione col client! ");
			System.exit(1);
		}
	}
}
