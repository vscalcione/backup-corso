package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class SuccessioneFibonacci {
	public static void main(String[] args) throws IOException, IllegalArgumentException{
		generateFibonacciSequenceByNumber();
	}
	public static void generateFibonacciSequenceByNumber() throws IOException {
		BufferedReader console=new BufferedReader (new InputStreamReader(System.in));
		System.out.println("************ Successione di Fibonacci ************************");
		int rangeValues = ConsoleInputInteri.leggiIntero(console, "Inserire un valore: ");
		Random rndValue = new Random();
		int value = rndValue.nextInt(rangeValues);
		System.out.println("Successione di Fibonnacci per: "+value);
		int value1 = 1, value2 = 1, value3 = 2;
		int value4;
		System.out.print(" "+value1);
		System.out.print(" "+value2);
		while(value3<value) {
			value4 = value1 + value2;
			System.out.print(" "+value4);
			value1 = value2;
			value2 = value3;
			value3 = value3 + 1;
		}	
	}
}