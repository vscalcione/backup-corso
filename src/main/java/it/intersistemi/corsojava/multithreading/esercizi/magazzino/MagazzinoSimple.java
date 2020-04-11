package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

public class MagazzinoSimple implements Magazzino{
	private String product;
	private boolean empty = true;
	
	@Override
	public synchronized void produci(String product) {
		this.product = product;
		this.empty = empty;
	}
	
	@Override
	public synchronized String consuma() {
		String product = this.product;
		this.product = null;
		this.empty = true;
		return product;		
	}

//	@Override
//	public void consuma(String product) {
//		// TODO Auto-generated method stub
//		
//	}
}
