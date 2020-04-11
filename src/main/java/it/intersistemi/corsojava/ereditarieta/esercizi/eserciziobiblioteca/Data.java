package it.intersistemi.corsojava.ereditarieta.esercizi.eserciziobiblioteca;

import java.util.Calendar;

public class Data {
	private int day, month, year;
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

	public static Data dataNow() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return new Data (day, month, year);
	}
	
	public int getDifference(Data data) {
		int giorniAltraData = calcolaGiorni(data);
		int giorniQuestaData = calcolaGiorni(this);
		return giorniAltraData - giorniQuestaData;
	}

	
	private int calcolaGiorni(Data data) {
		return data.getYear()*365 + data.getMonth()*30 + data.getDay();
	}
	
	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}
