package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Swap {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int val1 = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		int val2 = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		System.out.println("\tValore1: " + val1 + "\n\tValore2: " + val2);
		swap2Values(val1, val2);
	}
	
	public static void swap2Values(int value1, int value2) {
		int tmp = value1;
		tmp = value1;
		value1 = value2;
		value2 = tmp;
		System.out.println("Adesso i valori sono: ");
		System.out.println("\tValore1: " + value1 + "\n\tValore2: " + value2);
	}
}