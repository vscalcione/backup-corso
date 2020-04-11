package it.intersistemi.corsojava.esercizi;

import java.io.Console;

public class IfMainConsole {
	public static void main(String[] args) {
		Console console = System.console();
		String valore = console.readLine("Inserisci X: ");
		int x = Integer.parseInt(valore);
		if (x == 10) {
			System.out.println("X � uguale a 10");
		} else {
			System.out.println("X � diverso da 10");
		}
	}
}
//settare la directory su bin 
//far partire con java nomePackage.NomeClasse
