package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class AddString {
	static String stringa = "";
	static String [] arrayStringa = new String [10]; //{"uno","due","tre","quattro","cinque","sei"};	
	public static void main(String[] args) throws IOException, Exception{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		stringa = ConsoleInputStringa.leggiStringa(console, "Inserire valore da aggiungere alla coda del nostro array: ");
		System.out.print("\n");
		System.out.println("Risultato ottenuto: ");
		addString(stringa, arrayStringa);
	}
	
	public static String[] addString (String s, String []a) {
		for(int i=0; i < a.length; i++) {
			Random valueRnd=new Random();
			a[i] = valueRnd.nextInt(100)+"";
			if(i == a.length - 1) {
				a[i] = s;
			}
			System.out.print("| "+a[i]);
		}
		return a;
	}
}
