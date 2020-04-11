package it.intersistemi.corsojava.lambdaexpression.esercizi;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	public enum Sex { MALE, FEMALE}

	private String name;
	private LocalDate birthday;
	private Sex gender;
	private String email;

	public Person(String string, LocalDate of, Sex male, String string2) {
		// TODO Auto-generated constructor stub
	}
	public Integer getAge1() {
		if (this.birthday != null) {
			LocalDate now = LocalDate.now();
			return Period.between(birthday, now).getYears();
		} else {
			return null;
		}
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the gender
	 */
	public Sex getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



    public void printPerson() {

    	String print = "name: " +name+", "+ "birthday: " +birthday+ ", "+ "gender: " +gender+ " , " + "email" +email;
    			System.out.println(print);

    }




}
