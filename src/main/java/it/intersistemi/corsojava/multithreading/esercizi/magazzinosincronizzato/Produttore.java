package it.intersistemi.corsojava.multithreading.esercizi.magazzinosincronizzato;

public class Produttore implements Runnable {
	private Magazzino magazzino;
	
	public Produttore(Magazzino magazzino) {
		this.magazzino = magazzino;
		new Thread(this, "Produttore").start();
	}
	@Override
	public void run() {
		for (int i=0; i<=10; i++) {
			String prodotto = "Prodotto_"+i;
			magazzino.produci(prodotto);
			System.out.println("Produttore: " +prodotto);
		}
	}

}
