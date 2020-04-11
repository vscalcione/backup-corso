package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class MatriceNumerica {
	public static void main(String[] args) throws IOException, NumberFormatException {
		populateAndPrintMatrix();
	}
	
	public static void populateAndPrintMatrix() throws IOException {
		BufferedReader console=new BufferedReader (new InputStreamReader(System.in));
		int numRows=ConsoleInputInteri.leggiIntero(console,"Quante righe vuoi che abbia la tua matrice? ");
		int numColumns=ConsoleInputInteri.leggiIntero(console,"Quante colonne vuoi che abbia la tua matrice? ");
		int [][] numericMatrix = new int[numRows][numColumns];
		for(int i=0;i<numRows;i++) {
			numericMatrix[i][0]=ConsoleInputInteri.leggiIntero(console, "Inserisci valore di partenza: ");
			for(int j=1;j<numColumns;j++) {
				numericMatrix[i][j]=numericMatrix[i][j-1]+1;
			}
		}
		System.out.println("Matrice ottenuta: ");
		for(int i=0;i<numRows;i++) {
			for(int variable: numericMatrix[i]) {
				System.out.print("|"+variable+"|");
			}
			System.out.println("");
		}
	}
}
