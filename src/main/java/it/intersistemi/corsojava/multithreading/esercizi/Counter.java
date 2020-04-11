package it.intersistemi.corsojava.multithreading.esercizi;

public class Counter extends MultiThreadCounter {
	private int counter =0;
	
	public void increment() {
		counter++;
	}
	public void decrement() {
	    counter--;
	}
	public int getCounter() {
		return counter;
	}
}
