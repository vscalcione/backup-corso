package rubricaTestModel;

import rubricaTest.Email;
import rubricaTest.Persona;
import rubricaTest.Phone;

public interface AddressBook {

	
	Iterable<Persona> findAllPerson();
	
	Iterable <Persona> searchPersons( String searchString);
	
	Persona getPersonById(Integer personId);
	
	Iterable<Email> findAllPersonEmail (Integer personId);
	
	Iterable<Phone> findAllPersonPhone(Integer personId);
	
}
