package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class GetTriangleType {
	public static void main(String[] args) throws IOException{
		getTypeTriangle();
	}
	public static void getTypeTriangle() throws IOException {
		int lato1, lato2, lato3;	
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		lato1 = ConsoleInputInteri.leggiIntero(console, "Primo Lato: ");
		lato2 = ConsoleInputInteri.leggiIntero(console, "Secondo lato: ");
		lato3 = ConsoleInputInteri.leggiIntero(console, "Terzo lato: ");
		boolean isScalenoTraingle, isEquilateroTriangle, isIsosceleTriangle;
		if(lato1 == lato2 && lato1 == lato3) {
			isEquilateroTriangle = true;
			System.out.println("Il triangolo è equilatero");
		}else if(lato1 == lato2 || lato1 == lato3 || lato2 == lato3) {
			isIsosceleTriangle = true;
			System.out.println("Il triangolo è isoscele");
		}else {
			isScalenoTraingle = true;
			System.out.println("Il triangolo è scaleno");
		}
	}
}