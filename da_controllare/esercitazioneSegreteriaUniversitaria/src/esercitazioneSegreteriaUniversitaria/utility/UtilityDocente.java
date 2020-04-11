package esercitazioneSegreteriaUniversitaria.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import esercitazioneSegreteriaUniversitaria.Teacher;

public class UtilityDocente {

	private static List<Teacher> listaDocenti = new ArrayList<Teacher>();

	public static void inserisciDocente(Scanner reader) {

		Teacher s = new Teacher();

		System.out.println("Inserisci nome docente");
		String nome = reader.nextLine();
		System.out.println("Inserisci cognome docente");
		String cognome = reader.nextLine();
		System.out.println("Inserisci Id docente");
		String id = reader.nextLine();

		s.setNome(nome);
		s.setCognome(cognome);
		s.setId(id);

		
		if ((!s.getNome().equals("")) && (!s.getCognome().equals("")) && (!s.getId().equals(""))  ) {
	if ( s.getId().equals(UtilityDocente.verificaIdentificativo())) {
			listaDocenti.add(s);
			System.out.println("Docente inserito correttamente: " + s.toString());
			System.out.println("");
		} else {
			System.out.println("Id Docente gi� presente");
			System.out.println("");
		}
		}	
		else {
			System.out.println("campi non inseriti correttamente");
		}
	}

	public static void printDocenti() {
		System.out.println("Lista docenti registati");

		for (Teacher i : listaDocenti) {

			System.out.println(i);

		}
		System.out.println("**********Fine lista*************");
		
		
		
	}
	public static String verificaIdentificativo () {
		
		String id = null;
		for (Teacher teacher : listaDocenti) {
			
			
			  id = teacher.getId();
		}
		return id;
	}
	// public static Object associaStudenteFacolta () {
	//
	// Object[] possibleValues = { "Filosofia", "Matematica", "Fisica" };
	//
	// Object selectedValue = JOptionPane.showInputDialog(null,
	// "Assegna facolta", "Maschera inserimento",
	// JOptionPane.INFORMATION_MESSAGE, null,
	// possibleValues, possibleValues[0]);
	//
	// return selectedValue;
	//
	//
	// }
	//
}
