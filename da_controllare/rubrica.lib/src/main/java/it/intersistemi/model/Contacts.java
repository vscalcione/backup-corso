package it.intersistemi.model;

public class Contacts implements Entity<Integer> {
	private int id;
	private String name;
	private String surname;
	
	
	public Integer getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
