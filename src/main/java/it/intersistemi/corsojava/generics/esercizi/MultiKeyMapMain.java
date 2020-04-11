package it.intersistemi.corsojava.generics.esercizi;

import java.util.*;
import java.util.Map.Entry;

public class MultiKeyMapMain {

	public static void main(String[] args) {

		List <Employee> listaDipendenti = generaListaDipendenti();

		Map<BranchOffice, List<Employee>> mappaDipendenti = new HashMap<>();



		for (Employee dipendente : listaDipendenti) {
			BranchOffice ufficiofiliale = new BranchOffice(dipendente.getIdUfficio(), dipendente.getIdFiliale());

			List<Employee> listaSesso = mappaDipendenti.get(ufficiofiliale);
			if(listaSesso == null) {
				listaSesso= new ArrayList<>();
				mappaDipendenti.put(ufficiofiliale, listaSesso);
			}
			listaSesso.add(dipendente);
		}
		Set<Entry<BranchOffice, List<Employee>>> mappaDipendentiEntrySet = mappaDipendenti.entrySet();
        Iterator<Entry<BranchOffice, List<Employee>>> mappaDipendentiEntrySetIt = mappaDipendentiEntrySet.iterator();

        while (mappaDipendentiEntrySetIt.hasNext()) {
        	Entry<BranchOffice, List<Employee>> mappaDipendentiEntry = mappaDipendentiEntrySetIt.next();
        	List <Employee> dipendenti = mappaDipendentiEntry.getValue();
        	BranchOffice sesso = mappaDipendentiEntry.getKey();
        	System.out.println("Ecco le persone di sesso: " +sesso);
        	for(Employee p: dipendenti) {
        		String cognome= p.getCognome();
        		String nome = p.getNome();
        		String idFiliale= p.getIdFiliale();
    			String idUfficio= p.getIdUfficio();

        		System.out.println("Il cognome �: "+cognome +" Il nome �: "+nome +" La Filiale �: " +idFiliale +" L'ufficio �: " +idUfficio );


        		}
        	}
        }









	private static List<Employee> generaListaDipendenti() {
		List<Employee> dipendenti = new ArrayList<>();
		dipendenti.add(new Employee("Gertrude", "Brazof", "sx", "sxa", Sex.DONNA ));
		dipendenti.add(new Employee("Genoveffa", "Noventra", "sx", "ss,", Sex.DONNA));
		dipendenti.add(new Employee("Gertrude", "Brazof", "sx", "sxa", Sex.DONNA ));
		dipendenti.add(new Employee("Matt", "Hardy", "sx 3", "ss,", Sex.UOMO));
		dipendenti.add(new Employee("Gertrude", "Brzof", "sx3", "sxa", Sex.DONNA ));
		dipendenti.add(new Employee("Jeff", "Hardy", "swx 3", "ss,", Sex.UOMO));
		dipendenti.add(new Employee("Gertrude", "Brazof", "sx", "sxa", Sex.DONNA ));
		dipendenti.add(new Employee("Genoveffa", "Noventra", "sx", "ss,", Sex.DONNA));
		dipendenti.add(new Employee("Gertrude", "Brazof", "sx", "sxa", Sex.DONNA ));
		dipendenti.add(new Employee("Genoveffa", "Noventra", "sx", "ss,", Sex.DONNA));
		return dipendenti;

		}










	}












