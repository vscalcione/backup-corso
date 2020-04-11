package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class PrintReverseString {
	public static void main(String[] args) throws IOException{
		String string;
		String reverseString = "";
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		string = ConsoleInputStringa.leggiStringa(console, "Inserisci la tua stringa");
		System.out.println("****** Stringa originale -> "+string+" ****** ");
		for (int i = string.length() - 1; i >=  0; i--) {
			reverseString += string.charAt(i);
		}
		System.out.println("****** Stringa al contrario -> "+reverseString+" ****** ");
	}
}
