package esercitazioneSegreteriaUniversitaria.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import esercitazioneSegreteriaUniversitaria.Exam;

public class UtilityEsame {

	private static List<Exam> listaEsami = new ArrayList<Exam>();

	public static void inserisciEsame(Scanner reader) {

		Exam s = new Exam();

		System.out.println("Inserisci nome esame");
		String nomeEsame = reader.nextLine();
		System.out.println("Inserisci codice esame");
		String codiceEsame = reader.nextLine();

		s.setExamName(nomeEsame);
		s.setExamCode(codiceEsame);

		if ((!s.getExamName().equals("")) && (!s.getExamCode().equals(""))) {
			if (s.getExamCode().equals(UtilityEsame.verificaIdentificativo())) {
				listaEsami.add(s);
				System.out.println("Esame inserito correttamente: " + s.toString());
				System.out.println("");
			} else {
				System.out.println("Codice esame gi� presente");
				System.out.println("");
			}
		} else {
			System.out.println("campi non inseriti correttamente");
		}
	}

	public static void printEsami() {
		System.out.println("Lista esami registati");

		for (Exam i : listaEsami) {

			System.out.println(i);

		}
		System.out.println("**********Fine lista*************");

	}

	public static String verificaIdentificativo() {

		String codiceEsame = null;
		for (Exam esame : listaEsami) {

			codiceEsame = esame.getExamCode();
		}
		return codiceEsame;
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
