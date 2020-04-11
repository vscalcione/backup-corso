package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class AgeCalculator {
	public static void main(String[] args) throws IOException{
		AgeCalculator etaPerson = new AgeCalculator();
		etaPerson.getYears();
	}
	private void getYears() throws IOException, NumberFormatException, IllegalArgumentException{
		int year = 0, month = 0, day = 0;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int scelta;
		do {
			System.out.println("Inserire la data di oggi");
			int currentYear = ConsoleInputInteri.leggiIntero(console, "Anno corrente: ");
			int currentMonth = ConsoleInputInteri.leggiIntero(console, "Mese corrente: ");
			int currentDay = ConsoleInputInteri.leggiIntero(console, "Giorno corrente: ");
			System.out.println("Data corrente: "+currentDay+"/"+currentMonth+"/"+currentYear);
			System.out.println("==========================");
			System.out.println("Inserire la tua data di nascita ");
			int birthYear =  ConsoleInputInteri.leggiIntero(console, "Anno in cui sei nato/a : ");
			int birthMonth = ConsoleInputInteri.leggiIntero(console, "Mese in cui sei nato/a : ");
			int birthDay = ConsoleInputInteri.leggiIntero(console, "Giorno in cui sei nato/a : ");
			System.out.println("Data di nascita: "+birthDay+"/"+birthMonth+"/"+birthYear);
			year = currentYear - birthYear;
			if(birthMonth > currentMonth) {
				year--;
				month = (12 + currentMonth) - birthMonth;
			}else {
				month = currentMonth - birthMonth;
			}
			if(birthDay > currentDay) {
				month--;
				day = (31 - birthDay) + currentDay;
			}
			else {
				day = currentDay - birthDay;
			}
			if(month == 0) {
				System.out.println("Hai " +year+" anni e "+day+" giorni");
			}
			else {
				System.out.println("Hai "+year+" anni e "+month+" mesi e "+day+" giorni ");
			}
			scelta = ConsoleInputInteri.leggiIntero(console, "Vuoi eseguire un altro calcolo d'età? Premi 1 per continuare ");
			if(scelta != 1) {
				System.out.println("Calcolo terminato");
				break;
			}
		}
		while(scelta == 1);
	}
}