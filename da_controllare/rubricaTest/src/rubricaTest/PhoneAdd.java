package rubricaTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneAdd implements RowMapper<Phone> {

	

	@Override
	public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Phone phone= new Phone(0, 0, null, null);
		
		phone.setContactsId(rs.getInt("contactsId"));
		phone.setPhone(rs.getNString("phone"));
		phone.setTypes(rs.getString("types"));
		phone.setId(rs.getInt("id"));
		
		return phone;
		
	}

}
