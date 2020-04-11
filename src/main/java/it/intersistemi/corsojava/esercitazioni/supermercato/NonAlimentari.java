package it.intersistemi.corsojava.esercitazioni.supermercato;
import esercizio1.Prodotti;

public class NonAlimentari extends Prodotti{
	private String materialePrincipale;
	
	//------Costruttori-----------
	public NonAlimentari(String codice, float prezzo){
		super(codice,prezzo);
	}
	public NonAlimentari(String codice, float prezzo, String materiale){
		super(codice,prezzo);
		materialePrincipale=materiale;
	}
	/*public NonAlimentari(String codice,float prezzo,String desc){
		super(codice,prezzo,desc);
	}*/
	public NonAlimentari(String codice,float prezzo,String desc,String materiale){
		super(codice,prezzo,desc);
		materialePrincipale=materiale;
	}
	
	//--------Metodi-----------
	@Override
	public float applicaSconto(){
		if((materialePrincipale.equalsIgnoreCase("carta"))||(materialePrincipale.equalsIgnoreCase("vetro"))||(materialePrincipale.equalsIgnoreCase("plastica"))){
			return getPrezzoUni()-((getPrezzoUni()/100)*10);
		}
		return getPrezzoUni();
	}
	
	//-------get e set vari--------------
	public String getMaterialePrincipale() {
		return materialePrincipale;
	}
	public void setMaterialePrincipale(String materialePrincipale) {
		this.materialePrincipale = materialePrincipale;
	}
	
}
