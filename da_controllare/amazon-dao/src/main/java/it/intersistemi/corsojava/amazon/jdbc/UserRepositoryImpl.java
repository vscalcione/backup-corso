package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.UserRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.UserRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<User> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM utente");
			return new UserRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findById(String id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente WHERE username = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			return new UserRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String insert(User obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO utente (username, email, password) "
					+ "VALUES (?, ?, ?)");
			stmt.setString(1, obj.getUsername());
			stmt.setString(2, obj.getEmail());
			stmt.setString(3, obj.getPassword());
			int result = stmt.executeUpdate();
			return obj.getUsername();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(User obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE utente SET email = ?, password = ?"
					+ "WHERE username = ?");
			stmt.setString(1, obj.getEmail());
			stmt.setString(2, obj.getPassword());
			stmt.setString(3, obj.getUsername());			
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findByMail(String mail) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utente WHERE email = ?");
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			return new UserRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
