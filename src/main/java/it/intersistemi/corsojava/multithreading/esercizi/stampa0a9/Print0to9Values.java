package it.intersistemi.corsojava.multithreading.esercizi.stampa0a9;

public class Print0to9Values {
	public static volatile int numero = -1;
	public static volatile int flag = 1;
	public static Stampante stampante = new Stampante();
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}
}
