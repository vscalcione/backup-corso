package it.intersistemi.corsojava.classianonime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RaggruppaPersoneMain {

	public static void main(String[] args) {
		 List<Persona> listaPersona = generaListaPersone();
		 
		 Map<Sesso, List<Persona>> gruppiPersone= new HashMap<>();
		 for (Persona persona : listaPersona) {
			 Sesso sesso = persona.getSesso();
			 
//			 if(!gruppiPersone.containsKey(sesso)) {
//				 gruppiPersone.put(sesso, new ArrayList<>());
//			 
//			 }
//			 gruppiPersone.get(sesso).add(persona);
		 List<Persona> listaSesso = gruppiPersone.get(sesso);
		 if(listaSesso == null) {
			 listaSesso = new ArrayList<>();
			 gruppiPersone.put(sesso, listaSesso);
		 }
		 listaSesso.add(persona);
		 }
		Set <Map.Entry<Sesso,List<Persona>>> gruppiPersoneEntrySet= gruppiPersone.entrySet();
		
		Iterator <Map.Entry<Sesso,List<Persona>>> gruppiPersoneEntrySetIt =
				gruppiPersoneEntrySet.iterator();
		
		while (gruppiPersoneEntrySetIt.hasNext()) {
			Entry<Sesso, List<Persona>> gruppoPersoneEntry = gruppiPersoneEntrySetIt.next();
			Sesso sesso= gruppoPersoneEntry.getKey();
			List <Persona> persone = gruppoPersoneEntry.getValue();
			
			System.out.println("Ecco il sesso "+ sesso);
			for (Persona p: persone) {
				String cognome = p.getCognome();
				String nome= p.getNome();
			System.out.println("il cognome � "+ cognome+ " il nome � "+nome);
			}
		}

	}
    private static List<Persona> generaListaPersone() {
    	List<Persona> persone = new ArrayList<>();
    	persone.add(new Persona("Gertrude", "Brazorf", Sesso.DONNA));
    	persone.add(new Persona("Genoveffa","Noventra", Sesso.DONNA));
    	persone.add(new Persona("Aieie","Brazof", Sesso.UOMO));
    	persone.add(new Persona("Mister","Bin", Sesso.UOMO));
    	persone.add(new Persona("Son","Goku", Sesso.UOMO));
    	persone.add(new Persona("Mia","Khalifa", Sesso.DONNA));
    	persone.add(new Persona("Sto","Cazzo", Sesso.UOMO));
    	persone.add(new Persona("Che","Neso", Sesso.UOMO));
    	persone.add(new Persona("Sello","Chounberpi", Sesso.UOMO));
    	persone.add(new Persona("Adriana","Rocky", Sesso.DONNA));
    	persone.add(new Persona("Bho","Bho", Sesso.UOMO));
    	persone.add(new Persona("Se","Vabbe", Sesso.DONNA));
    	return persone;
    	
    }
}
