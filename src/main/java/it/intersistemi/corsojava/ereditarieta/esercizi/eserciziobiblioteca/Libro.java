package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

public class Libro extends Library{
	private int pagesNumber;
	public Libro(String productTitle, String userName, String userSurname, int pubblicationYear, Data startDate, Data endDate, int pagesNumber) {
		super(productTitle, userName, userSurname, pubblicationYear, startDate, endDate);
		this.pagesNumber = pagesNumber;
	}
	
	public int getPagesNumber() {
		return pagesNumber;
	}
	
	public void setPagesNumber(int pagesNumber) {
		this.pagesNumber = pagesNumber;
	}
}
