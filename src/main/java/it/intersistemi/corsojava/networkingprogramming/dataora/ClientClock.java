package it.intersistemi.corsojava.networkingprogramming.dataora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientClock {
	public static void main(String[] args) {
		Socket connection;
		String serverName = "localhost";
		int port = 3333;
		InputStream inputStream;
		InputStreamReader inputStreamReader;
		BufferedReader bufferedReader;
		try {
			connection = new Socket(serverName, port);
			System.out.println("Connessione aperta ");
			inputStream = connection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			
			//Vengono prelevati i dati dal server in questione
			String clock = bufferedReader.readLine();
			System.out.println("Data e ora del server "+clock);
			bufferedReader.close();
			connection.close();
			System.out.println("Connessione chiusa");
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
