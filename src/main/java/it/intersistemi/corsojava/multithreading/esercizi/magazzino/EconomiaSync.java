/**
 * 
 */
package it.intersistemi.corsojava.multithreading.esercizi.magazzino;

/**
 * @author Vincenzo Scalcione
 *
 */
public class EconomiaSync {
	public static void main(String[] args) {
		Magazzino magazzino = new MagazzinoLinkedListSync();
		new Produttore(magazzino);
		new Consumatore(magazzino);
	}
}
