package it.intersistemi.corsojava.esercizi;

public class HelloWorld {
	public static void main(String[] argomenti) {
		System.out.println("Hello World!!");
		// commento una riga
		System.out.println(10);
		/*
		 * commento pi� righe
		 */
		System.out.println(argomenti);
		/**
		 * commento pi� righe javadoc
		 */
		final int intValue = 40;
		//final rende var non modificabile
		byte b = -128;
		byte a = 127;
		// min -128, max 127
		int intDecValue = 19845;
		// decimale
		int intBinValue = 0b0100110110000101;
		// binario
		int intOctValue = 046605;
		// ottale
		int intHexValue = 0x4D85;
		// esadecimale
		System.out.println(intDecValue);
		System.out.println(intBinValue);
		System.out.println(intOctValue);
		System.out.println(intHexValue);
	}
}
