package it.intersistemi.corsojava.ereditarieta.esercizi;

public class Bancomat{
	int numeroCarta, pinCode;
	public Bancomat(int numeroCarta, int pinCode) {
		this.numeroCarta=numeroCarta;
		this.pinCode=pinCode;
	}
	
	public int getNumeroCarta() {
		return numeroCarta;
	}
	
	public void setNumeroCarta(int numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}