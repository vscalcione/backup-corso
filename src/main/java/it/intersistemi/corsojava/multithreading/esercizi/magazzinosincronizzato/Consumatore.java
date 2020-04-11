package it.intersistemi.corsojava.multithreading.esercizi.magazzinosincronizzato;

public class Consumatore implements Runnable {
	
	private Magazzino magazzino;
	
	public Consumatore(Magazzino magazzino) {
		this.magazzino = magazzino;
		new Thread (this, "Consumatore").start();
	}
	
	@Override
    public void run() {
	String prodotto= null;
	while((prodotto = magazzino.consuma()) != null) {
		System.out.println("Consumatore: "+prodotto);
	}
  }
}
