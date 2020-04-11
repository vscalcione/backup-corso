package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class TriangoloAsterischi {
	public static void main(String[] args) throws IOException, IllegalArgumentException, NumberFormatException{
		int scelta;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("1. Stampa triangolo di asterischi con punta verso il basso ");
			System.out.println("2. Stampa triangolo di asterischi con punta verso l'alto ");
			System.out.println("3. Stampa triangolo di # con punta verso l'alto ");
			System.out.println("4. Stampa triangolo ribaltato di asterischi con punta verso il basso ");
			scelta = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
			if(scelta < 1 || scelta > 4) {
				System.out.println("Error");
			}
		}while(scelta <1 || scelta > 4);
		int input = ConsoleInputInteri.leggiIntero(console, "Quante righe? ");
		System.out.println(" ");
		if(scelta == 1) {
			printTriangle(input);
		}
		if(scelta == 2) {
			printTrianglebyAsterisc(input);
		}
		if(scelta == 3) {
			printTrianglebyCancelletto(input);
		}
		if(scelta == 4) {
			printTriangleRibaltato(input);
		}
	}
	public static void printTrianglebyAsterisc(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void printTrianglebyCancelletto(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("#");
			}
			System.out.println("");
		}
	}
	public static void printTriangle(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = dimension; j>i; j--) {
				System.out.print("*");
			}
			System.out.println("");
			for (int k = i+1; k < i-1; ++k) {
				System.out.print(" ");
			}
		}
	}
	public static void printTriangleRibaltato(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = dimension; j > i; j--) {
				System.out.print("*");
			}
			System.out.println("");
			for (int k = 0; k < i+1; ++k) {
				System.out.print(" ");
			}
		}
	}
}