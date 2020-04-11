package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class ConvertitoreBinarioDecimale{
	private int convertedValue;
	private double tmp, decimalCode;
	public static void main(String[] args) throws IOException{
		String choose="";
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("\n ============= Convertitore Binario-Decimale ============= ");
			int codeLength = ConsoleInputInteri.leggiIntero(console, "Quanto è lungo il codice binario da convertire: ");
			String code = ConsoleInputStringa.leggiStringa(console, "Inserisci codice: ");
			if(code.contains("0") || code.contains("1")) {
				ConvertitoreBinarioDecimale convertitore = new ConvertitoreBinarioDecimale();
				System.out.println("Il numero decimale corrispondente a: "+code+" e': "+convertitore.converterBinaryDecimal(code, codeLength));
				choose = ConsoleInputStringa.leggiStringa(console, "Vuoi convertire un altro numero? ");
				if(choose.equals("si") == false) {
					break;
				}
			}
			else {
				System.out.println("Errore. Inserimento non consentito");
			}
		}while(choose.equals("si"));
	}
	public double converterBinaryDecimal(String insertString, int value) {
		for (int i = 0; i < value; i++) {
			String framment = insertString.substring((value - 1) - i, value - i);
			if(framment.equals("0")) {
				convertedValue = 0;
			}else {
				convertedValue = 1;
			}
			double pow = Math.pow(2.0, i);
			tmp = convertedValue * pow;
			decimalCode = decimalCode + tmp;
		}
		return decimalCode;
	}
}