package it.intersistemi.corsojava.multithreading.esercizi.stampa20valori;

public class Print20Pari_DispariValues {
	public static volatile boolean flag = true;
	public static void main(String[] args) {
		Thread1 threadPrintPari = new Thread1();
		Thread2 threadPrintDispari = new Thread2();
		System.out.println("*********** Stampa valor pari ***********");
		threadPrintPari.run();
		System.out.println("*********** Stampa valor dispari ***********");
		threadPrintDispari.run();
	}
}
