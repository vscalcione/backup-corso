/**
 * 
 */
package it.intersistemi.corsojava.esercizi;
import java.util.Random;

/**
 * @author Spellucci
 *
 */
public class HelloEclipse {
	/**
	 * E' il main del prgramma
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Stampante stampante = new Stampante();
		System.out.println("Ciao");

		stampante.stampa("ciao ciao " + stampante.getContatoreStampe());

		int x = somma(1, 2);
		System.out.println(x);
		frazione("david",null);
		//System.out.println("risulatato=");
		int[] vett=new int[10];
		int i=0;
		try{
			while(true){
				vett[i]= i / new Random().nextInt(10);
				i++;
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			System.out.println("Con l'indice "+i+" sono arrivato al limite dell'array");
		}
		catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("Con l'indice "+i+" si � verificato un errore di calcolo: "+e.getMessage());
		}
	}
	/**
	 * Fa la somma dei due numeri passati
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private static int somma(int i, int j) {
		return i + j;
	}
	public static void frazione(String a,String b){
		System.out.println("a="+a+" b="+b);
		/*int c=0;
		try{
			c=Integer.parseInt(a)/Integer.parseInt(b);
		}
		catch(NumberFormatException e){System.out.println("errore, numeri non validi");}
		return c;*/
	}
}
