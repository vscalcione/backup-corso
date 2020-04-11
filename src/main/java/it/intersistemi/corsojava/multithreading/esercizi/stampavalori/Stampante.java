package it.intersistemi.corsojava.multithreading.esercizi.stampavalori;

public class Stampante{
	public void stampa(int numero){
		System.out.print(numero+" ");
		try{
			Thread.sleep(50);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
