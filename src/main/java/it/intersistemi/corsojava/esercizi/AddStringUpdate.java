package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class AddStringUpdate {
	public static void main(String[] args) throws IOException{
		String[] arrayString = {"Uno","Due","Tre","Quattro","Cinque","Sei"};
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String stringToAdd = ConsoleInputStringa.leggiStringa(console, "Cosa vuoi aggiungere al tuo array? ");
		String[] arrayStringComplete = addString(arrayString, stringToAdd);
		System.out.println("Risultato ottenuto: ");
		for (String string : arrayStringComplete) {
			System.out.print("| "+string.toUpperCase());
		}
	}
	
	public static String[] addString (String[] arrayString, String stringToAdd) {
		String[] stringArrayComplete = new String[arrayString.length + 1];
		for (int i = 0; i < arrayString.length; i++) {
			stringArrayComplete[i] = arrayString [i];
		}
		stringArrayComplete[stringArrayComplete.length -1] = stringToAdd;
		return stringArrayComplete;
	}
}
