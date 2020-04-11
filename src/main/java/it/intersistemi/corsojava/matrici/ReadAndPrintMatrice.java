package it.intersistemi.corsojava.matrici;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ReadAndPrintMatrice {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int numRows = ConsoleInputInteri.leggiIntero(console, "Quante righe? ");
		int numCols = ConsoleInputInteri.leggiIntero(console, "Quante colonne? ");
		int matrice[][] = new int[numRows][numCols];		
		readMatrice(matrice,numRows, numCols);
		System.out.println("\n");
		printMatrice(matrice,numRows, numCols);
	}
	
	public static void readMatrice(int[][] matrice, int numRows, int numCols) throws IOException{
		Random rnd = new Random();		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0 ; j < numCols; j++) {
				matrice[i][j] = rnd.nextInt(9)+1;
			}
		}
	}
	public static void printMatrice(int[][] matrice, int numRows, int numCols) {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print(matrice[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
