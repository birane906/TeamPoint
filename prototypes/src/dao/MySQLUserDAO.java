/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.User;
import database.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * MySQL specific DAO for User. This class extends {@link UserDAO}
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLUserDAO extends UserDAO {

	@Override
	public boolean delete(String email) {
		if (email == null) {
			return false;
		}
		// Result from DB
		ResultSet rs = null;

		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
			stmt = getConnection()
				.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT idUser, email FROM User " 
			+ "WHERE email = " + DAO.stringFormat(email);

		try {
			rs = stmt.executeQuery(req);
			if(rs.next()) {
				rs.deleteRow();
				return true;
			}
			// if rs is empty
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public Connection getConnection() {
		return JDBCConnector.getJDBCConnectorInstance().getConnection();
	}

	/**
	 * ask to the database to return the line that correspond to an email and
	 * password
	 * 
	 * @param email
	 * @param password
	 * @return the User created
	 */
	@Override
	public User getUser(String email, String password) throws Exception {
		if (email == null || password == null) {
			throw new Exception();
		}
		// List of all fields to create an user
		ArrayList<String> resultat = new ArrayList<String>();
		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Getconnection from JDBCConnector
			stmt = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT name, firstName, email, phoneNumber,"
				+ "profileDescription, birthday" + " FROM User "
				+ "WHERE email = " + DAO.stringFormat(email) 
				+ " AND password = " + DAO.stringFormat(password);

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		if(rs.next()){
			resultat.add(rs.getString("name"));
			resultat.add(rs.getString("firstName"));

			resultat.add(rs.getString("email"));

			resultat.add(rs.getString("profileDescription"));
			resultat.add(rs.getString("phoneNumber"));
		}

		if (resultat.size() == 0) {
			// TODO customize Exception
			throw new Exception("User not found");
		}

		return new User(resultat.get(0), resultat.get(1), 
			resultat.get(2), resultat.get(3), resultat.get(4));
	}

	@Override
	public boolean signUp(String name, String firstname, 
		String email, String password) {
		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
			stmt = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "INSERT INTO User"
				+ " (name, firstName, email, password) VALUES("
				+ DAO.stringFormat(name) + ", " 
				+ DAO.stringFormat(firstname) 
				+ ", " + DAO.stringFormat(email) + ", "
				+ DAO.stringFormat(password) + ")";
		try {
			stmt.execute(req);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

		User user = null;
		
		// Login test
		try {
			user = mySQLUserDAO.getUser("galoisnicolas@gmail.com", "toto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(user);


		// TODO check utility
		// insert test
		//System.out.println(mySQLUserDAO.signUp("name", "firstName", "emailCreated", "toto"));

		// Delete test
		//System.out.println(mySQLUserDAO.delete("emailCreated"));
	}
}
