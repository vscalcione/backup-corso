package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

public class Consumatore implements Runnable{
	private Magazzino magazzino;
	public Consumatore(Magazzino magazzino) {
		this.magazzino = magazzino;
		new Thread(this, "Consumatore").start();
	}
	@Override
	public void run() {
		String product = null;
		while((product = magazzino.consuma()) != null) {
//			System.out.println("Consumatore: "+product);
		}
	}

}
