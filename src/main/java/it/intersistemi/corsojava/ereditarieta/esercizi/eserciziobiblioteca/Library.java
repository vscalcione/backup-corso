package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

public class Library {
	private String productTitle, userName, userSurname;
	private int pubblicationYear;
	private Data startDate, endDate;
	public Library(String productTitle, String userName, String userSurname, int pubblicationYear, Data startDate, Data endDate) {
		super();
		this.productTitle = productTitle;
		this.userName = userName;
		this.userSurname = userSurname;
		this.pubblicationYear = pubblicationYear;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getProductTitle() {
		return productTitle;
	}
	
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserSurname() {
		return userSurname;
	}
	
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	public int getPubblicationYear() {
		return pubblicationYear;
	}
	
	public void setPubblicationYear(int pubblicationYear) {
		this.pubblicationYear = pubblicationYear;
	}
	
	public Data getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Data startDate) {
		this.startDate = startDate;
	}
	
	public Data getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Data endDate) {
		this.endDate = endDate;
	}
	
	public int prestitoPeriod (Data startDate, Data endDate) {
		int period = endDate.getDifference(startDate);
		return period;
	}
	
	public static void main(String[] args) {
		Library dvd1 = new Library("The Fast And The Furious", "Vincenzo", "Scalcione", 2001, new Data(21, 10, 2017), Data.dataNow());
		int var = dvd1.prestitoPeriod(dvd1.getEndDate(), dvd1.getStartDate());
		System.out.println("Periodo di prestito: " + var);
	}
}
