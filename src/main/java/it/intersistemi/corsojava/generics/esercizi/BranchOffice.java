package it.intersistemi.corsojava.generics.esercizi;

public class BranchOffice {

	private String branchOfficeId;
	private String officeId;

	public BranchOffice(String branchOfficeId, String officeId) {
		super();
		this.branchOfficeId = branchOfficeId;
		this.officeId = officeId;
	}

	public BranchOffice() {
	}

	public String getBranchOfficeId() {
		return branchOfficeId;
	}

	public void setBranchOfficeId(String branchOfficeId) {
		this.branchOfficeId = branchOfficeId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchOfficeId == null) ? 0 : branchOfficeId.hashCode());
		result = prime * result + ((officeId == null) ? 0 : officeId.hashCode());
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
		BranchOffice other = (BranchOffice) obj;
		if (branchOfficeId == null) {
			if (other.branchOfficeId != null)
				return false;
		} else if (!branchOfficeId.equals(other.branchOfficeId))
			return false;
		if (officeId == null) {
			if (other.officeId != null)
				return false;
		} else if (!officeId.equals(other.officeId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
}
