package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class Moltiplicazione {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Primo numero: ");
		double a = reader.nextDouble();
		Scanner reader1 = new Scanner(System.in);
		System.out.println("Secondo numero: ");
		double b = reader.nextDouble();
		reader.close();
		reader1.close();
		System.out.println("Il loro prodotto �: "+(a * b));
	}
}
