package esercitazioneSegreteriaUniversitaria;

import java.util.Calendar;

public class Date {

	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(final int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(final int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public int getDifference(Date date) {
		int daysAnotherDate = calculateDays(date);
		int daysToday = calculateDays(this);
		return daysAnotherDate - daysToday;
	}

	public static Date dateNow() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		return new Date(day,month,year);
	}

	private int calculateDays(Date data) {
		return data.getYear() * 365 + data.getMonth() * 30 + data.getDay();
	}

	@Override
	public String toString() {
		return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
	}

	public static void main(String[] args) {
		System.out.println();
	}

}
	
