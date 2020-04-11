package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class StringConcatenator{
	public static void main(String[] args) throws IOException{
		String stringa1, stringa2, stringa3; //dichiarazione delle variabili
		
		/* Inizializzazione e creazione degli oggetti per l'Input */
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		stringa1 = ConsoleInputStringa.leggiStringa(console, "Inserisci prima stringa: ");
		stringa2 = ConsoleInputStringa.leggiStringa(console, "Inserisci seconda stringa: ");
		stringa3 = ConsoleInputStringa.leggiStringa(console, "Inserisci terza stringa: ");
		concetenaStringhe(stringa1, stringa2, stringa3);
	}
	/**
	 * Metodo che prende in input 3 stringhe e le stampa contatendole fra di loro e ponendo fra una stringa e l'altra il carattere
	 * '*'
	 * @param stringa1
	 * @param stringa2
	 * @param stringa3
	 * @throws IOException
	 */
	public static void concetenaStringhe(String stringa1, String stringa2, String stringa3) throws IOException{
		char carattere = '*';
		System.out.println("Risultato ottenuto: "+stringa1+carattere+stringa2+carattere+stringa3+carattere);
	}
}