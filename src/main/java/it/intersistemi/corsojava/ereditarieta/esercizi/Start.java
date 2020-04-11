/**
 * 
 */
package it.intersistemi.corsojava.ereditarieta.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Start {
	public static void main(String[] args) throws IOException, NumberFormatException{		
		/* ContoCorrente contoCorrente=new ContoCorrente(12345,"Vincenzo Scalcione",100, 50);
	        System.out.println("Nuovo conto: "+contoCorrente.getNumeroConto());
	        System.out.println("Saldo iniziale: "+contoCorrente.getSaldoCorrente());
	        
	        Bancomat bancomat=new Bancomat(numeroCarta, pinCode);
	        contoCorrente.aggiungiCarta(bancomat);
	      
	        boolean esitoPrelievo=contoCorrente.pre*/
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		ContoCorrente contoCorrente=new ContoCorrente(1102,"Vincenzo");
		double versamento=ConsoleInputInteri.leggiIntero(console, "Quanto vuoi versare? ");
		contoCorrente.setSaldoCorrente(versamento);
		//System.out.println(contoCorrente.getSaldoCorrente());
		
		double prelievoMain=ConsoleInputInteri.leggiIntero(console, "Quanto vuoi prelevare? ");
		if(prelievoMain>=0) {
			contoCorrente.setPrelievo(prelievoMain);
			double x=versamento - prelievoMain;
			if(x!=0 && versamento>prelievoMain) {
				System.out.println("*** Prelievo effettuato con successo ");
				System.out.println("Ora il tuo saldo è di: "+contoCorrente.getSaldoCorrente());	
			}
			else {
				System.out.println("*** Prelievo non andato a buon fine ***");
			}
		}
	}
}