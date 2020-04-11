package it.intersistemi.corsojava.ereditarieta.esercizi.gestionesupermercato;

public class Data {
	public int day, month, year;

	public Data(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDifference(Data data) {
		int otherDay = dayCalculator(data);
		int currentDay = dayCalculator(this);
		return otherDay - currentDay;
	}
	
	public int dayCalculator(Data data) {
		return data.getYear()*365 + data.getMonth()*30 + data.getDay();
	}
	
	public String toString() {
		return this.day+" /"+this.month+"/"+this.year;
	}
	
	public static void main(String[] args) {
		System.out.println("");
	}
}
