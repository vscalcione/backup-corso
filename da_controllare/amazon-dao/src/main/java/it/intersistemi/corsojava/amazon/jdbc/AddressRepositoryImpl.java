package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.AddressRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.AddressRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Address;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<Address> findAll() {
		try (Connection conn = ds.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM indirizzo");
			return new AddressRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Address findById(Integer id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM indirizzo WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			return new AddressRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer insert(Address obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO indirizzo ( username, nominativo, via, cap, citta, provincia, "
					+ "nazione, numero_di_telefono) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, obj.getNominativo());
			stmt.setString(3, obj.getVia());
			stmt.setString(4, obj.getCap());
			stmt.setString(5, obj.getCitta());
			stmt.setString(6, obj.getProvincia());
			stmt.setString(7, obj.getNazione());
			stmt.setString(8, obj.getNumeroTelefono());
			int result = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if( rs.next()) {
				obj.setId(rs.getInt(1));
			}
			return obj.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Address obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE indirizzo SET username = ?, nominativo = ?, via = ?, cap = ?, citta = ?"
					+ ", provincia = ?, nazione = ?, numero_di_telefono = ?"
					+ "WHERE id = ?");			
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, obj.getNominativo());
			stmt.setString(3, obj.getVia());
			stmt.setString(4, obj.getCap());
			stmt.setString(5, obj.getCitta());
			stmt.setString(6, obj.getProvincia());
			stmt.setString(7, obj.getNazione());
			stmt.setString(8, obj.getNumeroTelefono());
			stmt.setInt(9, obj.getId());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Address> findByUsername(String username) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM indirizzo WHERE username = ?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			return new AddressRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
