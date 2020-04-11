package it.intersistemi.corsojava.classianonime;

public final class UfficioFiliale {
	private String idUfficio;
	private String idFiliale;
	
	
	public UfficioFiliale(String idUfficio, String idFiliale) {
		super();
		this.idFiliale= idFiliale;
		this.idUfficio= idUfficio;
	}

	public String getIdUfficio() {
		return idUfficio;
	}

	public String getIdFiliale() {
		return idFiliale;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFiliale == null) ? 0 : idFiliale.hashCode());
		result = prime * result + ((idUfficio == null) ? 0 : idUfficio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UfficioFiliale other = (UfficioFiliale) obj;
		if (idFiliale == null) {
			if (other.idFiliale != null)
				return false;
		} else if (!idFiliale.equals(other.idFiliale))
			return false;
		if (idUfficio == null) {
			if (other.idUfficio != null)
				return false;
		} else if (!idUfficio.equals(other.idUfficio))
			return false;
		return true;
	}
	
}

