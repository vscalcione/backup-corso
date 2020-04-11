package it.intersistemi.corsojava.esercizi;

public class IstancesCounter {
	public static int instancesCounter;
	public IstancesCounter() {
		System.out.println("Creazione di una nuova istanza");
		instancesCounter++;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new IstancesCounter();
		}
		System.out.println("Sono state create "+IstancesCounter.instancesCounter+" istanze ");
	}
}
