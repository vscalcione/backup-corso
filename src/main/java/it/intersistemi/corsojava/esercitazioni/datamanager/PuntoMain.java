/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

/**
 * @author Spellucci
 *
 */
public class PuntoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Punto p = new Punto(16,23);
		
		
		System.out.println("le coordinate sono: "+
				           p.getX()+", "+p.getY());
		
		Punto[] punti = new Punto[] {
				new Punto(2,9),
				new Punto(4,1),
				new Punto(1,89),
				new Punto(7,9),
				new Punto(9,5),
				new Punto(10,3),
				new Punto(32,23),
		};
		
		for (Punto punto: punti) {
			System.out.println("le coordinte sono: "+
		                        punto.getX()+", "+punto.getY());
		}
				
		}

	}


