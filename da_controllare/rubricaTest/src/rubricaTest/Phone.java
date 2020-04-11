package rubricaTest;

public class Phone extends Contatto {
	
	private String phone;

	public Phone(Integer id, Integer contactsId, String types, String phone) {
		super(id, contactsId, types);
		
		this.phone=phone;
		
		
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Phone [phone=" + phone + "]";
	}

	
}
