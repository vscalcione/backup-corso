package it.intersistemi.corsojava.esercitazioni.supermercato;
import java.util.Date;
import java.util.Calendar;
import esercizio1.Prodotti;

public class Alimentari extends Prodotti{
	private Date dataDiScadenza;
	
	//------Costrttori---------
	public Alimentari(String codiceABarre, float prezzoUni, Date dataDiScadenza){
		super(codiceABarre,prezzoUni);
		this.dataDiScadenza=dataDiScadenza;
	}
	public Alimentari(String codice, float prezzo, String desc, Date dataScad){
		super(codice,prezzo,desc);
		dataDiScadenza=dataScad;
	}
	
	//------Metodi-----------
	@Override
	public float applicaSconto(){
		//leggo la data di oggi
		Calendar dataOggiPiu10=Calendar.getInstance();
		//ci aggiungo 10 giorni
		dataOggiPiu10.roll(Calendar.DAY_OF_MONTH, 10);
		
		//creo un oggetto calendario con la data di scadenza
		Calendar dataScadenzaCal=Calendar.getInstance();
		dataScadenzaCal.setTime(dataDiScadenza);
		//vedo se la data di oggi piu 10 giorni � maggiore della data di scadenza
		if(dataOggiPiu10.after(dataScadenzaCal)){
			//se lo � applico lo sconto
			return getPrezzoUni()-((getPrezzoUni()/100)*20);
		}
		//senn� no
		return getPrezzoUni();
	}
	
	//-------get e set vari---------
	public Date getDataScadenza(){
		return dataDiScadenza;
	}
}
