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
public class SommaPositiviNegativi {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int interoValore;
		int sommaPositivi = 0;
		int sommaNegativi = 0;
		do {
			interoValore = leggiIntero(console, "inserisci valore: ");
			if(interoValore < 0) {
				sommaNegativi += interoValore;
			}
			else if(interoValore > 0) {
				sommaPositivi += interoValore;
			
			}
		}while(interoValore != 0);
		/*in alternativa si poteva mettere else al posto di while e metere direttamente
		 * break all'interno di else. 
		 */
		
		System.out.print("valoreN: "+ sommaNegativi +
		" valoreP: "+ sommaPositivi);
		
		
		
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
