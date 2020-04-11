package it.intersistemi.corsojava.amazon.jpadao.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIA database table.
 * 
 */
@Entity
@Table(name="CATEGORY")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=45)
	private String nome;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="ID_PADRE")
	private Category categoriaPadre;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="categoriaPadre")
	private List<Category> categorieFiglie;

	public Category() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Category getCategoriaPadre() {
		return this.categoriaPadre;
	}

	public void setCategoriaPadre(Category categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public List<Category> getCategorieFiglie() {
		return this.categorieFiglie;
	}

	public void setCategorieFiglie(List<Category> categorieFiglie) {
		this.categorieFiglie = categorieFiglie;
	}

	public Category addCategorieFiglie(Category categorieFiglie) {
		getCategorieFiglie().add(categorieFiglie);
		categorieFiglie.setCategoriaPadre(this);

		return categorieFiglie;
	}

	public Category removeCategorieFiglie(Category categorieFiglie) {
		getCategorieFiglie().remove(categorieFiglie);
		categorieFiglie.setCategoriaPadre(null);

		return categorieFiglie;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", categoriaPadre=" + categoriaPadre + "]";
	}

}