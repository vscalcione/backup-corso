package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class UsoDeiCicli {
	public static void main(String[] args) throws IOException, NumberFormatException{
		printFirst10Numbers();
		System.out.println("");
		System.out.println("********************************");
		System.out.println("Scrivere un programma che stampi a video i primi dieci interi pari compresi fra 20 e 0, partendo da 20.");
		printFirst20PairNumbers();
		System.out.println("Scrivere un programma che stampi la tabellina del numero dato come argomento");
		BufferedReader console=new BufferedReader (new InputStreamReader(System.in));
		int numero=ConsoleInputInteri.leggiIntero(console, "Valore di cui si vuole calcolare la tabellina: ");
		printTabellina(numero);
	}
	
	private static void printFirst10Numbers() {
		System.out.println("Scrivere un programma che stampi a video i primi dieci numeri interi");
		for(int contatore=1; contatore<11; contatore++) {
			System.out.print(contatore);
		}
	}
	
	public static void printFirst20PairNumbers() {
		for(int cont=20;cont>0;cont--) {
			if(cont%2==0) {
				System.out.println("Valore pari_"+cont+": "+cont);	
			}
		}
	}
	
	public static void printTabellina(int numero) {
		System.out.println("Tabella del: "+numero);
		for(int i=0;i<=10;i++) {
			if(i==11) {
				break;
			}
			else {
				System.out.println(numero+" x "+i+" = " +numero * (i));
			}
		}
	}
}
