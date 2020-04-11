package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputDouble;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class CalcolatriceScientifica {
	public static void main(String[] args) throws IOException, IllegalArgumentException, NumberFormatException{
		int scelta, risposta;
		double numero1, numero2, numero;
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		CalcolatriceScientifica calcolatriceScientifica = new CalcolatriceScientifica();
		do {
			do {
				printCalcolatriceMenu();
				scelta = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
			} while (scelta < 1 || scelta > 8);
			if(scelta == 1) {
				System.out.println("Somma");
				numero1 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				numero2 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Somma: "+calcolatriceScientifica.sum(numero1, numero2));
			}
			if(scelta == 2) {
				System.out.println("Differenza");
				numero1 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				numero2 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Differenza: "+calcolatriceScientifica.difference(numero1, numero2));				
			}
			if(scelta == 3) {
				System.out.println("Prodotto");
				numero1 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				numero2 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Prodotto: "+calcolatriceScientifica.product(numero1, numero2));
			}
			if(scelta == 4) {
				System.out.println("Divisione");
				numero1 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				numero2 = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Divisione: "+calcolatriceScientifica.division(numero1, numero2));
			}
			if(scelta == 5) {
				System.out.println("Fattoriale");
				numero = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Fattoriale: "+calcolatriceScientifica.factorial(numero));
			}
			if(scelta == 6) {
				System.out.println("Potenza ");
				numero1 = ConsoleInputDouble.leggiDouble(console, "Inserisci base: ");
				numero2 = ConsoleInputDouble.leggiDouble(console, "Inserisci esponente: ");
				System.out.println("Potenza di "+numero1+" elevata alla "+numero2+" : "+calcolatriceScientifica.pow(numero1, numero2));
			}
			if(scelta == 7) {
				System.out.println("Quadrato ");
				numero = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Quadrato di "+numero+" :"+calcolatriceScientifica.square(numero));
			}
			if(scelta == 8) {
				System.out.println("Cubo ");
				numero = ConsoleInputDouble.leggiDouble(console, "Inserisci valore: ");
				System.out.println("Quadrato di "+numero+" :"+calcolatriceScientifica.cube(numero));				
			}
			risposta = ConsoleInputInteri.leggiIntero(console, "L'utente vuole eseguire un'altra operazione? 1 = si, 0 = no ");
			if(risposta == 0  || risposta != 1) {
				break;
			}
		} while (risposta == 1);
	}
	
	public static void printCalcolatriceMenu() {
		System.out.println("-------------------------------------------");
		System.out.println("| 1. Somma ");
		System.out.println("| 2. Differenza ");
		System.out.println("| 3. Prodotto ");
		System.out.println("| 4. Quoziente ");
		System.out.println("| 5. Fattoriale di un numero ");
		System.out.println("| 6. Potenza ");
		System.out.println("| 7. Quadrato di un numero ");
		System.out.println("| 8. Cubo di un numero ");
		System.out.println("----------------------------------------------");
	}
	
	public double sum (double number1, double number2) {
		return number1 + number2;
	}
	
	public double difference (double number1, double number2) {
		return number1 - number2;
	}
	
	public double product (double number1, double number2) {
		return number1 * number2;
	}
	
	public double division (double number1, double number2) {
		if(number1 == 0 || number2 == 0) {
			return -1;
		}else {
			return (number1 / number2);
		}
	}
	
	public double factorial  (double number) {
		if(number == 0) {
			return 1;
		}else {
			return (number * factorial (number-1));
		}
	}

	public double pow(double base, double exponent) {
		double result;
		if(exponent <= 0) {
			return 1;
		}else {
			result = Math.pow(base, exponent);
			return result;
		}
	}
	
	public double square (double number) {
		return Math.pow(number, 2);
		
	}

	public double cube (double number) {
		return Math.pow(number, 3);
	}
}