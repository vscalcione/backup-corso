package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

public class Produttore implements Runnable{
	private Magazzino magazzino;
	public Produttore(Magazzino magazzino) {
		this.magazzino = magazzino;
		new Thread(this, "Produttore: ").start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			String product = "Prodotto_"+i;
			magazzino.produci(product);
//			System.out.println("Produttore: "+product);
		}
	}
}
