package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

import java.util.LinkedList;
import java.util.Queue;

public class MagazzinoLinkedListSync implements Magazzino{
	private Queue<String> prodotti = new LinkedList<>();
	
	@Override
	public synchronized void produci (String product) {
		System.out.println("Magazzino.produci: "+product);
		this.prodotti.add(product);
		try { wait(); } 
		catch (InterruptedException e) { e.printStackTrace(); }
	}
	@Override
	public synchronized String consuma() {
		if(prodotti.isEmpty()) {
			try { wait(); } 
			catch (InterruptedException e) { e.printStackTrace(); }
		}
		String product = this.prodotti.poll();
		System.out.println("Magazzino.consuma: "+product);
		notify();
		return product;
	}
}
