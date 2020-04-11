package it.intersistemi.corsojava.streams.esercizi;

public class UfficioFiliale {
	private String idUfficio;
	private String idFiliale; 
	
	public UfficioFiliale (String idUfficio, String idFiliale) {
		
		super();
		this.idUfficio = idUfficio;
		this.idFiliale = idFiliale;
	}

	public String getIdUfficio() {
		return idUfficio;
	}

	public String getIdFiliare() {
		return idFiliale;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFiliale == null) ? 0 : idFiliale.hashCode());
		result = prime * result + ((idUfficio == null) ? 0 : idUfficio.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 



	


}
