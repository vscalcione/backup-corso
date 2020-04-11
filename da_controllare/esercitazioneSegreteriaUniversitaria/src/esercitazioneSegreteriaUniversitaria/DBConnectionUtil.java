package esercitazioneSegreteriaUniversitaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	static {
		try {
			String jdbcDriverClass = "org.h2.Driver";
			Class.forName(jdbcDriverClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:h2:tcp://localhost:9092/~/SegreteriaUniversitaria";
		String user = "sa";
		String password = "";
		return DriverManager.getConnection(jdbcUrl, user, password);
	}
	
//	public static void closeConnection(Connection connection) throws SQLException {
//		connection.close();
//	}
}
