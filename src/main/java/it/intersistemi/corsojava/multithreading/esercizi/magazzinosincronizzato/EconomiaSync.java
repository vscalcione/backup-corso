package it.intersistemi.corsojava.multithreading.esercizi.magazzinosincronizzato;

public class EconomiaSync{

	public static void main(String[] args) {
	Magazzino magazzino = new MagazzinoSync();
	new Produttore(magazzino);
	new Consumatore(magazzino);

	}

}
