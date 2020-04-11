package rubricaTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailAdd implements RowMapper<Email> {

		@Override
		public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			
			Email email = new Email(0, 0, null, null);
			
			email.setContactsId(rs.getInt("contactsId"));
			email.setEmail(rs.getNString("email"));
			email.setTypes(rs.getString("types"));
			email.setId(rs.getInt("id"));
			
			return email;
			
		}
		
	}


