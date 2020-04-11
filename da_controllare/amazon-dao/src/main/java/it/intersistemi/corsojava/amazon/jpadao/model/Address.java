package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INDIRIZZO database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=5, columnDefinition = "CHAR")
	private String cap;

	@Column(nullable=false, length=150)
	private String citta;

	@Column(nullable=false, length=20)
	private String nazione;

	@Column(nullable=false, length=100)
	private String nominativo;

	@Column(name="NUMERO_TELEFONO", length=20)
	private String numeroTelefono;

	@Column(nullable=false, length=2)
	private String provincia;

	@Column(nullable=false, length=200)
	private String via;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="USERNAME", nullable=false)
	private User utente;

	public Address() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getNominativo() {
		return this.nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public User getUtente() {
		return this.utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", cap=" + cap + ", citta=" + citta + ", nazione=" + nazione + ", nominativo="
				+ nominativo + ", numeroTelefono=" + numeroTelefono + ", provincia=" + provincia + ", via=" + via
				+ ", utente=" + utente + "]";
	}
}