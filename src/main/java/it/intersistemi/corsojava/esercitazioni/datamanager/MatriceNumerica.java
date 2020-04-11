/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Spellucci
 *
 */
public class MatriceNumerica {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		
		int righe =leggiIntero(console, "inserisci quantita riga: ");
		
		int colonne = leggiIntero(console, "inserisci quantit� colonne: ");
		
		int[][] matrice= new int[righe][colonne];
		
		for(int i= 0; i < righe; i++) {
			matrice[i][0] = leggiIntero(console, "inserisci il primo numero della colonna " +i);
			for (int j = 1; j < colonne; j++) {
				matrice[i][j] = matrice[i][j-1] + 1;
			}
		}
		for(int i= 0; i< righe; i++) {
			for (int attuale : matrice[i]) {
				System.out.print("| " + attuale + " | ");
			}
			System.out.println("");
		}
		
		
		
		
		}
		
		

	
	public static int leggiIntero(BufferedReader reader, String messaggio) throws IOException {
		do {
			System.out.println(messaggio);
			String line = reader.readLine();
			try {
				return Integer.parseInt(line);

			} catch (NumberFormatException e) {
			}
		} while (true);
}
}
