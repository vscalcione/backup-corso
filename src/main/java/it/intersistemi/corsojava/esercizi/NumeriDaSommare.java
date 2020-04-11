package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class NumeriDaSommare {
	int value;
	public NumeriDaSommare(int addendi) {
		value = addendi;
	}
	public int printSum() {
		if(value >= 0) {
			int tmpVar = 0, sum = 0;
			while (tmpVar <= value) {
				sum = sum + tmpVar;
				tmpVar = tmpVar + 1;
			}
			return sum;
		}
		return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserisci un valore: ");
		NumeriDaSommare numbersToAdd = new NumeriDaSommare(value);
		int result = numbersToAdd.printSum();
		System.out.println("La somma dei numeri precedenti a "+value+" è: "+result);
	}
}