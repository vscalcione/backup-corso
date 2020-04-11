package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class PrintReverseArray {
	public static int arrayDimension = 0;
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		arrayDimension = ConsoleInputInteri.leggiIntero(console, "Inserire dimensione del tuo array: ");
		String[] arrayStringa=new String[arrayDimension];
		printReverseArray(console, arrayStringa);
	}
	
	public static void printReverseArray(BufferedReader console, String[] arrayStringa) throws IOException {
		for(int i=0;i<arrayStringa.length; i++) {
			String valueArray = ConsoleInputStringa.leggiStringa(console, "Inserisci valore nell'array: ");
			arrayStringa[i]=valueArray;
		}
		System.out.println("Stampa del tuo array al contrario ");	
		for(int i=arrayStringa.length-1; i>=0; i--) {
			System.out.print(arrayStringa[i]+" , ");				
		}
	}
}
