/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

/**
 * @author Spellucci
 *
 */
public class GiornoMain {

	
	public static void main(String[] args) {
		for(Giorno giorno : Giorno.values()) {
			System.out.println(giorno+" � "+(giorno.isFestivo()?"festivo":"feriale"));
			
		}
		

	}

}
