package it.intersistemi.corsojava.multithreading.esercizi.stampavalori;

public class PrintValues0to9And9to0 {
	public static Stampante stampante=new Stampante();
	public static volatile boolean flag=false;
	public static void main(String[] args) {
		Thread1 T1 = new Thread1();
		Thread2 T2 = new Thread2();
		T1.start();
		T2.start();
	}
}
