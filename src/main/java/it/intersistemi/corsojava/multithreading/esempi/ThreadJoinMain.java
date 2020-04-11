package it.intersistemi.corsojava.multithreading.esempi;

import java.util.Random;

public class ThreadJoinMain{
	public static void main(String[] args) {
		Random rnd = new Random();
		Thread[] threads = new Thread[10];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> {
				Thread current = Thread.currentThread();
				try {
					int attesa = rnd.nextInt(10)*1000 + 1000;
					System.out.println(current.getName()+": terminerò tra: "+attesa+" millisecondi");
					Thread.sleep(attesa);
					System.out.println(current.getName()+" ho finito ");
				}
				catch(InterruptedException e) {
					System.out.println(current.getName()+ "sono morto");
				}
			});
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}	}
		System.out.println("Tutti i thread sono terminati");
	}
}