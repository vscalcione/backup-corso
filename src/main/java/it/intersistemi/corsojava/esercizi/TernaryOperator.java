package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class TernaryOperator {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int age = ConsoleInputInteri.leggiIntero(console, "Quanti anni hai? ");
		String message = (age<70) ? "Sei giovane":"Sei vecchio";
		String message2;
		if(age <= 70) {
			message2 = "Sei giovane";
		}else {
			message2 = "Sei vecchio";
		}
		System.out.println(message2);
		
		for (int i = 0, j = 100; i <= j; i++, j--) {
			System.out.println(i+" - "+j);
		}
	}
}
