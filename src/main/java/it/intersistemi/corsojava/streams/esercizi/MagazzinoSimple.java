package it.intersistemi.corsojava.streams.esercizi;

public class MagazzinoSimple {
	
	private String prodotto;
	private boolean vuoto;
	
	@Override
	public synchronized void produci(String prodotto) {
		this.prodotto = prodotto;
		this.vuoto = false;
	}
	@Override
	public synchronized String consuma() {
		this.prodotto = prodotto;
		this.vuoto = false;
		return prodotto;
	}

}
