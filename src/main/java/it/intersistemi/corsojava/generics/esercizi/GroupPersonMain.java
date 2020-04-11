package it.intersistemi.corsojava.generics.esercizi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GroupPersonMain {

	public static void main(String[] args) {


		List<Person> listaPersone = generaListaPersone();

		Map<Sex, List <Person>> gruppiPersone = new HashMap <>();
		for (Person persona : listaPersone) {
			Sex sesso = persona.getSesso();
	//		if(!gruppoPersone.containsKey(sesso)) {
		//		gruppiPersone.put(sesso, new ArrayList <>());
		//	}
		//	gruppiPersone.get(Sesso).add(persona);

			List<Person> listaSesso = gruppiPersone.get(sesso);
			if(listaSesso == null) {
				listaSesso= new ArrayList<>();
				gruppiPersone.put(sesso, listaSesso);
			}
			listaSesso.add(persona);
		}
		Set <Map.Entry<Sex, List<Person>>> gruppiPersoneEntrySet = gruppiPersone.entrySet();
        Iterator <Map.Entry<Sex,List<Person>>> gruppiPersoneEntrySetIt = gruppiPersoneEntrySet.iterator();

        while (gruppiPersoneEntrySetIt.hasNext()) {
        	Entry<Sex, List<Person>> gruppiPersoneEntry = gruppiPersoneEntrySetIt.next();
        	List <Person> persone = gruppiPersoneEntry.getValue();
        	Sex sesso = gruppiPersoneEntry.getKey();
        	System.out.println("Ecco le persone di sesso: " +sesso);
        	for(Person p: persone) {
        		String cognome= p.getCognome();
        		String nome = p.getNome();

        		System.out.println("Il cognome �: "+cognome +" Il nome �: "+nome);
        	}
        }
	}

	private static List<Person> generaListaPersone() {
		List<Person> persone = new ArrayList<>();
		persone.add(new Person("Gertrude", "Brazof", Sex.DONNA));
		persone.add(new Person("Genoveffa", "Noventra", Sex.DONNA));
		persone.add(new Person("Pietro", "Smusi", Sex.UOMO));
		persone.add(new Person("Piermenti", "Sfracelozzi", Sex.UOMO));
		persone.add(new Person("Masahiro", "Sakurai", Sex.UOMO));
		persone.add(new Person("Danilo", "Cuck", Sex.UOMO));
		persone.add(new Person("Nia", "Jax", Sex.DONNA));
		persone.add(new Person("Becky", "Lynch", Sex.DONNA));
		persone.add(new Person("Ale", "Bell", Sex.UOMO));
		persone.add(new Person("Ezio", "Auditore", Sex.UOMO));
		return persone;

	}

}
