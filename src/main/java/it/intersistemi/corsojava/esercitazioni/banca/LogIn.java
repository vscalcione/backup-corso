package it.intersistemi.corsojava.esercitazioni.banca;

public class LogIn {
	private  int pin;
	private  int id;
	
	

	public LogIn( int pin, int id) {
		 this.pin= pin;
		 this.id= id;
	}



	public int getPin() {
		return pin;
	}



	public  int getId() {
		return id;
	}

}
