package it.intersistemi.corsojava.classianonime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MultikeyMapMain {

	public static void main(String[] args) {
		List<Dipendente> listaDipendenti = generaListaDipendenti();
		
		Map<UfficioFiliale, List<Dipendente>> mappaDipendenti = new HashMap<>();
		 for(Dipendente dipendente : listaDipendenti) {
			 String idfiliale= dipendente.getIdFiliale();
			 String idUfficio= dipendente.getIdUfficio();
			 UfficioFiliale filiale = new UfficioFiliale(idfiliale, idUfficio);
			 
		 List<Dipendente> listaUfficio = mappaDipendenti.get(filiale);
		 if(listaUfficio == null) {
			 listaUfficio = new ArrayList<>();
			 mappaDipendenti.put(filiale, listaUfficio);   
	}
		 listaUfficio.add(dipendente);
		 }
		 Iterator <Map.Entry<UfficioFiliale,List<Dipendente>>>  mappaDipendentiEntrySetIt =
				  mappaDipendenti.entrySet().iterator();
		 
		 while (mappaDipendentiEntrySetIt.hasNext()) {
				Entry<UfficioFiliale, List<Dipendente>> mappaDipendentiEntry = mappaDipendentiEntrySetIt.next();
				UfficioFiliale ufficio= mappaDipendentiEntry.getKey();
				List <Dipendente> dipendente = mappaDipendentiEntry.getValue();
				
				System.out.println("l'ufficio �"+ ufficio.getIdUfficio()+" "+ ufficio.getIdFiliale());
				for (Dipendente d: dipendente) {
					String cognome = d.getCognome();
					String nome= d.getNome();
				System.out.println("il cognome � "+ cognome+ " il nome � "+nome);
				}
		 }
	}
					
     private static List<Dipendente> generaListaDipendenti(){
    	 List<Dipendente> dipendenti= new ArrayList<>();
    	 dipendenti.add(new Dipendente( "Fabio","Foglia", Sesso.UOMO, " ufficio 57", "filiale via marconi"));
    	 dipendenti.add(new Dipendente( "alessandro","chinaglia", Sesso.UOMO, " ufficio 63", "filiale via s.cornelia"));
    	 dipendenti.add(new Dipendente( "luigi","di piero", Sesso.UOMO, " ufficio 57", "filiale via marconi"));
    	 dipendenti.add(new Dipendente( "marco","rossi", Sesso.UOMO, " ufficio 63", "filiale via s.cornelia"));
    	 
    	 return dipendenti;
    	
     }
}
