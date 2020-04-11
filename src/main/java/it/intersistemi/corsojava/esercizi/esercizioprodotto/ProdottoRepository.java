package it.intersistemi.corsojava.esercizi.esercizioprodotto;

import negoziovirtuale.model.ProdottoNegozio;
public interface ProdottoRepository {
	
	
	Iterable<ProdottoNegozio> findAll();
	
	ProdottoNegozio findByCodice (int codice);
	
	boolean existsByCodice (int codice);
	
	ProdottoNegozio save(ProdottoNegozio p);

	ProdottoNegozio deleteByCodice (int codice);
	
	
	

}
