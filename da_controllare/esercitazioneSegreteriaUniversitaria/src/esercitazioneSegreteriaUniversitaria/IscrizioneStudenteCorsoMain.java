package esercitazioneSegreteriaUniversitaria;

import java.util.HashMap;
import java.util.Map;

public class IscrizioneStudenteCorsoMain {

	public static void main(String[] args) {

		int numeroStudenti = 1;
		Studente[] arrayDiStudenti = new Studente[numeroStudenti];
		Studente studenteN = new Studente(null, null, null, 0, null);

		for (int i = 0; i < arrayDiStudenti.length; i++) {

			// Studente studente = new Studente (null, null, null, 0, null);

			Studente inserimento = UtilityInserisciStudente.inserisciStudente(studenteN); // ho dovuto rendere il metodo
																							// statico

			System.out.println(inserimento);

			arrayDiStudenti[i] = inserimento;
		}

		for (int i = 0; i < arrayDiStudenti.length; i++) {

			Studente p = arrayDiStudenti[i];

			if (p != null) {

				System.out.println("Riepilogo Inserimenti");

				System.out.println(p);

			}
			
		}
		
		Map< Integer , Studente > iscrizioniAttuali = new HashMap <Integer, Studente>();
		
		Studente studente0 = new Studente ("mario","sessa", new Data (1,1,1) ,2 , new Data (1,1,1));
		Studente studente1 = new Studente ("carlo",null,null,0,null);
		Studente studente = new Studente (null,null,null,0,null);
		
		//studente = UtilityInserisciStudente.inserisciStudente(studente);
		
		iscrizioniAttuali.put(studente.getMatricola() , studente0 );
		iscrizioniAttuali.put(studente.getMatricola() , studente1 );
		//iscrizioniAttuali.put(Universita.Filosofia , studente2 );
		   
		
           studente = UtilityInserisciStudente.inserisciStudente(studente);
           
		
		if ( !iscrizioniAttuali.containsKey(studente.setMatricola(Integer))) { // questo if non è implementato bene
			
			iscrizioniAttuali.put(studente.getMatricola(), studente);
		}
		
		else {
			System.out.println("Lo studente è già iscritto alla facolta");
		}
		
		System.out.println(iscrizioniAttuali);
	}
}
