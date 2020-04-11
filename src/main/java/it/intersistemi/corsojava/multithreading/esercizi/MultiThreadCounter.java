package it.intersistemi.corsojava.multithreading.esercizi;

import java.util.ArrayList; 
import java.util.List;
import java.util.stream.IntStream;

public class MultiThreadCounter { 
	
	public static void main(String[] args) {
		
		Counter counter = new Counter();
		List<Thread> threadList = new ArrayList<Thread>();
		IntStream.range(0, 1000)
		.forEach(i -> {
			threadList.add(new Thread(() -> counter.increment()));
			threadList.add(new Thread(() -> counter.decrement()));
		});
		
		threadList.forEach ( t -> t.start());
		threadList.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

}
