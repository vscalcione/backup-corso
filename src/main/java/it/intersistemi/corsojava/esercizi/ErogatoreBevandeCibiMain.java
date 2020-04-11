package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputFloat;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;

public class ErogatoreBevandeCibiMain {
	static float importo;
	float resto;
	boolean distributoreStatus = false;
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	public void accendiErogatore(){
		distributoreStatus = true;
	}
	public void spegniErogatore(){
		distributoreStatus = false;
	}
	public void ErogaCaffe (float importo) throws NumberFormatException, IOException{
		float resto;
		importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
		if(importo < 0.80){
			while(importo < 0.80){
				System.out.print("Importo troppo basso. Inserire altre monete ");
				importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
			}
		}
		if(importo == 0.80){
			System.out.println("Resto non erogabile ");
		}
		resto=(float)(importo - 0.80);
		System.out.println("Bevanda erogata ");
		System.out.println("Il resto è di: "+resto+" euro ");
	}
	public void erogaThea (float importo) throws NumberFormatException, IOException{
		float resto;
		importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
		if(importo < 1.10){
			while(importo < 1.10){
				System.out.print("Importo troppo basso. Inserire altre monete. ");
				importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
			}
		}
		if(importo == 1.10){
			System.out.println("Resto non erogabile");
		}
		resto=(float) (importo - 1.10);
		System.out.println("Bevanda erogata ");
		System.out.println("Il resto è di: "+resto+" euro ");
	}
	public void erogaAranciata (float importo) throws NumberFormatException, IOException{
		importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
		if(importo < 1.20){
			while(importo<1.20){
				System.out.print("Importo troppo basso. Inserire altre monete ");
				importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
			}
		}
		if(importo == 1.20){
			System.out.println("Resto non erogabile");
		}
		resto=(float)(importo - 1.20);
		System.out.println("Bevanda erogata ");
		System.out.println("Il resto è di: "+resto+" euro ");
	}
	public void erogaPanino (float importo) throws NumberFormatException, IOException{
		importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
		if(importo < 1.40){
			while(importo < 1.40){
				System.out.print("Importo troppo basso. Inserire altre monete ");
				importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
			}
		}
		if(importo == 1.40){
			System.out.println("Resto non erogabile");
		}
		resto=(float)(importo - 1.40);
		System.out.println("Bevanda erogata ");
		System.out.println("Il resto è di: "+resto+" euro ");		
	}
	public void erogaTramezzino (float importo)throws NumberFormatException, IOException{
		importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
		if(importo < 1.60){
			while(importo < 1.60){
				System.out.print("Importo troppo basso. Inserire altre monete ");
				importo = ConsoleInputFloat.leggiFloat(console, "Inserire importo: ");
			}
		}
		if(importo == 1.60){
			System.out.println("Resto non erogabile");
		}
		resto=(float)(importo - 1.60);
		System.out.println("Bevanda erogata ");
		System.out.println("Il resto è di: "+resto+" euro ");
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		int scelta, var;
		ErogatoreBevandeCibiMain ErogatoreBevande = new ErogatoreBevandeCibiMain();
		ErogatoreBevandeCibiMain ErogatoreCibi = new ErogatoreBevandeCibiMain();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		if (ErogatoreBevande.distributoreStatus == false){
			do{
				scelta = ConsoleInputInteri.leggiIntero(console, "ErogatoreBevande spento. Premere 1 per accenderlo ");
				if(scelta != 1){
					System.out.print("Error");
				}
			}
			while(scelta != 1);
			ErogatoreBevande.accendiErogatore();
			do{
				System.out.println("Premere 1 per erogare un caffè ");
				System.out.println("Premre 2 per erogare un thea ");
				System.out.println("Premere 3 per erogare un'aranciata ");
				var = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
				if(var<1 || var>3){
					System.out.println("Error");
				}
			}
			while(var<1 || var>3);
			if (var == 1){
				System.out.println("Erogazione caffè ");
				ErogatoreBevande.ErogaCaffe(importo);
			}
			if (var == 2){
				System.out.println("Erogazione thea ");
				ErogatoreBevande.erogaThea(importo);
			}
			if (var == 3){
				System.out.println("Erogazione aranciata ");
				ErogatoreBevande.erogaAranciata(importo);
			}
		}
		else{
			do{
				System.out.println("Premere 1 per erogare un caffè ");
				System.out.println("Premere 2 per erogare un thea ");
				System.out.println("Premere 3 per erogare un'aranciata ");
				var = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
				if (var<1 || var>3){
					System.out.print("Error");;
				}
			}
			while(var<1 || var>3);
			if (var == 1){
				System.out.println("Erogazione caffè ");
				ErogatoreBevande.ErogaCaffe(importo);
			}
			if (var == 2){
				System.out.println("Erogazione thea ");
				ErogatoreBevande.erogaThea(importo);
			}
			if (var == 3){
				System.out.println("Erogazione aranciata ");
				ErogatoreBevande.erogaAranciata(importo);
			}
		}
		if (ErogatoreCibi.distributoreStatus==false){
			do{
				scelta = ConsoleInputInteri.leggiIntero(console, "ErogatoreCibi spento. Premere 1 per accenderlo ");
				if(scelta != 1){
					System.out.print("Error");
				}
			}
			while (scelta != 1);
			ErogatoreCibi.accendiErogatore();
			do{
				System.out.println("Premere 1 per erogare un panino ");
				System.out.println("Premere 2 per erogare un tramezzino ");
				var = ConsoleInputInteri.leggiIntero(console, "Scelta: ");
				if(var<1 || var>2){
					System.out.print("Error");
				}
			}
			while(var<1 || var>2);
			if (var == 1){
				System.out.println("Erogazione panino ");
				ErogatoreCibi.erogaPanino(importo);
			}
			if (var == 2){
				System.out.println("Erogazione tramezzino ");
				ErogatoreCibi.erogaTramezzino(importo);
			}
		}
		ErogatoreBevande.spegniErogatore();
		ErogatoreCibi.spegniErogatore();
	}
}