package it.intersistemi.corsojava.segreteriauniversitaria.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the STUDENTE database table.
 * 
 */
@Entity
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer matricola;

	@Column(name="COGNOME_STUDENTE")
	private String cognomeStudente;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCITA")
	private Date dataNascita;

	private String email;

	@Column(name="NOME_STUDENTE")
	private String nomeStudente;

	//bi-directional many-to-one association to Facolta
	@ManyToOne
	@JoinColumn(name="NOME_FACOLTA", referencedColumnName="NOME_FACOLTA")
	private Facolta facolta;

	public Studente() {
	}

	public Integer getMatricola() {
		return this.matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public String getCognomeStudente() {
		return this.cognomeStudente;
	}

	public void setCognomeStudente(String cognomeStudente) {
		this.cognomeStudente = cognomeStudente;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeStudente() {
		return this.nomeStudente;
	}

	public void setNomeStudente(String nomeStudente) {
		this.nomeStudente = nomeStudente;
	}

	public Facolta getFacolta() {
		return this.facolta;
	}

	public void setFacolta(Facolta facolta) {
		this.facolta = facolta;
	}

}