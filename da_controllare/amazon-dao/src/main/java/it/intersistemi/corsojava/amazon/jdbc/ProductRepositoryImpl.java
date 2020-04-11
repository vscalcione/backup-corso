package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.ProductRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<Product> findAll() {

		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM prodotto");
			return new ProductRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Product findById(String id) {

		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prodotto WHERE asin = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			return new ProductRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String insert(Product obj) {

		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO prodotto (asin, nome, descrizione, marca, modello, categoria) "
					+ "VALUES (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, obj.getAsin());
			stmt.setString(2, obj.getNome());
			stmt.setString(3, obj.getDescrizione());
			stmt.setString(4, obj.getMarca());
			stmt.setString(5, obj.getModello());
			stmt.setInt(6, obj.getCategoriaId());
			int result = stmt.executeUpdate();
			return obj.getAsin();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Product obj) {

		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE prodotto SET nome = ?, descrizione = ?, marca = ?, modello = ?, categoria = ? "
					+ "WHERE asin = ?");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getDescrizione());
			stmt.setString(3, obj.getMarca());
			stmt.setString(4, obj.getModello());
			stmt.setInt(5, obj.getCategoriaId());
			stmt.setString(6, obj.getAsin());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Product> findByNome(String nome) {

		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prodotto WHERE UPPER(nome) LIKE ?");
			stmt.setString(1, nome.toUpperCase()+"%");
			ResultSet rs = stmt.executeQuery();
			return new ProductRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
