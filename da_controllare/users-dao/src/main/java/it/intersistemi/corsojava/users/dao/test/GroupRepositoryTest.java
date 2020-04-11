package it.intersistemi.corsojava.users.dao.test;

import org.apache.commons.dbcp2.BasicDataSource;

public class GroupRepositoryTest {
	private static BasicDataSource ds = new BasicDataSource();
	static {
		ds.setUrl("jdbc:h2:~/database_esercitazione");
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
