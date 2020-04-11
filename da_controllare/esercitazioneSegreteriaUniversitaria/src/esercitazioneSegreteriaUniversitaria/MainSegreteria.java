package esercitazioneSegreteriaUniversitaria;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import esercitazioneSegreteriaUniversitaria.utility.Utility;
import esercitazioneSegreteriaUniversitaria.utility.UtilityDocente;
import esercitazioneSegreteriaUniversitaria.utility.UtilityEsame;
import esercitazioneSegreteriaUniversitaria.utility.UtilityFacolta;
import esercitazioneSegreteriaUniversitaria.utility.UtilityStudente;

public class MainSegreteria {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		while (true) {
			Utility.printMenu();
			int n = 0;
			try {
				n = Integer.valueOf(reader.nextLine());
			} catch (Exception e) {
				System.out.println("Carattere errato");
				
			}

			switch (n) {
			case 1:

				UtilityStudente.inserisciStudente(reader);

				break;
			case 2:
				System.out.println("Inserisci esame");
				
				UtilityEsame.inserisciEsame(reader);
				break;
			case 3:
				System.out.println("Inserisci facolta");
				UtilityFacolta.inserisciFacoltaUniversitaria(reader);
				break;
			case 4:
				System.out.println("Associa esame a facolta");
				break;
			case 5:
				System.out.println("Associa studente a esame");
				break;
			case 6:
				System.out.println("Associa studente a facolta");
				break;
				
			case 7:
				//System.out.println("Associa studente a facolta");
				
				UtilityStudente.printStudenti();
				break;
				
			case 8:
				System.out.println("Stampa lista esami");
				UtilityEsame.printEsami();
				
				break;
			case 9:
				System.out.println("stampa lista facolta");
				UtilityFacolta.printFacolta();
				break;
			case 10:
				System.out.println("inserisci docente");
				
				UtilityDocente.inserisciDocente(reader);
				
				break;
				
			case 11:
				System.out.println("associa docente ad esame");
				break;
				
			case 12:
				System.out.println("stampa lista docenti");
				
				UtilityDocente.printDocenti();
				break;
				
			case 100:
				break;

			default:
				System.out.println("Scelta non non consentita");
				break;
			}
			if (n == 100) {
				System.out.println("Arrivederci");
				break;
			}
		}
	}
}

// public static void main(String[] args) {
// Scanner reader = new Scanner(System.in);
//
// System.out.println("Numero di studenti da inserire");
//
// int numeroStudenti = reader.nextInt();
// Studente[] arrayDiStudenti = new Studente[numeroStudenti];
// Studente studenteN = new Studente(null, null, null);
//
// for (int i = 0; i < arrayDiStudenti.length; i++) {
//
// // Studente studente = new Studente (null, null, null, 0, null);
//
// Studente inserimento = UtilityStudente.inserisciStudente(studenteN); // ho
// dovuto rendere il metodo
// Object p = UtilityStudente.associaStudenteFacolta(); // statico
//
// System.out.println(inserimento);
// System.out.println("Iscritto alla facolta di: " + p);
//
// arrayDiStudenti[i] = inserimento;
// reader.close();
// }
//
// // for (int i = 0; i < arrayDiStudenti.length; i++) {
// //
// //
// // Studente p = arrayDiStudenti[i];
// //
// // if (p != null) {
// //
// // System.out.println("------------------------------------------");
// // System.out.println(p);
// // }
// //
// // }
//
// }
// }
