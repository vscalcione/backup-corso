package it.intersistemi.corsojava.esercizi;
import java.util.Scanner;

public class aVettore {
	public static void main(String[] args) {
		int op;
	    int [] vettore = new int [5];
	    Scanner in = new Scanner(System.in);
	    
	    for (int i = 0; i < vettore.length; i++) {
	    	System.out.println("Scrivi in numero da inserire nel vettore");
	    	op = in.nextInt();
	    	if (op > 0) {
	    		vettore[i] = op ; }
	    		else { System.out.println("Il dato inserito � negativo, inserisci un numero > 0");
			    i--;
	    	}
//	    	int input;                                    <------- EXI1.JAVA
//	    	do {
//	    		System.out.println("Inserisci il " + (i+1) + "� numero nel vettore");  
//	    		input = in.nextInt();
//	    	} while (input<=0);
//	    	vettore[i] = input;
//	    }
//	    for (int i = 0; i < vettore.length; i++) {
//	    	System.out.println((i + 1) + "� = " + vettore[i]);
	    }
	}
}
