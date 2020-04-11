package it.intersistemi.corsojava.matrici;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Average2Matrici {
	public static void main(String[] args) throws IOException{
		int matrice[][], matrice1[][];
		matrice = readMatrice();
		System.out.println("Media: "+averageMatrix(matrice));
		System.out.println("============= Altra matrice ==================");
		matrice1 = readMatrice();
		System.out.println("Media: "+averageMatrix(matrice));
	}
	
	public static float averageMatrix(int matrice[][]){
		int sum = 0;
		float average = 0;
		int numRows = matrice.length;
		int numCols = matrice[0].length;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				sum += matrice[i][j];
			}
			average = sum / (numRows * numCols);
		}
		return average;
	}
	
	public static int[][] readMatrice() throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int numRows = ConsoleInputInteri.leggiIntero(console, "Quante righe? ");
		int numCols = ConsoleInputInteri.leggiIntero(console, "Quante colonne? ");
		int matrice[][] = new int[numRows][numCols];
		Random rnd = new Random();
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				matrice[i][j] = rnd.nextInt(9)+1;
				System.out.print(matrice[i][j]+ " ");
			}
			System.out.println("");
		}
		return matrice;
	}
}
