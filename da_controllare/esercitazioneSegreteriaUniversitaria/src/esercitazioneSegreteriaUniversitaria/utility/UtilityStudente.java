package esercitazioneSegreteriaUniversitaria.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import esercitazioneSegreteriaUniversitaria.Studente;

public class UtilityStudente {
	
	
	private static List <Studente> listaStudenti = new ArrayList<Studente>();


	
	public  static void inserisciStudente(Scanner reader) {
		
		Studente s = new Studente();
		
		System.out.println("Inserisci nome studente");
		String nome=reader.nextLine();
		System.out.println("Inserisci cognome studente");
		String cognome=reader.nextLine();
		System.out.println("Inserisci matricola studente");
		String matricola =reader.nextLine();
		
		s.setNome(nome);
		s.setCognome(cognome);
		s.setMatricola(matricola);
		
		if ((!s.getNome().equals("")) && (!s.getCognome().equals("")) && (!s.getMatricola().equals(""))  ) {
			if ( s.getMatricola().equals(UtilityStudente.verificaIdentificativo())) {
		listaStudenti.add(s);
		System.out.println("Studente inserito correttamente: "+ s.toString());
		System.out.println("");
	} else {
		System.out.println("Matricola studente già presente");
		System.out.println("");
	}
	}	
	else {
		System.out.println("campi non inseriti correttamente");
	}

		
	}
	
	public static void printStudenti() {
		System.out.println("Lista studenti registati");
		
		for (Studente i : listaStudenti) {
			
			System.out.println(i);
			
		}
		System.out.println("**********Fine lista*************");
	}

	public static String verificaIdentificativo () {
		
		String matricola = null;
		for (Studente studente : listaStudenti) {
			
			
			  matricola = studente.getMatricola();
		}
		return matricola;
	}

//	public static Object associaStudenteFacolta () {
//		
//		Object[] possibleValues = { "Filosofia", "Matematica", "Fisica" };
//
//		 Object selectedValue = JOptionPane.showInputDialog(null,
//		             "Assegna facolta", "Maschera inserimento",
//		             JOptionPane.INFORMATION_MESSAGE, null,
//		             possibleValues, possibleValues[0]);
//		
//		 return  selectedValue;
//		 
//		
//	}
//	
}
