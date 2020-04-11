package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class StampaAsterisco {
	public static void main(String[] args) throws IOException, IllegalArgumentException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String string1, string2, string3;
		string1 = ConsoleInputStringa.leggiStringa(console, "Inserisci stringa: ");
		string2 = ConsoleInputStringa.leggiStringa(console, "Inserisci stringa: ");
		string3 = ConsoleInputStringa.leggiStringa(console, "Inserisci stringa: ");
		System.out.println("Stringa risultante: "+string1+"*"+string2+"*"+string3+"*");
	}
}
