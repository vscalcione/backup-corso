package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class GiocoIndovinaNumero {
	public static void main(String[] args) throws IOException{
		inizializeGame();
	}
	public static void inizializeGame() throws IOException {
		int chosenNumber, attempt, performedAttemps;
		final int MAX = 100, FINE = 0;
		Random rndValue = new Random();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		chosenNumber = (int) rndValue.nextInt(MAX+1);
		System.out.println("Ho pensato ad un numero intero compreso fra 1 e "+MAX);
		System.out.println("Indovina quale numero ho pensato. "+"\n"+"Ricorda che puoi digitare "+FINE+" per concludere il gioco ");
		performedAttemps = 1;
		System.out.println("==========================");
		System.out.println("Tentativo_"+performedAttemps);
		attempt = ConsoleInputInteri.leggiIntero(console, "Indovina il numero: ");
		while(attempt != chosenNumber && attempt != FINE) {
			if(attempt < chosenNumber) {
				System.out.println(attempt+" è troppo basso");
			}else {
				System.out.println(attempt+" è troppo alto ");
			}
			performedAttemps++;
			System.out.println("====================");
			System.out.println("Tentativo_"+performedAttemps);
			attempt = ConsoleInputInteri.leggiIntero(console, "Indovina il numero: ");
		}
		if(attempt == chosenNumber) {
			System.out.println("Bravo. Hai indovinato il numero facendo "+performedAttemps+" tentativi! ");
		}else {
			System.out.println("Il numero che avevp sceòtp era: "+chosenNumber);
			System.out.println("E' stato un piacere giocare con te ");
		}
	}
}