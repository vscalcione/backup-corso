package it.intersistemi.corsojava.multithreading.esercizi.magazzinosincronizzato;

public class MagazzinoSync implements Magazzino {
	private String prodotto;
	private boolean vuoto = true;
	
	public synchronized void produci(String prodotto) {
		if (!vuoto) { 
			try { wait(); 
			}catch (InterruptedException e) { 
				
			}
		}
			this.prodotto = prodotto;
			this.vuoto = false;
			notify();
		}
		public synchronized String consuma() {
			if(vuoto) {
				try { wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				String prodotto = this.prodotto;
				this.prodotto = null;
				this.vuoto= true;
				notify();
				return prodotto;
		}
}
