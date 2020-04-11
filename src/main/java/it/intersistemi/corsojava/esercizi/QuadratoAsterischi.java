package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class QuadratoAsterischi {
	int value;
	public QuadratoAsterischi(int lato) {
		value = lato;
	}
	
	public void printQuadrato() {
		if(value > 0) {
			for (int j = 0; j < value; j++) {
				for (int i = 0; i < value; i++) {
					System.out.print("* ");
				}
				System.out.println(" ");
			}
		}
		else {
			System.out.println("Hai inserito un valore negativo");
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci un valore: ");
		QuadratoAsterischi quadratoAsterischi = new QuadratoAsterischi(value);
		quadratoAsterischi.printQuadrato();
	}
}