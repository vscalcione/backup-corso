package it.intersistemi.corsojava.multithreading.esercizi;

import java.util.Random;

public class Thread1 {
	public static void main(String[] args) {
		Random rnd = new Random();		
		Thread[] threads = new Thread[66];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				Thread current = Thread.currentThread();
				try { 
					int attesa = rnd.nextInt(50000);
					System.out.println(current.getName()+": terminer� tra"+attesa+"millisecondi");
					Thread.sleep(attesa);
					System.out.println(current.getName()+": Ho finito");
				}catch (InterruptedException e) {
					System.out.println("Sono morto");
				}
			});
			threads[i].start();
		}
		for ( int i =0; i <threads.length; i++) {
			try { 
				threads[i].join();	
			} 
			catch (InterruptedException e) {
				e.printStackTrace();	
			}
		}	
		System.out.println("Tutti i thread sono terminati");
	}
}
	
	

	

