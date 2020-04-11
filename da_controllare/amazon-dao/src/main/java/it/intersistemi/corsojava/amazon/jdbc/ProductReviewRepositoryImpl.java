package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.ProductReviewRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.ProductReviewRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.ProductReview;
import it.intersistemi.corsojava.amazon.dao.model.ProductReviewPK;

@Repository
public class ProductReviewRepositoryImpl implements ProductReviewRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<ProductReview> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM recensione_prodotto");
			return new ProductReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ProductReview findById(ProductReviewPK id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_prodotto WHERE "
					+ "username = ? and asin = ?");
			stmt.setString(1, id.getUsername());
			stmt.setString(2, id.getAsin());
			ResultSet rs = stmt.executeQuery();
			return new ProductReviewRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ProductReviewPK insert(ProductReview obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO recensione_prodotto (username, asin, punteggio, titolo, testo) "
					+ "VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, obj.getId().getUsername());
			stmt.setString(2, obj.getId().getAsin());
			stmt.setInt(3, obj.getPunteggio());
			stmt.setString(4, obj.getTitolo());
			stmt.setString(5, obj.getRecensione());
			int result = stmt.executeUpdate();
			return obj.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(ProductReview obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE recensione_prodotto SET punteggio = ?, titolo = ?, testo = ?"
					+ "WHERE username = ? and asin = ?");
			stmt.setInt(1, obj.getPunteggio());
			stmt.setString(2, obj.getTitolo());
			stmt.setString(3, obj.getRecensione());
			stmt.setString(4, obj.getId().getUsername());
			stmt.setString(5, obj.getId().getAsin());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<ProductReview> findByUsername(String username) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_prodotto WHERE "
					+ "username = ? ");
			stmt.setString(1, username);			
			ResultSet rs = stmt.executeQuery();
			return new ProductReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<ProductReview> findByAsinAndPunteggio(String asin, int punteggio) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_prodotto WHERE "
					+ "asin = ? and punteggio = ?");
			stmt.setString(1, asin);
			stmt.setInt(2, punteggio);
			ResultSet rs = stmt.executeQuery();
			return new ProductReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
