package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class StudentExam {
	public static void main(String[] args) throws IOException, NumberFormatException{
		inizializeEsameStudente();
	}

	public static void inizializeEsameStudente() throws IOException {
		int votoFinale, votoProvaScritta, votoProvaPratica;
		BufferedReader console = new BufferedReader (new InputStreamReader(System.in));
		votoProvaScritta = ConsoleInputInteri.leggiIntero(console, "Voto prova scritta: ");
		votoProvaPratica = ConsoleInputInteri.leggiIntero(console, "Voto prova pratica: ");			
		votoFinale = votoProvaScritta + votoProvaPratica;
		if((votoProvaScritta <= 0 && votoFinale > 18) || (votoProvaScritta <= 0 && votoProvaPratica < 18) || (votoProvaScritta > 0 && votoFinale < 18)) {
			System.out.println("Mi dispiace, sei stato bocciato!");
		}
		else{
			if(votoFinale == 31 || votoFinale == 32) {
				System.out.println("Congratulazioni: 30 e lode");
			}
			else {
				System.out.println("Promosso e il tuo voto finale � :"+votoFinale);
			}
		}
	}
}
