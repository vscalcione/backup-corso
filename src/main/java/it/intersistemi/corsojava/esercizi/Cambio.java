package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class Cambio {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Immetti un numero compreso tra 0 e 99: ");
		int a = reader.nextInt();
		reader.close();
		int b;
		if (a >= 50 && a <99) {
			System.out.println("Una moneta da 50 cent");
			b = (a - 50);
		} else {
			System.out.println("Nessuna moneta da 50 cent");
			b = a;
		}
		int c;
		if (b >= 40) {
			System.out.println("Due monete da 20 cent");
			c = (b - 40);
		} else if (b >= 20 && b < 40) {
			System.out.println("Una moneta da 20 cent");
			c = b - 20;
		} else {
			System.out.println("Nessuna moneta da 20 cent");
			c = b;
		}
		int d;
		if (c >= 10) {
			System.out.println("Una moneta da 10 cent");
			d = (c - 10);
		} else {
			System.out.println("Nessuna moneta da 10 cent");
			d = c;
		}
		int e;
		if (d >= 5) {
			System.out.println("Una moneta da 5 cent");
			e = (d - 5);
		} else {
			System.out.println("Nessuna moneta da 5 cent");
			e = d;
		}
		int f;
		if (e >= 4) {
			System.out.println("Due monete da 2 cent");
			f = (e - 4);
		} else if (e >= 2 && e < 4) {
			System.out.println("Una moneta da 2 cent");
			f = (e - 2);
		} else {
			System.out.println("Nessuna moneta da 2 cent");
			f = e;
		}
		if (f == 1) {
			System.out.println("Una moneta da 1 cent");
		} else {
			System.out.println("Nessuna moneta da 1 cent");
		}

	}

}
