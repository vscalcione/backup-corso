package it.intersistemi.corsojava.esercizi;
import java.util.Scanner;

public class casi {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
//		String scelta;
//		System.out.println("Inserisci Vero o Falso");
//		scelta = in.nextLine();
//			if (scelta.equalsIgnoreCase("Vero")) {                // CON IF
//			System.out.println("1");
//		} else if (scelta.equalsIgnoreCase("Falso")) {
//			System.out.println("-1");
//		} else System.out.println("Scrivi solo Vero o Falso");
			
		
//		String choice;
//		do {
//			System.out.println("Vero");                           // NOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
//			System.out.println("Falso");
//			System.out.println("Esci");
//		    System.out.println("Scrivi una delle tre opzioni");
//		    choice = in.nextLine();
//			switch(choice) {
//			case "vero": System.out.println("1"); break;
//			case "falso": System.out.println("2"); break;
//			case "esci": break;
//				}
//			}while(!choice.equalsIgnoreCase("vero") || !choice.equalsIgnoreCase("falso") || 
//		    !choice.equalsIgnoreCase("esci"));
		
		
		String scelta;
		System.out.println("Inserisci vero o falso");              // CON SWITCH
		scelta = in.nextLine();
		scelta = scelta.toLowerCase();        // PENDE STRING "SCELTA" MINUSCOLO
		switch(scelta) {
		case "vero": System.out.println("1");  break;
		case "falso": System.out.println("-1");  break;
		default : System.out.println("Errore");
		}
		}
	}
