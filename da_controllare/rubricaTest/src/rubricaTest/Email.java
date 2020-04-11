package rubricaTest;

public class Email extends Contatto {

	private String email;
	
	public Email(Integer id, Integer contactsId, String types, String email) {
		super(id, contactsId, types);
		
		this.email=email;
		
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Email [email=" + email + "]";
	}

}
