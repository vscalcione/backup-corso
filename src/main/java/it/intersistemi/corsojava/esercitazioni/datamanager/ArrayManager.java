/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

/**
 * @author Spellucci
 *
 */
public class ArrayManager {
	//oggetto (di tipo array di stringhe9 a livello di classe
	public static String[] arrayDiStringhe = new String[10]; 
	 /**
	  * metodo che carica un solo elemento dell'array alla volta
	  * @param indexArray
	  * @param valElemento
	  * @return true se il caricamento � avvenuto con successo  
	  */
	public static boolean caricaSingoloElementoArray( int indexArray, String valElemento) {
         arrayDiStringhe[indexArray]= valElemento;
		if( indexArray >= arrayDiStringhe.length) {
			return false;
			} else {
			arrayDiStringhe[indexArray] = valElemento;
			return true;
		}
}
		
		
	public static void stampaArrayAConsolle() 
	{
		for(String arrayElem:arrayDiStringhe) 
		{
		System.out.println(arrayElem );
		}
	}
		
	public static int ricercaElemento(String string) 
	{
		if(string!= null) 
		{
			for (int i= 0; i <arrayDiStringhe.length;);
		}
		return 0;
	}
		
	public static String ricercoElementoInArray(String elemDaCercare){
		String result = "";
	
		if(elemDaCercare== null) {
			result = "attenzione ricerca non valida";
		}
		else {
			int indexBackup = 0;
			for(int index = 0; index < arrayDiStringhe.length; index++) {
				indexBackup = index;
			
				
				if(elemDaCercare.equals(arrayDiStringhe[index])) {
				break;
				}
			}
			if (indexBackup != arrayDiStringhe.length) {
				result= "elemento torvato a posizione:"+ indexBackup;
			} else {
				result = "elemento NON trovato";
			}
		}
		return result;
	}
}
