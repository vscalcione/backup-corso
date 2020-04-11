package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputDouble;

public class EquazioneSecondoGrado {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		double a, b, c;
		a = ConsoleInputDouble.leggiDouble(console, "Inserisci x alla seconda: ");
		b = ConsoleInputDouble.leggiDouble(console, "Inserisci x: ");
		c = ConsoleInputDouble.leggiDouble(console, "Inserisci il termine noto: ");
		double result1 = (-b + (Math.sqrt(Math.pow(b,  2) - 4 * a * c))) / (2 * a);
		double result2 = (-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a);
		System.out.println("Risultato1: " + result1 +"\nRisultato2 : " + result2);
	}
}
