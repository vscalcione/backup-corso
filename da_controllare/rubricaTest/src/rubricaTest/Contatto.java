package rubricaTest;

public class Contatto {
	
	private Integer id;
	private Integer contactsId;
	private String types;

	public Contatto( Integer id, Integer contactsId ,  String types        ) {
		
		this.contactsId = contactsId;
		this.id= id;
		this.types = types;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Contatto [id=" + id + ", contactsId=" + contactsId + ", types=" + types + "]";
	}
	
	
	
}
