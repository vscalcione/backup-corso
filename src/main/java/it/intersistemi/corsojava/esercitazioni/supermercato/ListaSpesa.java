package it.intersistemi.corsojava.esercitazioni.supermercato;
//import esercizio2.*;
import esercizio1.*;
import java.io.*;

public class ListaSpesa{
    public static void main(String[] args){
    	InputStreamReader lettore=new InputStreamReader(System.in);
    	BufferedReader leggi=new BufferedReader(lettore);
    	String prodotto="";
    	Prodotti[] acquistati;
    	int nAcquistati=0;
        System.out.println("Quanti prodotti sono stati aquistati?");
        boolean erroreInput;
        do{
        	erroreInput=false;
        	try{
	        	nAcquistati=Integer.parseInt(leggi.readLine());
	        }
	        catch(IOException e){
	        	System.out.println("errore input, riprovare");
	        	erroreInput=true;
	        }
	        catch(NumberFormatException e){
	        	System.out.println("inserire un numero intero:");
	        	erroreInput=true;
	        }
        }while(erroreInput);
        //nAcquistati=10;//letto da input
        acquistati=new Prodotti[nAcquistati];
        System.out.println("Scegliere i prodotti acquistati:");
        for(int i=0;i<nAcquistati;i++){
        	System.out.println();
            for(TipiProdotto tipo:TipiProdotto.values()){
            	System.out.println(tipo);
            }
            do{
            	erroreInput=false;
            	try{
	            	prodotto=leggi.readLine();
		            //prodotto="pasta";//letto da input
		            prodotto=prodotto.toUpperCase();
		            acquistati[i]=TipiProdotto.valueOf(prodotto).getProdotto();
            	}
            	catch(IOException e){
            		System.out.println("errore input, riprovare");
            		erroreInput=true;
            	}
            	catch(IllegalArgumentException e){
            		System.out.println("prodotto non disponibile, sceglierne un'altro:");
            		erroreInput=true;
            	}
            }while(erroreInput);
        }
        System.out.println("Hai la tessera fedelt�?(si,no)");
        String risposta="";
        float totale=0f;
        do{
        	erroreInput=false;
	        try{
	        	risposta=leggi.readLine();
	        }
	        catch(IOException e){
	        	System.out.println("errore di input, riprovare");
	        	erroreInput=true;
	        }
	        //risposta="si";//letta da input
	        if(risposta.equalsIgnoreCase("si")){
	        	for(Prodotti prodottoFor:acquistati){
	        		totale += prodottoFor.applicaSconto();
	        	}
	        }
	        else if(risposta.equalsIgnoreCase("no")){
	        	for(Prodotti prodottoFor:acquistati){
	        		totale += prodottoFor.applicaSconto();
	        	}
	        }
	        else{
	        	System.out.println("errore, si � inserita una risposta diversa da si e no, scriverne un'altra:");
	        	erroreInput=true;
	        }
        }while(erroreInput);
        System.out.println("il totale �:"+totale);
    }
}
