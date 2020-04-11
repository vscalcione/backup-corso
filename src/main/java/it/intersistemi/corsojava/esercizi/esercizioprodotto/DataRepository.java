package it.intersistemi.corsojava.esercizi.esercizioprodotto;

import negoziovirtuale.model.ProdottoNegozio;
public interface DataRepository<T,K> {
	
	
	Iterable<ProdottoNegozio> findAll();
	
	ProdottoNegozio findByCodice (K codice);
	
	boolean existsByCodice (K codice);
	
	ProdottoNegozio save(T p);

	ProdottoNegozio deleteByCodice (K codice);
	
	
	

}
