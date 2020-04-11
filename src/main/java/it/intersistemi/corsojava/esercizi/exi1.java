package it.intersistemi.corsojava.esercizi;
import java.util.Scanner;

public class exi1 {
public static void main(String[] args) { 
	Scanner sc = new Scanner(System.in); 
	int [] vettore = new int[10]; 
	
	for(int i = 0; i < vettore.length; i++) { 
		int input=0; 
		do { 
			System.out.println("Inserisci il "+(i+1)+"� un numero positivo"); 
			input=sc.nextInt(); 
			} while (input<=0); 
		vettore[i]=input; 
		} 
	for(int i=0;i<vettore.length;i++) { 
		System.out.println((i+1)+"� elemento = "+vettore[i]);
		} 
	} 
}
