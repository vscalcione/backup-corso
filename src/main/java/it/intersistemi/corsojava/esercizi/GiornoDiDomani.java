package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class GiornoDiDomani {
	public static void main(String[] args) throws IOException{
		System.out.println("========================");
		getTomorrowDate();
	}
	public static void getTomorrowDate() throws IOException {
		int currentDay, currentMonth, currentYear;
		int tomorrowDay, tomorrowMonth, tomorrowYear;
		int durataCurrentMonth;
		boolean annoBisestile = false;
		final int gennaio = 1, febbraio = 2, marzo = 3, aprile = 4, maggio = 5, giugno = 6, luglio = 7, agosto = 8, settembre = 9, ottobre = 10, novembre = 11, dicembre = 12;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Inserisci la data di oggi: ");
		currentDay = ConsoleInputInteri.leggiIntero(console, "Giorno: ");
		currentMonth = ConsoleInputInteri.leggiIntero(console, "Mese: ");
		currentYear = ConsoleInputInteri.leggiIntero(console, "Anno: ");
		if (currentYear%400 == 0 || (currentYear %4 == 0 && currentYear %100 != 0)) {
			annoBisestile = true;
		}
		if(currentMonth == febbraio && annoBisestile == true) {
			durataCurrentMonth = 29;
		}else if(currentMonth == febbraio) {
			durataCurrentMonth = 28;
		}else if(currentMonth == aprile || currentMonth == giugno || currentMonth == settembre || currentMonth == novembre) {
			durataCurrentMonth = 30;
		}else {
			durataCurrentMonth = 31;
		}
		if(currentMonth == dicembre && currentDay == durataCurrentMonth) {
			tomorrowDay = 1;
			tomorrowMonth = currentMonth + 1;
			tomorrowYear = currentYear + 1;
		}else if(currentDay == durataCurrentMonth) {
			tomorrowDay = 1;
			tomorrowMonth = currentMonth + 1;
			tomorrowYear = currentYear;
		}else {
			tomorrowDay = currentDay + 1;
			tomorrowMonth = currentMonth;
			tomorrowYear = currentYear;
		}
		System.out.println("La data del giorno di domani è: "+tomorrowDay+"/"+tomorrowMonth+"/"+tomorrowYear);
	}
}