package esercitazioneSegreteriaUniversitaria.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import esercitazioneSegreteriaUniversitaria.Facolta;

public class UtilityFacolta {

	private static List<Facolta> listaFacolta = new ArrayList<Facolta>();

	public static void inserisciFacoltaUniversitaria(Scanner reader) {

		Facolta s = new Facolta();

		System.out.println("Inserisci nome facolta");
		String nomeFacolta = reader.nextLine();
		System.out.println("Inserisci codice facolta");
		String codiceFacolta = reader.nextLine();

		s.setNomeFacolta(nomeFacolta);
		s.setCodiceFacolta(codiceFacolta);

		if ((!s.getNomeFacolta().equals("")) && (!s.getCodiceFacolta().equals(""))) {
			if (s.getCodiceFacolta().equals(UtilityFacolta.verificaIdentificativo())) {
				listaFacolta.add(s);
				System.out.println("Facolta inserito correttamente: " + s.toString());
				System.out.println("");
			} else {
				System.out.println("Codice facolta gi� presente");
				System.out.println("");
			}
		} else {
			System.out.println("campi non inseriti correttamente");
		}
	}

	public static void printFacolta() {
		System.out.println("Lista facolta registati");

		for (Facolta i : listaFacolta) {

			System.out.println(i);

		}
		System.out.println("**********Fine lista*************");

	}

	public static String verificaIdentificativo() {

		String codiceFacolta = null;
		for (Facolta facolta : listaFacolta) {

			codiceFacolta = facolta.getCodiceFacolta();
		}
		return codiceFacolta;
	}

}
