package it.intersistemi.corsojava.esercitazioni.supermercato;

public class Prodotti {
	private String desc;
	private float prezzoUni;
	private String codiceABarre;
	
	//-------------Costruttori-------------
	public Prodotti(String codiceABarre, float prezzoUni){
		if(codiceABarre==null){
			System.out.println("errore,impossibile impostare questo codice a barre");
			return;
		}
		this.codiceABarre=codiceABarre;
		this.prezzoUni=prezzoUni;
	}
	public Prodotti(String codiceABarre, float prezzoUni, String descrizione){
		this(codiceABarre,prezzoUni);
		desc=descrizione;
	}
	
	//--------------Metodi-----------------
	public float applicaSconto(){
		return prezzoUni-((prezzoUni/100)*5);
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Prodotti){
			String codiceAltroProdotto=((Prodotti)obj).codiceABarre;
			if(codiceABarre!=null){
				return ( this.codiceABarre.equals( codiceAltroProdotto) );
			}
			else if(codiceAltroProdotto==null){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return codiceABarre.hashCode();
	}
	public String toString(){
		return desc+"\nPrezzo:"+prezzoUni+"\nCodice a barre:"+codiceABarre;
	}
	
	//-----------get e set vari-----------
	public void setDesc(String descrizione){
		desc=descrizione;
	}
	public String getDesc(){
		return desc;
	}
	public float getPrezzoUni() {
		return prezzoUni;
	}
	public void setPrezzoUni(float prezzoUni) {
		this.prezzoUni = prezzoUni;
	}
	public String getCodiceABarre() {
		return codiceABarre;
	}
	public void setCodiceABarre(String codiceABarre) {
		if(codiceABarre==null){
			System.out.println("errore,impossibile impostare questo codice a barre");
			return;
		}
		this.codiceABarre = codiceABarre;
			
	}
}
