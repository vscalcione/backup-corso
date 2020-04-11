package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.SellerRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.SellerRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Seller;

@Repository
public class SellerRepositoryImpl implements SellerRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<Seller> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM venditore");
			return new SellerRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Seller findById(String id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM venditore WHERE p_iva = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			return new SellerRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String insert(Seller obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO venditore (p_iva, nome, nazione) "
					+ "VALUES (?, ?, ?)");
			stmt.setString(1, obj.getpIva());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getNazione());
			int result = stmt.executeUpdate();
			return obj.getpIva();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Seller obj) {
		try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE prodotto SET nome = ?, nazione = ?"
					+ "WHERE p_iva = ?");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getNazione());
			stmt.setString(3, obj.getNome());			
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Seller> findByNome(String nome) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM venditore WHERE nome = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			return new SellerRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Seller> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
