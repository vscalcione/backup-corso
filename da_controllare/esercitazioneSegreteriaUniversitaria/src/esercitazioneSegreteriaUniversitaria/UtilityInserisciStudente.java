package esercitazioneSegreteriaUniversitaria;

import java.util.Scanner;

public class UtilityInserisciStudente {

	         static Scanner reader;
	
	
	public static  Studente inserisciStudente (Studente studente) { // da gestire eccezioni

		studente = new Studente(null, null, null, 0, null);

		//	    Studente studente = new Studente(studente.nome , studente.cognome , studente.dataDiNascita, studente.matricola, studente.dataDiIscrizione);

	    
//		 for (int i=0; i<studente.length; i++) { 
			 
	    reader = new Scanner(System.in);
		System.out.println("Inserire anagrafica studente:");
		System.out.println("Nome:");
		studente.setNome(reader.next() ); // studente.setnome
		System.out.println("Cognome:");
		studente.setCognome(reader.next()); 
		System.out.println("Data di nascita, in ordine giorno mese ed anno:");
		studente.setDataDiNascita(new Data(reader.nextInt(), reader.nextInt(), reader.nextInt())); // dataDiNascita;
		System.out.println("Matricola:");
		studente.setMatricola(reader.nextInt());
		System.out.println("Data di iscrizione, in ordine giorno mese ed anno:");
		studente.setDataDiIscrizione(new Data(reader.nextInt(), reader.nextInt(), reader.nextInt()));// dataDiIscrizione;
		//System.out.println("Facolta'");
		//this.facolta = reader.next();
       
	//	 }
		 
		 return studente;
	}
	
	

}
