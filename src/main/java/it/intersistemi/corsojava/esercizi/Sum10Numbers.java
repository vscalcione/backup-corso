package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Sum10Numbers {
	public static void main(String[] args) throws IOException, NumberFormatException, IllegalArgumentException{
		int number, sum = 0;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			number = ConsoleInputInteri.leggiIntero(console, "Inserisci valore_"+(i+1)+" : ");			
			sum += number;
		}
		System.out.println("La somma dei dieci numeri ricevuti in input �: "+sum);
	}
}
