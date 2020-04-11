/**
 * 
 */
package it.intersistemi.corsojava.esercitazioni.datamanager;

/**
 * @author Spellucci
 *
 */
public class Bancomat {
	private int saldo;
	private int pin;
	
	public Bancomat(int saldo, int pin) {
		this.saldo = saldo;
		this.pin = pin;
	
	}
        public boolean preleva(int pin, int contante) {
        	if(this.pin == pin && this.saldo >= contante) {
        		this.saldo -= contante;
        		return true;
        	} else {
        		return false;
        	}
        }


	public static void main(String[] args) {
		Bancomat bancomat = new Bancomat(100, 12345);
		boolean esitoPrelievo = bancomat.preleva(12345, 200);
		System.out.println(esitoPrelievo);


	}
}


