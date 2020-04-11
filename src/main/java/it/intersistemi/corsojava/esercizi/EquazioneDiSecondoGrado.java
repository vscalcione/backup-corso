package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class EquazioneDiSecondoGrado {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("X^2: ");
		double a = reader.nextDouble();
		Scanner reader1 = new Scanner(System.in);
		System.out.print("X: ");
		double b = reader1.nextDouble();
		Scanner reader2 = new Scanner(System.in);
		System.out.print("Termine noto: ");
		double c = reader2.nextDouble();
		reader.close();
		reader1.close();
		reader2.close();
		double d = (-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
		double e = (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
		System.out.println("La prima soluzione �: " + d);
		System.out.println("La seconda soluzione �: " + e);
	}
}
