package it.intersistemi.corsojava.esercitazioni.banca;

public class Conto {
	private int saldo;
	private int pin;
	
	public Conto(int saldo, int pin) {
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

}
