package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ContaZeri {
	static int number, scelta;
	static boolean result;
	public static void main(String[] args) throws IOException{
		do {
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("1. Conta se in una sequenza di valori � almeno uno 0");
			System.out.println("2. Conta quanti 0 sono presenti in una sequenza di valori ");
			scelta = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
			if(scelta < 1 || scelta > 2) {
				System.out.println("error");
			}
		}while(scelta < 1 || scelta > 2);
		if(scelta == 1) {
			result = containsAtLeast0();
			if(result == true) {
				System.out.println("La sequenza di valori presi in input contiene almeno uno 0 ");
			}else {
				System.out.println("La sequenza di valori presi in input non contiene 0");
			}	
		}
		if(scelta == 2) {
			int risultato = contains0();
			System.out.println("Nella sequenza presa in input ci sono: "+risultato+" zero/i");
		}
	}
	
	public static boolean containsAtLeast0() throws IOException {
		boolean containsAtLeast0;
		int number;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		containsAtLeast0 = false;
		do {
			number = ConsoleInputInteri.leggiIntero(console, "Inserisci numero: ");
			if(number == 0) {
				containsAtLeast0 = true;
			}
		}while(number != -1);
		return containsAtLeast0;
	}
	
	public static int contains0() throws IOException{
		int zeri = 0;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			number = ConsoleInputInteri.leggiIntero(console, "Inserisci numero: ");
			if(number == 0) {
				zeri++;
			}
		}while(number != -1);
		return zeri;
	}
}
