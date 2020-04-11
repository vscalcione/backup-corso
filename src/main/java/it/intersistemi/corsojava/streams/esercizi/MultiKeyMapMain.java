package it.intersistemi.corsojava.streams.esercizi;

import java.util.ArrayList;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map.Entry;

import it.intersistemi.CorsoJava.Generics.Dipendente;
import it.intersistemi.CorsoJava.Generics.Sesso;
import it.intersistemi.CorsoJava.Generics.UfficioFiliale;

public class MultiKeyMapMain {

	public static void main(String[] args) {
		
		List <Dipendente> listaDipendenti = generaListaDipendenti();
		Map<UfficioFiliale, List <Dipendente>> mappaDipendenti =
				listaDipendenti.stream()
				.collect(Collectors.groupingBy(
						d -> new UfficioFiliale(d.getIdFiliale(). d.getIdUfficio()))
	};
		
		// Map<UfficioFiliale, List<Dipendente>> mappaDipendenti = new HashMap<>();
		

	
	//	for (Dipendente dipendente : listaDipendenti) {
	//		UfficioFiliale ufficiofiliale = new UfficioFiliale(dipendente.getIdUfficio(), dipendente.getIdFiliale());
			
		//	List<Dipendente> listaSesso = mappaDipendenti.get(ufficiofiliale);
		//	if(listaSesso == null) {
		//		listaSesso= new ArrayList<>();
			//	mappaDipendenti.put(ufficiofiliale, listaSesso);
		//	}
		//	listaSesso.add(dipendente);
	//	}
	//	Set<Entry<UfficioFiliale, List<Dipendente>>> mappaDipendentiEntrySet = mappaDipendenti.entrySet();
     //   Iterator<Entry<UfficioFiliale, List<Dipendente>>> mappaDipendentiEntrySetIt = mappaDipendentiEntrySet.iterator();
        
     //   while (mappaDipendentiEntrySetIt.hasNext()) {
       // 	Entry<UfficioFiliale, List<Dipendente>> mappaDipendentiEntry = mappaDipendentiEntrySetIt.next();
        //	List <Dipendente> dipendenti = mappaDipendentiEntry.getValue();
        //	UfficioFiliale sesso = mappaDipendentiEntry.getKey();
        //	System.out.println("Ecco le persone di sesso: " +sesso);
        // for(Dipendente p: dipendenti) {
        	//	String cognome= p.getCognome();
        	//	String nome = p.getNome();
        	//	String idFiliale= p.getIdFiliale();
    		//	String idUfficio= p.getIdUfficio();
        		
        	//	System.out.println("Il cognome �: "+cognome +" Il nome �: "+nome +" La Filiale �: " +idFiliale +" L'ufficio �: " +idUfficio );
        		
        			
        //		}
        //	}
       // }
	
	
	
			
			
			
		
	
	
	private static List<Dipendente> generaListaDipendenti() {
		List<Dipendente> dipendenti = new ArrayList<>();
		dipendenti.add(new Dipendente ("Gertrude", "Brazof", "sx", "sxa", Sesso.DONNA ));
		dipendenti.add(new Dipendente ("Genoveffa", "Noventra", "sx", "ss,", Sesso.DONNA));
		dipendenti.add(new Dipendente ("Gertrude", "Brazof", "sx", "sxa", Sesso.DONNA ));
		dipendenti.add(new Dipendente ("Matt", "Hardy", "sx 3", "ss,", Sesso.UOMO));
		dipendenti.add(new Dipendente ("Gertrude", "Brzof", "sx3", "sxa", Sesso.DONNA ));
		dipendenti.add(new Dipendente ("Jeff", "Hardy", "swx 3", "ss,", Sesso.UOMO));
		dipendenti.add(new Dipendente ("Gertrude", "Brazof", "sx", "sxa", Sesso.DONNA ));
		dipendenti.add(new Dipendente ("Genoveffa", "Noventra", "sx", "ss,", Sesso.DONNA));
		dipendenti.add(new Dipendente ("Gertrude", "Brazof", "sx", "sxa", Sesso.DONNA ));
		dipendenti.add(new Dipendente ("Genoveffa", "Noventra", "sx", "ss,", Sesso.DONNA));
		return dipendenti;
		
		}
	
		
			
		
		 
		
        	
        	
			
	
	}

	
	
	
	
		
	
		

	


