/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import database.JDBCConnector;

/**
 * DAO interface
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public interface DAO {
	
	/**
	 *  Format the date database for query 
	 * @param date from Date java package
	 * @return the correct String format according to SQL "yyyy-mm-dd"
	 */
	public static String dateFormat(Date date) {
		
		if(date == null) {
			return null;
		}
		
		// The ZoneId here has no implication since we only keep the year, month and day
		ZonedDateTime localDate = date.toInstant().atZone(ZoneId.of("Europe/Paris"));
		
		Integer year = localDate.getYear(); // Year
		String dateFormat = year.toString();
		dateFormat += "-";
		dateFormat += localDate.getMonthValue(); // Month
		dateFormat += "-";
		dateFormat += localDate.getDayOfMonth(); // Day
		
		return dateFormat;
	}
	
	/**
	 * Format the given string for database query
	 * @param String str
	 * @return a null pointer if str null, if not null return "str"
	 */
	public static String stringFormat(String str) {
		
		if(str == null) {
			return null;
		}
		
		return "\"" + str + "\"";
	}
	
	public static Connection getConnection() {
		return JDBCConnector.getJDBCConnectorInstance().getConnection();
	}

	/**
	 *
	 * @param name, table
	 * @return the column in the database according to a name, if not found return null
	 */
	public static boolean isNameExist(String name, String table) {

		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;

		String query = "SELECT * "
				+ "FROM `" + table + "` "
				+ "WHERE " + table + "Name = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
			return false;
		}

		String req = "SELECT * "
				+ "FROM `" + table + "` "
				+ "WHERE " + table + "Name = " + DAO.stringFormat(name);

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
			return false;
		}
		// if we have a result then move to the next line

		try {
			assert rs != null;
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}