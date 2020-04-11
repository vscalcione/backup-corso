/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Spellucci
 *
 */
public class EsercizioValorizazzioniArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int intero = leggiIntero(console, "inserisci la dimensione dell'array: ");
		String[] arrayStringa = new String[intero];

		for (int i = 0; i < arrayStringa.length; i++) {
			System.out.print("inserisci il valore dell'elemento " + i + ": ");
			arrayStringa[i] = console.readLine();
		}
		for(int i = arrayStringa.length -1; i>= 0; i--) {
			System.out.print(arrayStringa[i]+ " ");
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
