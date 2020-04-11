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
public class ConsoleNumeri {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
		int intero = leggiIntero(console, "inserisci numero: ");
		System.out.println("Quadrato:"+ (intero *intero));
		
/*		boolean numeroValido = false;
	do {
	    System.out.println("inserisci un numero");
	
			String line = console.readLine();
			
			try {
			 int intero =Integer.parseInt(line);
			 //converte una stringa in un numero se riesce a farlo
			 System.out.println("Quadrato:"+ (intero *intero));
			} catch(NumberFormatException e) {
				System.out.println("numero non valido!");
				se il numero inserito non � valido richieder�
				  di reinserirlo e riprover�
				 
		};
	}while(!numeroValido);
*/
	}
    public static int leggiIntero(BufferedReader reader, String messaggio)throws IOException {
    	do{
    		System.out.println(messaggio);
    		String line = reader.readLine();
    		try {
    			return Integer.parseInt(line);
    		
    		}catch(NumberFormatException e) {}
    	}while (true);
    	
    }



}
