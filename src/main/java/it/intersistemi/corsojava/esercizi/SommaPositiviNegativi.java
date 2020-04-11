package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class SommaPositiviNegativi {
	public static void main(String[] args) throws IOException, NumberFormatException{
		sumPositiveAndNegative();
	}

	public static void sumPositiveAndNegative() throws IOException {
		BufferedReader console=new BufferedReader (new InputStreamReader(System.in));
		int inputValue;
		int sumPositive = 0; 
		int sumNegative = 0;
		do {
			inputValue = ConsoleInputInteri.leggiIntero(console, "Inserisci un numero positivo o negativo: ");
			if(inputValue > 0) {
				sumPositive += inputValue;
			}
			else {
				if(inputValue < 0) {
					sumNegative += inputValue;
				}
			}
		}
		while(inputValue != 0);
		System.out.println("Somma Positivo: "+sumPositive);
		System.out.println("Somma Negativo: "+sumNegative);	
	}
}
