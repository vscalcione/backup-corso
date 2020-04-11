package it.intersistemi.corso.gestioneAttivita.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the EMPLOYEE database table.
 *
 */
@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MATRICOLA", unique=true, nullable=false)
	private Integer idMatricola;

	@Column(length=100)
	private String surname;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-many association to Activity
	@ManyToMany(mappedBy="employees")
	private Set<Activity> activities;

	public Employee() {
	}

	public Integer getIdMatricola() {
		return this.idMatricola;
	}

	public void setIdMatricola(Integer idMatricola) {
		this.idMatricola = idMatricola;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

}