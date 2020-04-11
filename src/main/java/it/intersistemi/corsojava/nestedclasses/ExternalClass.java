package it.intersistemi.corsojava.nestedclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ExternalClass {
	private int x;
	public ExternalClass(int x) {
		this.x = x;
	}
	
	public class InternalClass{
		private int y;
		public InternalClass(int y) {
			this.y = y;
		}
		public void printValues() {
			System.out.println(x+" , "+y);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		ExternalClass externalClass = new ExternalClass(value);
		value = ConsoleInputInteri.leggiIntero(console, "Inserisci valore: ");
		ExternalClass.InternalClass internalClass = externalClass.new InternalClass(value);
		internalClass.printValues();
	}
}
