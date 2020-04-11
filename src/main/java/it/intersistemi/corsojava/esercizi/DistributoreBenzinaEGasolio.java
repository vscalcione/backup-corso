package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputDouble;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class DistributoreBenzinaEGasolio {
	public static double importo, gasolioRifornito, benzinaRifornita;
	public static void main(String[] args) throws IOException{
		int scelta, risposta;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		DistributoreBenzinaEGasolio d1 = new DistributoreBenzinaEGasolio();
		DistributoreBenzinaEGasolio d2 = new DistributoreBenzinaEGasolio();
		do {
			do {
				System.out.println("=======================");
				scelta = ConsoleInputInteri.leggiIntero(console, "Premere 1 per erogare benzina o 2 per erogare gasolio ");
				if(scelta <1 || scelta > 2) {
					System.out.println("Errore ");
				}
			} while (scelta < 1 || scelta > 2);
			if(scelta == 1) {
				importo = ConsoleInputDouble.leggiDouble(console, "Inserisci importo: ");
				d1.getBenzina(importo);
			}
			if(scelta == 2) {
				importo = ConsoleInputDouble.leggiDouble(console, "Inserisci importo: ");
				d2.getGasolio(importo);				
			}
			risposta = ConsoleInputInteri.leggiIntero(console, "L'utente vuole eseguire un'altra operazione? 1 = si, 0 = no ");
			if(risposta == 0 || risposta != 1) {
				break;
			}
		} while (risposta == 1);
	}
	public void getBenzina(double importo) {
		benzinaRifornita = (float)((float) importo / 1.330);
		System.out.println("Rifornimento di "+benzinaRifornita+" litri di benzina a 1.330 euro al litro ");
	}
	public void getGasolio(double importo) {
		gasolioRifornito = (float)((float) importo / 1.520);
		System.out.println("Rifornimento di "+gasolioRifornito+" litri di gasolio a 1.520 euro al litro ");
	}
}