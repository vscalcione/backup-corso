package it.intersistemi.corsojava.esercizi.esercizioprodotto;

/*ESERCIZIO 1
Il gestore di un negozio associa a tutti i suoi Prodotti un codice a barre univoco, una descrizione
 sintetica del prodotto e il suo prezzo unitario. Realizzare una classe Prodotto con le opportune variabili d'istanza e metodi get.

ESERCIZIO 1b
Aggiungere alla classe Prodotto un metodo applicaSconto che modifica il prezzo del prodotto diminuendolo del 5%.

ESERCIZIO 2
Il gestore del negozio vuole fare una distinzione tra i prodotti Alimentari e quelli Non Alimentari .
 Ai prodotti Alimentari viene infatti associata una data di scadenza (si veda la classe Data), mentre a quelli Non Alimentari il materiale principale di cui sono fatti. 
 Realizzare le sottoclassi Alimentari e NonAlimentari estendendo opportunamente la classe Prodotto.

ESERCIZIO 3
Modificare le due sottoclassi dell'esercizio 2 specializzando il metodo applicaSconto in modo che nel 
caso dei prodotti Alimentari venga applicato uno sconto del 20% se la data di scadenza � a meno di 10 giorni 
dalla data attuale (si usi il metodo getDifference della classe Data), mentre nel caso dei prodotti Non Alimentari
 venga applicato uno sconto del 10% se il prodotto � composto da un materiale riciclabile (carta, vetro o plastica).

ESERCIZIO 4
Realizzare una classe ListaSpesa che chieda all'utente di inserire i prodotti acquistati e 
calcoli il totale della spesa applicando gli opportuni sconti se il cliente ha la tessera fedelt�.
*/
public class ProdottoNegozio {

	private String nome;
	private int codiceABarre;
	private String descrizione;
	private double prezzoUnitario;

	public ProdottoNegozio(String nome, int codiceABarre, String descrizione, double prezzoUnitario) {

		this.nome = nome;
		this.codiceABarre = codiceABarre;
		this.descrizione = descrizione;
		this.prezzoUnitario = prezzoUnitario;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodiceABarre() {
		return codiceABarre;
	}

	public void setCodiceABarre(int codiceABarre) {
		this.codiceABarre = codiceABarre;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double applicaSconto() {

		double nuovoPrezzoUnitario;

		nuovoPrezzoUnitario = this.getPrezzoUnitario() - this.getPrezzoUnitario() * 0.05;

		return nuovoPrezzoUnitario;

	}

	public String toString() {
		return this.nome + ", " + this.codiceABarre + ", " + this.descrizione + ", " + this.prezzoUnitario + "�  " ;

	}

}
