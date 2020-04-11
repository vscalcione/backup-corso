package it.intersistemi.corsojava.incapsulamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class Bancomat {
	private int saldo, pin;
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		int saldoAttuale = ConsoleInputInteri.leggiIntero(console, "Saldo Attuale: ");
		int pin = ConsoleInputInteri.leggiIntero(console, "Imposta PIN: ");
		Bancomat bancomat = new Bancomat(saldoAttuale, pin);
		int valuePrelievo = ConsoleInputInteri.leggiIntero(console, "Quanto vuoi prelevare? "); 
		boolean esitoPrelievo = bancomat.preleva(pin, valuePrelievo);
		if(esitoPrelievo == true) {
			System.out.println("\n"+"*** Prelievo avvenuto con successo ***");
		}
		else {
			System.out.print("*** Prelievo negato. Ritirare carta entro 5 secondi");
		}		
		/*boolean esitoPrelievo1=bancomat.preleva(12345, 100);
		System.out.println("Esito con richiesta contanti superiore al saldo: "+esitoPrelievo);
		System.out.println("Esito con richiesta contanti inferiore al saldo: "+esitoPrelievo1);*/
	}
	public Bancomat(int saldo, int pin) {
		this.saldo = saldo;
		this.pin = pin;
	}
	
	public boolean preleva(int pin, int contante) {
		if(this.pin == pin && this.saldo >= contante) {
			return true;
		}
		else {
			return false;
		}
	}
}
