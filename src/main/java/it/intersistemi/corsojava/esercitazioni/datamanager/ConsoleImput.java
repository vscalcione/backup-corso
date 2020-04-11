/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
/**
 * 
 * @author Spellucci
 *
 */
public class ConsoleImput {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException {
	// bug in eclipse
    //	Console console = System.console();
		BufferedReader console =new BufferedReader(new InputStreamReader(System.in));
		
		boolean esci = false;
		do {
		System.out.println("inserisci un messaggio: ");
		String line = console.readLine();
		if(!line.equalsIgnoreCase("ciao")) {
			System.out.println(line);
		
		}else {
			esci = true;
		}
		} while(!esci);
		
		System.out.println("2bye");

	}

}
