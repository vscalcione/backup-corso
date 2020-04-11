package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

public class DipendenteA extends Dipendente{
	private int malattia = 0;
	public DipendenteA(String employeeId, double salary, double extraordinary, int malattia) {
		super(employeeId, salary, extraordinary);
		this.malattia = malattia;
	}
	
	public int getMalattia() {
		return malattia;
	}
	
	public void setMalattia(int malattia) {
		this.malattia = malattia;
	}
	
	public int prendiMalattia(int oreMalattia) {
		int malattia = getMalattia() + oreMalattia;
		return malattia;
	}
	
	@Override
	public double paga(int extraordinaryHours) {
		double paga = super.paga(extraordinaryHours);
		if(malattia == 0) {
			return paga;
		}else {
			return paga = super.paga(extraordinaryHours) - malattia * 15.0; 
		}
	}
	
	public void printMalattia() {
		System.out.println(malattia);
	}
}
