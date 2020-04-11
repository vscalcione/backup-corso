package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class UsoIf {
	public static void main(String[] args) throws IOException, IllegalArgumentException, NumberFormatException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci un valore: ");
		if(value == 10) {
			System.out.println("Il valore da te inserito � 10 ");
		}else if(value > 10) {
			System.out.println("Il valore da te inserito � maggiore di 10 --> "+value);
		}
		else {
			System.out.println("Il valore da te inserito � minore di 10 --> "+value);
		}
	}
}
