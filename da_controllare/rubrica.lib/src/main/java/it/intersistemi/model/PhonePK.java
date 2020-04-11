package it.intersistemi.model;

public class PhonePK {
	private int id;
	private int contactsId;
	
	public PhonePK(){
		
	}
	
	public PhonePK(int id, int conId){
		this.id=id;
		contactsId=conId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContactsId() {
		return contactsId;
	}

	public void setContactsId(int contactsId) {
		this.contactsId = contactsId;
	}
	
	
}
