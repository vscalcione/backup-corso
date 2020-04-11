package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class Sommafun {
	public static void main(String[] args) {
		
	int operatore1, operatore2 ; 
	Scanner in ; 
	in = new Scanner(System.in) ;
	do {
	System.out.println("Scrivi due numeri") ;
	operatore1 = in.nextInt() ;
	operatore2 = in.nextInt() ;
	String s = somma(operatore1, operatore2) <100 ? "La somma: "               //Se la somma � minore di 100 
	+ somma(operatore1, operatore2) + ", � minore di 100":"@@@@@@@@@@";        //restituisce la somma  
	System.out.println(s);                                                     //altrimenti @@@@@@@@
	} while(somma(operatore1,operatore2) < 100) ;
	System.out.println("La somma: " + somma(operatore1, operatore2) + " � maggiore/uguale a 100" );
	
	}
	
	static int somma (int x,int y) {
		return x + y ;
	}
}

