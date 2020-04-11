package it.intersistemi.corsojava.amazon.jdbc.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ResultSetUtil {
	private ResultSetUtil() {}
	public static Integer getInt(ResultSet rs, String columnLabel) throws SQLException {
		int value = rs.getInt(columnLabel);
		if(!rs.wasNull()) {
			return value;
		} else {
			return null;
		}
	}

	public static Long getLong(ResultSet rs, String columnLabel) throws SQLException {
		long value = rs.getLong(columnLabel);
		if(!rs.wasNull()) {
			return value;
		} else {
			return null;
		}
	}

	public static Double getDouble(ResultSet rs, String columnLabel) throws SQLException {
		double value = rs.getDouble(columnLabel);
		if(!rs.wasNull()) {
			return value;
		} else {
			return null;
		}
	}
}