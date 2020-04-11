package it.intersistemi.corsojava.esercizi.esercizioprodotto;

import java.util.HashMap;
import java.util.Map;

import negoziovirtuale.model.ProdottoNegozio;

public class InMemoryProdottoRepositoryParametrizzata implements DataRepository<ProdottoNegozio, Integer> {

	private int indiceProdotto = 0;

	private Map<Integer, ProdottoNegozio> magazzinoProdotti = new HashMap<Integer, ProdottoNegozio>();

	@Override
	public Iterable<ProdottoNegozio> findAll() {

		return magazzinoProdotti.values();
	}

	@Override
	public ProdottoNegozio findByCodice(Integer codice) {

		return magazzinoProdotti.get(codice);
	}

	@Override
	public boolean existsByCodice(Integer codice) {
		
		
return magazzinoProdotti.get(codice) != null; //meglio perch� potre ritrovarmi un codice con prodotto associato null
		//return magazzinoProdotti.containsKey(codice);

	}

	@Override
	public ProdottoNegozio save(ProdottoNegozio p) {

		ProdottoNegozio prodottoCorrente = magazzinoProdotti.get(p.getCodiceABarre());
		if (prodottoCorrente != null)
		{
			prodottoCorrente.setCodiceABarre(p.getCodiceABarre());;
			prodottoCorrente.setNome(p.getNome());
			prodottoCorrente.setPrezzoUnitario(p.getPrezzoUnitario());
			
			return prodottoCorrente;
		} else {
			p.setCodiceABarre(++indiceProdotto);
			magazzinoProdotti.put(p.getCodiceABarre(), p); // verifico prima se c'� e poi vado a sostituire o ad aggiornare con un nuovo vontatore inizializzato a 0
			return p;
		}
		
		//indiceProdotto = indiceProdotto +1 ;
		//return magazzinoProdotti.put(indiceProdotto, p);
		 
	}

	public ProdottoNegozio deleteByCodice(int codice) {// da capire
		
		return magazzinoProdotti.remove(codice);
		
	}

	@Override
	public ProdottoNegozio deleteByCodice(Integer codice) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
