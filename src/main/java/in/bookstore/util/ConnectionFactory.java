package in.bookstore.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static DataSource ds = null;
	private static final String dburl = "jdbc:mysql://localhost:3306/bookstore";
	private static final String dbName = "root";
	private static final String dbpwd = "265254";
	private static final String driverName = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() throws SQLException {
		try {
			if (ds == null) {
				HikariConfig config = new HikariConfig();
				config.setUsername(dbName);
				config.setPassword(dbpwd);
				config.setJdbcUrl(dburl);
				config.setDriverClassName(driverName);

				ds = new HikariDataSource(config);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ds.getConnection();

	}
}
