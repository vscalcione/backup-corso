package it.intersistemi.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import it.intersistemi.exception.DataAccessException;

public class ConnectionUtil {
	
	private static final String JDBC_PROPERTIES_FILE = "jdbc.properties";
	private static final String PROP_JDBC_DRIVER = "jdbc.driver";
	private static final String PROP_JDBC_URL = "jdbc.url";
	private static final String PROP_JDBC_USER = "jdbc.user";
	private static final String PROP_JDBC_PASSWORD = "jdbc.password";
	
	private static final Properties JDBC_PROPERTIES = new Properties();
	
	static {
		try {
			InputStream is = ConnectionUtil.class.getResourceAsStream(JDBC_PROPERTIES_FILE);
			JDBC_PROPERTIES.load(is);

			Class.forName(JDBC_PROPERTIES.getProperty(PROP_JDBC_DRIVER));
		} catch (ClassNotFoundException e) {
			throw new DataAccessException(e.getMessage(), e);
		} catch (IOException e) {
			throw new DataAccessException(e.getMessage(), e);
		}
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					JDBC_PROPERTIES.getProperty(PROP_JDBC_URL),
					JDBC_PROPERTIES.getProperty(PROP_JDBC_USER),
					JDBC_PROPERTIES.getProperty(PROP_JDBC_PASSWORD));
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage(), e);
		}
	}
}
