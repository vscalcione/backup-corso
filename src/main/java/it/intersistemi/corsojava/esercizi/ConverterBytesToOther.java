package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputFloat;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class ConverterBytesToOther {
	 public static void main(String[] args) throws IOException{
		 double variable;	
		 BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println(" *************** Convertitore Byte to Qualcosa *************** ");
		 String scelta = "";
		 do {
			 variable = ConsoleInputFloat.leggiFloat(console, "Quale grandezza vuoi convertire (partendo da Byte)? ");
			 System.out.println("Risultato: "+byteToOther(variable, 2));
			 scelta = ConsoleInputStringa.leggiStringa(console, "Vuoi eseguire un'altra conversione? ");
			 if(!scelta.equals("si")) {
				 break;
			 }
		 }while(scelta.equals("si"));
	 }
	 
	 public static String byteToOther(double bytes, int digits) {
		 String[] dataDimension = {"bytes", "KiloBytes", "MegaBytes", "GigaBytes", "TeraBytes", "PetaBytes", "EtaBytes", "ZetaBytes", "YetaBytes" };
		 int i = 0;
		 double initialInput = 0.0;
		 for (i = 0;  i < dataDimension.length;  i++) {
	         if (bytes < 1024) {
	             break;
	         }
	         initialInput = bytes;
	         bytes = bytes / 1024;
	     }
	     return String.format("%." + digits + "f", bytes) + " " + dataDimension[i] + " =====> "+initialInput+" bytes ";	 
	 }
}
