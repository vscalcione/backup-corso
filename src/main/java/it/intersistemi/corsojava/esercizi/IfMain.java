package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class IfMain {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("Inserire X: ");
		double a = reader.nextDouble();
		reader.close();
		if (a == 10) {
			System.out.println("X � uguale a 10");
		} else {
			System.out.println("X � diverso da 10");
		}
	}

}
