package it.intersistemi.corsojava.esercizi;
import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	public enum Sex{
		MALE,FEMALE;
	}
	
	private String name;
	private LocalDate birthday;
	private Sex gender;
	private String emailAddress;
	public Person(String name, Sex gender, LocalDate birtday, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birtday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}
	
	public Integer getAge(){
		if(birthday!=null){
			return Period.between(birthday,LocalDate.now()).getYears();
		}
		else{
			return null;
		}
	}
	public void printPerson(){
		System.out.println(this.toString());
	}
	public String toString(){
		return name+" "+getAge()+" "+emailAddress+" "+gender;
	}
	
	
	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
}
