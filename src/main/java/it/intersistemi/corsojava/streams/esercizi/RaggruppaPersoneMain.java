package it.intersistemi.corsojava.streams.esercizi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RaggruppaPersoneMain {

	public static void main(String[] args) {
		
	
		List<Persona> listaPersone = generaListaPersone();
		
		Map<Sesso, List <Persona>> gruppiPersone = new HashMap <>();
		for (Persona persona : listaPersone) {
			Sesso sesso = persona.getSesso();
	//		if(!gruppoPersone.containsKey(sesso)) {
		//		gruppiPersone.put(sesso, new ArrayList <>());
		//	}
		//	gruppiPersone.get(Sesso).add(persona);
			
			List<Persona> listaSesso = gruppiPersone.get(sesso);
			if(listaSesso == null) {
				listaSesso= new ArrayList<>();
				gruppiPersone.put(sesso, listaSesso);
			}
			listaSesso.add(persona);
		}
		Set <Map.Entry<Sesso , List<Persona>>> gruppiPersoneEntrySet = gruppiPersone.entrySet();
        Iterator <Map.Entry<Sesso,List<Persona>>> gruppiPersoneEntrySetIt = gruppiPersoneEntrySet.iterator();
        
        while (gruppiPersoneEntrySetIt.hasNext()) {
        	Entry<Sesso, List<Persona>> gruppiPersoneEntry = gruppiPersoneEntrySetIt.next();
        	List <Persona> persone = gruppiPersoneEntry.getValue();
        	Sesso sesso = gruppiPersoneEntry.getKey();
        	System.out.println("Ecco le persone di sesso: " +sesso);
        	for(Persona p: persone) {
        		String cognome= p.getCognome();
        		String nome = p.getNome();
        		
        		System.out.println("Il cognome �: "+cognome +" Il nome �: "+nome);
        	}
        }
	}
	
	private static List<Persona> generaListaPersone() {
		List<Persona> persone = new ArrayList<>();
		persone.add(new Persona ("Gertrude", "Brazof", Sesso.DONNA));
		persone.add(new Persona ("Genoveffa", "Noventra", Sesso.DONNA));
		persone.add(new Persona ("Pietro", "Smusi", Sesso.UOMO));
		persone.add(new Persona ("Piermenti", "Sfracelozzi", Sesso.UOMO));
		persone.add(new Persona ("Masahiro", "Sakurai", Sesso.UOMO));
		persone.add(new Persona ("Danilo", "Cuck", Sesso.UOMO));
		persone.add(new Persona ("Nia", "Jax", Sesso.DONNA));
		persone.add(new Persona ("Becky", "Lynch", Sesso.DONNA));
		persone.add(new Persona ("Ale", "Bell", Sesso.UOMO));
		persone.add(new Persona ("Ezio", "Auditore", Sesso.UOMO));
		return persone;
		
	}

}
