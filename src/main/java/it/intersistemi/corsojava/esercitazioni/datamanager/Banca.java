package it.intersistemi.corsojava.esercitazioni.datamanager;

public class Banca {

	public static void main(String[] args) {
		ContoCorrente conto = new ContoCorrente(
				12345678, "mirko bartoli", 200);
		
		System.out.println("nuovo conto: "+conto.getNumeroConto());
		System.out.println("saldo iniziale: "+conto.getSaldo());
		
		BancomatEsercizio bancomat = new BancomatEsercizio(54246, 778877);
		conto.aggiungiCarta(bancomat);
		
		boolean esitoPrelievo = conto.prelevaDaAtm(778877, 54246, 5);
		if(esitoPrelievo) {
			System.out.println("Prelievo ok");
		} else {
			System.out.println("Prelievo fallito");
		}
		
		System.out.println("saldo finale: "+ conto.getSaldo());
	}

}
