package esercitazioneSegreteriaUniversitaria;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UtilityAggiungiStudenteCorso {
	
	Scanner reader = new Scanner(System.in);
	
	Map<Universita, Studente > iscrizioniAttuali = new HashMap <Universita, Studente>();

	
	public void aggiungiStudente() {
		
		Studente studente = new Studente (null,null,null,0,null);
	    studente = UtilityInserisciStudente.inserisciStudente(studente);
		
		if ( !iscrizioniAttuali.containsValue(studente)) {
			
			iscrizioniAttuali.put(Universita.Filosofia , studente);
		}
		
	}
}
