package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import database.JDBCConnector;

/**
 * {@link JDBCConnector} is a Singleton class. It holds the {@link Connection} to the database
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class JDBCConnector {

	/**
	 * The database connection
	 */
	private Connection connection;

	private JDBCConnector() {
		try {
			this.connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/TeamPoint?" + "user=root&password=");
		} catch (SQLException e) {
			//TODO explain dont get connection with database
			e.printStackTrace();
		}
	}
	
	/***
	 * The {@link JDBCConnectorHolder} guarantee the uniqueness of {@link JDBCConnector} instance
	 */
	private static class JDBCConnectorHolder {
		/**
		 * The unique instance of {@link JDBCConnector}
		 */
		private final static JDBCConnector JDBC_CONNECTOR = new JDBCConnector();
	}

	/***
	 * <code>static</code> method. Gives the unique instance of {@link JDBCConnector}
	 * @return Returns the {@link JDBCConnector} 
	 */
	public static JDBCConnector getJDBCConnectorInstance() {
		return JDBCConnectorHolder.JDBC_CONNECTOR;
	}

	/**
	 * Returns the database connection.
	 * @return Returns a {@link Connection}
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
