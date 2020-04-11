package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class StampaMultipli {
	public static void main(String[] args) throws IOException, IllegalArgumentException, NumberFormatException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int value = ConsoleInputInteri.leggiIntero(console, "Inserire valore di cui si vuole calcolare i multipli: ");
		int tmp = 0;
		int rangeValues = ConsoleInputInteri.leggiIntero(console, "Inserire limite di ricerca dei multipli di "+value+" : ");
		for (int i = value; i <= rangeValues ; i+=value) {
			tmp++;
			System.out.println("Multiplo_"+tmp+" : "+i);
		}
		System.out.println("Sono stati trovati "+tmp+" multipli di "+value+" fino al valore: "+rangeValues);
	}
}
