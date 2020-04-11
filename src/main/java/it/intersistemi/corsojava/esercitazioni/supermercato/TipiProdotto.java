package it.intersistemi.corsojava.esercitazioni.supermercato;
import esercizio2.*;
import esercizio1.*;
import java.util.Date;

public enum TipiProdotto{
	PASTA(new Alimentari("1",2.10f,"� la pasta",new Date(2016,11,17))),
	CAROTE(new Alimentari("2",1.0f,"sono carote",new Date(2016,11,17))),
	ZUCCHINE(new Alimentari("3",1.5f,"sono zucchine",new Date(2016,11,17))),
	MESTOLO(new NonAlimentari("4",1.5f,"� un mestolo","legno")),
	MATTARELLO(new NonAlimentari("5",2.5f,"� un mattarello","legno")),
	TAGLIAERBA(new NonAlimentari("6",500.0f,"� un tagliaerba","ferro")),
	PENTOLA(new NonAlimentari("7",25.0f,"� una pentola","acciaio"));
	
	Prodotti prodotto;
	TipiProdotto(Prodotti prodotto){
		this.prodotto=prodotto;
	}
	public Prodotti getProdotto(){
		return prodotto;
	}
	
}
