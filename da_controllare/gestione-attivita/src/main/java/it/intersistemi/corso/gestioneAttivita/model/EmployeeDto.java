package it.intersistemi.corso.gestioneAttivita.model;

public class EmployeeDto {
	private Integer idMatricola;
	private String surname, name;
	public Integer getIdMatricola() {
		return idMatricola;
	}
	public void setIdMatricola(int idMatricola) {
		this.idMatricola = idMatricola;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}