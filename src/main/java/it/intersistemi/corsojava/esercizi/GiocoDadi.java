package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class GiocoDadi {
	public static void main(String[] args) throws IOException, IllegalArgumentException, NumberFormatException{
		int scelta, risposta;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Dado dado = new Dado();
		do {
			do {
				scelta = ConsoleInputInteri.leggiIntero(console, "Premere 1 per eseguire il lancio dei dadi ");
				if(scelta != 1) {
					System.out.println("Error");
				}
			}
			while(scelta != 1);
			int firstLaunch = dado.getFirstDado();
			int secondLaunch = dado.getSecondDado();
			int resultLaunch = firstLaunch + secondLaunch;
			System.out.println("--------------------");
			System.out.println("Il risultato del lancio è: "+resultLaunch);
			risposta = ConsoleInputInteri.leggiIntero(console, "Vuoi lanciare di nuovo? 1 = si ");
			if(risposta != 1) {
				System.out.println("Error");
				break;
			}
		} while (risposta == 1);
	}
	public static class Dado{
		public int getFirstDado() {
			int lancio = (int) (1 + 12 * Math.random());
			System.out.println("Primo dado: "+lancio);
			return lancio;
		}
		public int getSecondDado() {
			int lancio = (int) (1 + 12 * Math.random());
			System.out.println("Secondo dado: "+lancio);
			return lancio;
		}
	}
}