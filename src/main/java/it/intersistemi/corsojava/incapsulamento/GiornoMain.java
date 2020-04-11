package it.intersistemi.corsojava.incapsulamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class GiornoMain {
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			String day = ConsoleInputStringa.leggiStringa(console, "Inserisci giorno: ");
			try {
				Giorno giorno = Giorno.valueOf(day.toUpperCase());
				System.out.println(giorno+" � "+(giorno.isFestivo()?"Festivo":"Feriale"));
			}
			catch(Exception e)	{
				System.err.println(e.getClass().getName()+": "+e.getMessage());
			}
		}
		while(true);
	}
}
