package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.SellerReviewRepository;
import it.intersistemi.corsojava.amazon.dao.mapper.SellerReviewRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.SellerReview;
import it.intersistemi.corsojava.amazon.dao.model.SellerReviewPK;

@Repository
public class SellerReviewRepositoryImpl implements SellerReviewRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<SellerReview> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM recensione_venditore");
			return new SellerReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SellerReview findById(SellerReviewPK id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_venditore WHERE "
					+ "username = ? and p_iva = ?");
			stmt.setString(1, id.getUsername());
			stmt.setString(2, id.getP_iva());
			ResultSet rs = stmt.executeQuery();
			return new SellerReviewRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SellerReviewPK insert(SellerReview obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO recensione_venditore (username, p_iva, punteggio, titolo, testo) "
					+ "VALUES (?, ?, ?, ?, ?)");
			stmt.setString(1, obj.getId().getUsername());
			stmt.setString(2, obj.getId().getP_iva());
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
	public boolean update(SellerReview obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE recensione_venditore SET punteggio = ?, titolo = ?, testo = ?"
					+ "WHERE username = ? and p_iva = ?");
			stmt.setInt(1, obj.getPunteggio());
			stmt.setString(2, obj.getTitolo());
			stmt.setString(3, obj.getRecensione());
			stmt.setString(4, obj.getId().getUsername());
			stmt.setString(5, obj.getId().getP_iva());
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<SellerReview> findByUsername(String username) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_venditore WHERE "
					+ "username = ? ");
			stmt.setString(1, username);			
			ResultSet rs = stmt.executeQuery();
			return new SellerReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<SellerReview> findByPIva(String pIva) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_venditore WHERE "
					+ "p_iva = ? ");
			stmt.setString(1, pIva);			
			ResultSet rs = stmt.executeQuery();
			return new SellerReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterable<SellerReview> findByPIvaAndPunteggio(String pIva, int punteggio) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM recensione_venditore WHERE "
					+ "p_iva = ? and punteggio = ? ");
			stmt.setString(1, pIva);
			stmt.setInt(2, punteggio);
			ResultSet rs = stmt.executeQuery();
			return new SellerReviewRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
