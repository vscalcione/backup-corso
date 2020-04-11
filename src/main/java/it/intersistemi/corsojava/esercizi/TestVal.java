package it.intersistemi.corsojava.esercizi;

import java.util.Scanner;

public class TestVal {

public static void main(String[] args) {
		int a,b;
		Scanner in ; 
		in = new Scanner(System.in) ;
		System.out.println("Scrivi due numeri") ;
		a = in.nextInt() ;
		b = in.nextInt() ;
		System.out.println(testVal(a,b));
	}

	public static int testVal(int testVal, int target) {
		if (testVal > target) {
			return 1;
			} else if (testVal < target) {
				return -1;
				} else return 0;
		
//	    Scanner sc = new Scanner(System.in);
//	int imput = -1;
//	do {
//		System.out.println("");         // DA FINIRE
//		imput = 1;
//	}while("" != null);
//	}
}
}
