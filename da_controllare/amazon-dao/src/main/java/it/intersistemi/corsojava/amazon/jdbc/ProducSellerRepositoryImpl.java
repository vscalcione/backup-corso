package it.intersistemi.corsojava.amazon.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.intersistemi.corsojava.amazon.dao.mapper.SellerProductRowMapper;
import it.intersistemi.corsojava.amazon.dao.model.SellerProduct;
import it.intersistemi.corsojava.amazon.dao.model.SellerProductPK;
import it.intersistemi.corsojava.amazon.jpadao.SellerProductRepository;

@Repository
public class ProducSellerRepositoryImpl implements SellerProductRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public Iterable<SellerProduct> findAll() {
		try (Connection conn = ds.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM prodotto_venditore");
			return new SellerProductRowMapper().toList(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SellerProduct findById(SellerProductPK id) {
		try (Connection conn = ds.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM prodotto_venditore WHERE asin = ? and p_iva = ?");
			stmt.setString(1, id.getAsin());
			stmt.setString(2, id.getpIva());
			ResultSet rs = stmt.executeQuery();
			return new SellerProductRowMapper().toObject(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SellerProductPK insert(SellerProduct obj) {
try (Connection conn = ds.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO prodotto_venditore (asin, p_iva, prezzo, pezzi_disponibili) "
					+ "VALUES (?, ?, ?, ?)");
			stmt.setString(1, obj.getId().getAsin());
			stmt.setString(2, obj.getId().getpIva());
			stmt.setDouble(3, obj.getPrezzo());
			stmt.setInt(4, obj.getPezziDisponibili());
			int result = stmt.executeUpdate();
			return obj.getId();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(SellerProduct obj) {
		try (Connection conn = ds.getConnection()) {			
			PreparedStatement stmt = conn.prepareStatement(
					"UPDATE prodotto_venditore SET prezzo = ?, pezzi_disponibili = ? "
					+ "WHERE asin = ? and p_iva = ? ");
			stmt.setDouble(1, obj.getPrezzo());
			stmt.setInt(2, obj.getPezziDisponibili());
			stmt.setString(3, obj.getId().getAsin());
			stmt.setString(4, obj.getId().getpIva());			
			int result = stmt.executeUpdate();
			return result != 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean delete(SellerProduct obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(SellerProductPK id) {
		// TODO Auto-generated method stub
		return false;
	}

}
