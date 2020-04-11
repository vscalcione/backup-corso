package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ContaNumeri {
	int value;
	public ContaNumeri(int number) {
		value = number;
	}
	public void printConta() {
		if(value >= 0) {
			System.out.println("I numeri da contare sono: "+value);
			for (int i = 0; i <= value; i++) {
				System.out.print(" "+i);
			}
		}
		else {
			System.out.println("Non conto i numeri negativi... ");
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci un valore: ");
		ContaNumeri contaNumeri = new ContaNumeri(value);
		contaNumeri.printConta();
	}

}
