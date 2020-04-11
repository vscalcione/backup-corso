package rubricaTest;

import java.sql.ResultSet;
import java.sql.SQLException;




public class PersonaAdd implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		
		persona.setId(rs.getInt("id"));
		persona.setName(rs.getString("name"));
		persona.setSurname(rs.getString("surname"));

		
		return persona;
}}
