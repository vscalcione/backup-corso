package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class MaggioreMinore {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Primo numero: ");
		double a = reader.nextDouble();
		Scanner reader1 = new Scanner(System.in);
		System.out.println("Secondo numero: ");
		double b = reader.nextDouble();
		reader.close();
		reader1.close();
		if (a > b) {
			System.out.println("Il primo numero � maggiore del secondo");
		} else if (a < b) {
			System.out.println("Il primo numero � minore del secondo");
		} else {
			System.out.println("I due numeri sono uguali");
		}
	}

}
