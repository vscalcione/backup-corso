package esercitazioneSegreteriaUniversitaria;

public class Teacher extends Persona {
	
	private String id;

	public Teacher(String name, String surname, Date bornDate) {
		super(name, surname, bornDate);
	}

	public Teacher() {}

	public Teacher(String name, String surname) {
		super(name, surname);
	}

	public Teacher(String name, String surname, Date bornDate, String id) {
		super(name, surname, bornDate);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	 @Override
	 public String toString() {
		return "Docente:  " + "  " + "Nome: " + this.getNome() + "   Cognome: " + this.getCognome()
				+  "   Id: " + this.id; // + " Data di iscrizione: "+;
	 }
}
