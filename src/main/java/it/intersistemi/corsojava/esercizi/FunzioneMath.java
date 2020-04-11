package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class FunzioneMath {
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader console=new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Scrivere un programma che stampi a video 10 numeri casuali compresi fra 1 e 10 (estremi inclusi");
		generaNumeriRandom();
		System.out.println("************************************");
		System.out.println("Scrivere un programma che calcoli la radice quadrata di un numero ricevuto come argomento ");
		int numero=ConsoleInputInteri.leggiIntero(console, "Inserisci argomento radice quadrata: ");
		calcolaRadiceQuadrata(numero);
		System.out.println("************************************");
		arrayValoriRandom();
		randomValueContinue();
	}

	public static void generaNumeriRandom() {
		int randomNumber;
		for(int i=0; i<=10; i++) {
			randomNumber=(int)(Math.random()*10+1);
			System.out.print(" "+randomNumber);
		}
		System.out.println("");
	}
	
	public static void calcolaRadiceQuadrata(int numero) {
		float radice=(float) Math.sqrt(numero);
		System.out.println("Radice quadrata di"+numero+" �: "+radice);
	}
	
	public static void arrayValoriRandom() {
		int[] arrayIntRandom=new int[10];
		for(int i=0;i<10;i++) {
			arrayIntRandom[i]=(int)(Math.random()*20);
			System.out.print(" | "+arrayIntRandom[i]);
		}
	}
	
	public static void randomValueContinue() {
		while(true) {
			int value=(int)(Math.random()*15+1);
			if(value%3==0) {
				break;
			}
			System.out.println("");
			System.out.print(value);
		}
	}
}
