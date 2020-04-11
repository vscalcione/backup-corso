package esercitazioneSegreteriaUniversitaria;


    

public class Docente extends Persona {
	
	private String id;

	public Docente(String nome, String cognome, Data dataDiNascita) {
		super(nome, cognome, dataDiNascita);
		
		
	}

	public Docente() {
		
	}

	public Docente(String nome, String cognome) {
		super(nome, cognome);
	
	}

	public Docente(String nome, String cognome, Data dataDiNascita, String id) {
		super(nome, cognome, dataDiNascita);
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
