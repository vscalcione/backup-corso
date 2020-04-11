package it.intersistemi.corsojava.segreteriauniversitaria.model;

import java.util.Date;

public class StudenteDto {
	Integer matricola;
	String nome, cognome, email, nomeFacolta;
	Date dataNascita;
	public Integer getMatricola() {
		return matricola;
	}
	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeFacolta() {
		return nomeFacolta;
	}
	public void setNomeFacolta(String nomeFacolta) {
		this.nomeFacolta = nomeFacolta;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
}