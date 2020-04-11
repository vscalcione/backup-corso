package it.intersistemi.corsojava.amazon.dao.model;

public class SellerReviewPK {
	private String username;
	private String p_iva;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p_iva == null) ? 0 : p_iva.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		SellerReviewPK other = (SellerReviewPK) obj;
		if (p_iva == null) {
			if (other.p_iva != null)
				return false;
		} else if (!p_iva.equals(other.p_iva))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public SellerReviewPK(String username, String p_iva) {
		super();
		this.username = username;
		this.p_iva = p_iva;
	}

	public SellerReviewPK() {
		super();
	}

	@Override
	public String toString() {
		return "RecensioneVenditorePK [username=" + username + ", p_iva=" + p_iva + "]";
	}

}
