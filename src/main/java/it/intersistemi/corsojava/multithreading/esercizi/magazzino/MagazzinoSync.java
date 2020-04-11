package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

public class MagazzinoSync implements Magazzino{
	private String product;
	private boolean empty = true;
	public synchronized void produci(String product) {
		if(!empty) {
			try {wait(); }
			catch(InterruptedException e) {e.printStackTrace();}
		}
		this.product = product;
		this.empty = false;
		notify();
	}
	public synchronized String consuma() {
		if(empty) {
			try { wait(); }
			catch(InterruptedException e) {e.printStackTrace();}
		}
		String product = this.product;
		this.product = null;
		this.empty = true;
		notify();
		return product;
	}
}
