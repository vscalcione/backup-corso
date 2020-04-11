package it.intersistemi.corsojava.multithreading.esercizi;

import java.text.SimpleDateFormat;

public class ThreadManager {
	

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		
		Thread Thread1= new Thread(() -> {
			stampaThread();
			
			
			
		}
		
	);
		
		Thread Thread2 = new Thread(() -> {
			stampaThread();
			
		
	
	
		}
		);
	
	Thread1.start();
	Thread2.start();
	
	
		System.out.println("fine main");
		
	}
	private static void stampaThread() {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss:sss");
	String dataCorrente = sdf.format(new Date());
	
}

}
