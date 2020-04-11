package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class UpperCaseStrings {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int arrayLength = ConsoleInputInteri.leggiIntero(console, "Quanti elementi vuoi che abbia il tuo array? ");
		String[] array = new String[arrayLength];
		for (int i = 0; i < array.length; i++) {
			array[i] = ConsoleInputStringa.leggiStringa(console, "Elemento nella posizione ["+i+"]: ");
		}
		System.out.println("********** Elementi che iniziano con la lettera Maiuscola **********");
		isFirstLetterUpperCase(array);
	}
	
	public static void isFirstLetterUpperCase(String[] array){
		for(int i=0; i < array.length; i++) {
			if(Character.isUpperCase(array[i].charAt(0)) ) {
				System.out.println("Elemento nella posizione "+i+": "+array[i]);
			}
		}
	}
}