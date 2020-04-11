package it.intersistemi.corsojava.esercizi;

public class Stampante {

	private int contatoreStampe=0;

	/**
	 * @param messaggio
	 */
	public void stampa(String messaggio) {
		System.out.println(messaggio);
		contatoreStampe++;

	}

	/**
	 * @return
	 */
	public int getContatoreStampe() {
		return contatoreStampe;

	}

}
