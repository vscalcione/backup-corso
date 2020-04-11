package rubricaTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import rubricaTestModel.AddressBook;

public class AddressBookImpl implements AddressBook {

	@Override
	public Iterable<Persona> findAllPerson() {
		
			try (
					Connection conn = DBConnectionUtil.getConnection();
					) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM persona");
				return new PersonaAdd().toList(rs);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}

	@Override
	public Iterable<Persona> searchPersons(String searchString) {
		try (
				Connection conn = DBConnectionUtil.getConnection();
				) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM persona WHERE nome like ? or cognome like ?");
			stmt.setString(1, searchString +"%");
			stmt.setString(2, searchString +"%");
			ResultSet rs = stmt.executeQuery();
			return new PersonaAdd().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Persona getPersonById(Integer personId) {
		try (
				Connection conn = DBConnectionUtil.getConnection();
				) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM persona WHERE id = ?");
			stmt.setInt(1, personId);
			ResultSet rs = stmt.executeQuery();
			return new PersonaAdd().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Email> findAllPersonEmail(Integer personId) {
		
		try (
				Connection conn = DBConnectionUtil.getConnection();
				) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM email");
			return new EmailAdd().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Phone> findAllPersonPhone(Integer personId) {
		try (
				Connection conn = DBConnectionUtil.getConnection();
				) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM phone");
			return new PhoneAdd().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
		
	
	
	}


