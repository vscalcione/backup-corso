package it.intersistemi.corsojava.multithreading.esempi;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ThreadMain{
	public static void main(String[] args) {

		//creazione di un oggetto t1 di tipo Thread attraverso la sintassi della Lambda
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println("InterruptedException"+e.getMessage());
			}
//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			String currentDate = sdf.format(new Date());
//			System.out.println(currentDate+ " Thread n 1: "+Thread.currentThread());
		});

		//creazione di un oggetto t2 di tipo Thread attraverso la sintassi della Lambda
		Thread t2 = new Thread(() -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String currentDate = sdf.format(new Date());
			System.out.println(currentDate+ " Thread n 2: "+Thread.currentThread());
		});
//		try { 
//			t1.sleep(1000); 
//		} 
//		catch 
//		}
//		t2.start();
		t1.start();
		t1.interrupt();
	}
}
