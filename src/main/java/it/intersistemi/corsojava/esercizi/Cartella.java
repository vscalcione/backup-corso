package it.intersistemi.corsojava.esercizi;

import java.util.Arrays;
import java.util.Random;

public class Cartella {
	public static void main(String[] args) {
		checkNumbers();
	}
	
	public static void checkNumbers() {
		int cont = 0, var = 0;
		Random random = new Random();
		int[][] cartella = new int[3][5];
		for(int i = 0; i < cartella.length; i++) {
			for(int j = i + 1; j < cartella.length; j++) {
				cartella[i][j] = random.nextInt(90)+1;
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				var = random.nextInt(90)+1;
				if(cartella[i][j] == var) {
					cont++;
					if(cont == 2) {
						System.out.println("AMBO!");
					}else {
						if(cont == 3) {
							System.out.println("TERNO!");
						}else {
							if(cont == 4) {
								System.out.println("QUATERNA!");
							}else {
								if(cont == 5) {
									System.out.println("CINQUINA!");
								}
							}
						}
					}
					if(cartella[i][j] != var) {
						System.out.println("null");
					}
				}
			}
		}
	}
}