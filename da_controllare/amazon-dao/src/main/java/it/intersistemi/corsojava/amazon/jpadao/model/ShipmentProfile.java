package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PROFILO_SPEDIZIONE database table.
 * 
 */
@Entity
@Table(name="SHIPMENT_PROFILE")
@NamedQuery(name="ShipmentProfile.findAll", query="SELECT s FROM ShipmentProfile s")
public class ShipmentProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=50)
	private String nome;

	@Column(nullable=false)
	private double costo;

	@Column(name="GIORNI_SPEDIZIONE")
	private int giorniSpedizione;

	public ShipmentProfile() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getGiorniSpedizione() {
		return this.giorniSpedizione;
	}

	public void setGiorniSpedizione(int giorniSpedizione) {
		this.giorniSpedizione = giorniSpedizione;
	}

	@Override
	public String toString() {
		return "ProfiloSpedizione [nome=" + nome + ", costo=" + costo + ", giorniSpedizione=" + giorniSpedizione + "]";
	}
}