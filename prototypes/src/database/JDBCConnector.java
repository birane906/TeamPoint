package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * {@link JDBCConnector} is a Singleton class. It holds the {@link Connection} to the database
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class JDBCConnector {

	/**
	 * The database connection
	 */
	// surtout pas final
	private Connection[] connection = new Connection[5];

	private JDBCConnector() {
		for(int i = 0; i < 4; i++) {
			try {
				this.connection[i] = (DriverManager.getConnection(
						"jdbc:mysql://sql2.freemysqlhosting.net/sql2386460?" + "user=sql2386460&password=rB9*wP6%25"
						+ "&useUnicode=true" + "&useJDBCCompliantTimezoneShift=true"
						+ "&useLegacyDatetimeCode=false" +	"&serverTimezone=UTC"));

			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	public Connection getConnection(int countConnection) {
		try {
			if(this.connection[countConnection] == null || this.connection[countConnection].isClosed()) {
				initializeConnection(countConnection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.connection[countConnection];

	}

	public void initializeConnection(int countConnection) {
		try {
			this.connection[countConnection] = DriverManager.getConnection(
					"jdbc:mysql://localhost/TeamPoint?" + "user=root&password="
							+ "&useUnicode=true" + "&useJDBCCompliantTimezoneShift=true"
							+ "&useLegacyDatetimeCode=false" +	"&serverTimezone=UTC");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection(int countConnection) {
		try {
			this.connection[countConnection].close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
