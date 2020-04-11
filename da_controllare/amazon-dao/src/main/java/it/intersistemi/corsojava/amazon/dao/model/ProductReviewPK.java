package it.intersistemi.corsojava.amazon.dao.model;

public class ProductReviewPK {
	private String username;
	private String asin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asin == null) ? 0 : asin.hashCode());
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
		ProductReviewPK other = (ProductReviewPK) obj;
		if (asin == null) {
			if (other.asin != null)
				return false;
		} else if (!asin.equals(other.asin))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public ProductReviewPK(String username, String asin) {
		super();
		this.username = username;
		this.asin = asin;
	}

	public ProductReviewPK() {
		super();
	}

	@Override
	public String toString() {
		return "RecensioneProdottoPK [username=" + username + ", asin=" + asin + "]";
	}

}
