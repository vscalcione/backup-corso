package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class MaggioreMinore3Valori {

	public static void main(String[] args) throws IOException{
		int value1, value2, value3;
		int maxBetweenAandB, minBetweenAandB;
		int max, min;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		value1 = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		value2 = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		value3 = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		if(value1 > value2) {
			maxBetweenAandB = value1;
		}else {
			maxBetweenAandB = value2;
		}
		if(maxBetweenAandB > value3) {
			max = maxBetweenAandB;
		}else {
			max = value3;
		}
		
		if(value1 < value2) {
			minBetweenAandB = value1;
		}else {
			minBetweenAandB = value2;
		}if(minBetweenAandB < value3) {
			min = minBetweenAandB;
		}else {
			min = value3;
		}
		System.out.println("Minore: "+min+" e Maggiore: "+max);
	}
}