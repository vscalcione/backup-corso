package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class RadiceQuadrataDiUnNumero {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Immetti un numero: ");
		double a = reader.nextDouble();
		reader.close();
		double b = (double) Math.sqrt(a);
		System.out.println("La sua radice quadrata�: "+b);
	}

}
