package it.intersistemi.corsojava.segreteriauniversitaria.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FACOLTA database table.
 * 
 */
@Entity
@NamedQuery(name="Facolta.findAll", query="SELECT f FROM Facolta f")
public class Facolta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FACOLTA")
	private Integer idFacolta;

	@Column(name="NOME_FACOLTA")
	private String nomeFacolta;
	
	@Column(name="NUMERO_ISCRITTI")
	private int numeroIscritti;

	//bi-directional many-to-one association to Studente
	@OneToMany(mappedBy="facolta")
	private List<Studente> studentes;

	public Facolta() {
	}

	public Integer getIdFacolta() {
		return this.idFacolta;
	}

	public void setIdFacolta(Integer idFacolta) {
		this.idFacolta = idFacolta;
	}

	public String getNomeFacolta() {
		return this.nomeFacolta;
	}
	
	public void setNomeFacolta(String nomeFacolta) {
		this.nomeFacolta = nomeFacolta;
	}
	
	public int getNumeroIscritti() {
		return this.numeroIscritti;
	}

	public void setNumeroIscritti(int numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}

	public List<Studente> getStudentes() {
		return this.studentes;
	}

	public void setStudentes(List<Studente> studentes) {
		this.studentes = studentes;
	}

	public Studente addStudente(Studente studente) {
		getStudentes().add(studente);
		studente.setFacolta(this);

		return studente;
	}

	public Studente removeStudente(Studente studente) {
		getStudentes().remove(studente);
		studente.setFacolta(null);

		return studente;
	}

	public void add(Facolta facolta) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Facolta facolta) {
		// TODO Auto-generated method stub
		
	}
}