package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Fattoriale {
	public static void main(String[] args) throws IOException, IllegalArgumentException{
		System.out.println("************ Fattoriale di un numero ************ ");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci il valore di cui si vuole calcolare il fattoriale: ");
		int result = calculateFactorial(value);
		System.out.println("Il fattoriale di "+value+" è: "+result);
	}
	
	/**
	 * Metodo che, preso in input un valore intero calcoli il fattoriale di quel valore
	 * @param value
	 * @return factorial
	 */
	public static int calculateFactorial(int value) {
		int factorial = 1;
		for (int i = 1; i <= value; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
