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
	
	/**
	 * The constructor.
	 */
	public MySQLUserDAO() {}

	/**
	 * Insert a new User in the database
	 * precondition: User obj must have at least an email and a password
	 * postcondition: the user is created in the database
	 * @return true if the user is correctly created, false if not
	 */
	// TODO Check if email is already in the db
	// TODO find solution for password without stocking it in a user
	@Override
	public Boolean create(User obj) {
		
		if(obj.getEmail() == null || obj.getPassword() == null) {
			return false;
		}
		
		// Query statement
		Statement stmt = null;
				
		try {
			// Getconnection
			stmt = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
		
		String date = DAO.dateFormat(obj.getBirthday());
		
		String req = "INSERT INTO User"
				+ " (name, firstName, email, password, phoneNumber, profileDescription, birthday)" + 
				" VALUES(" + obj.getName() + ", " + obj.getFirstName() + ", " + 
				obj.getEmail() + ", " + obj.getPassword() + ", " + 
				DAO.nullStringFormat(obj.getPhoneNumber()) + ", " + DAO.nullStringFormat(obj.getProfileDescription()) + 
				", " + DAO.nullStringFormat(date) + ")";
		
			try {
				
				stmt.execute(req);
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
	}

	/**
	 * Delete the user given in parameter in the MySQL database
	 * @param the user that will be deleted
	 * @return true if the user is deleted, false if not
	 * precondition : user obj must have an email
	 * postcondition: user obj is deleted in the database,
	 * 				  if an email is in the database multiple times the user corresponding to the database 
	 * 				  is only deleted once
	 */
	@Override
	public Boolean delete(User obj) {
		
		if(obj.getEmail() == null) {
			return false;
		}
		
		// Result from DB
		ResultSet rs = null;
		
		// Query statement
		Statement stmt = null;
		
		try {
			// Getconnection
			stmt = getConnection().createStatement(
		              ResultSet.TYPE_SCROLL_SENSITIVE,
		              ResultSet.CONCUR_UPDATABLE);		
			} 
		catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
	    
	    
		String req = "SELECT idUser, email FROM User " + 
				"WHERE email = '" + obj.getEmail() + "'";
		
		try {
			rs = stmt.executeQuery(req);
			
			while(rs.next()){
				rs.deleteRow();
				return true;
	        }  
			return false;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}	
		
	public Connection getConnection() {
		return JDBCConnector.getJDBCConnectorInstance().getConnection();
	}

	/**ask to the database to return the line that correspond to an email and password
	 * @param email 
	 * @param password 
	 * @return the User created
	 */
	@Override
	public User getUser(String email, String password) throws Exception {
		//TODO adjust, correct getUser
		
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
		
		String req = "SELECT idUser, name, firstName, email, phoneNumber, profileDescription, birthday" + 
					 " FROM User "
					 + "WHERE email = '" + email + "'" + " AND password = '" + password + "'";

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
			
			while (rs.next()) {
				
            	resultat.add(rs.getString("name"));
            	resultat.add(rs.getString("firstName"));
                
            	resultat.add(rs.getString("email"));
                
            	resultat.add(rs.getString("profileDescription"));
            	resultat.add(rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		if (resultat.size() == 0) {
			throw new Exception("User not found");
		}
		
		User user = new User(resultat.get(0), resultat.get(1), resultat.get(2), resultat.get(3), resultat.get(4));
		System.out.println(user.toString());
		return user;
	}

/*
	public static void main(String[] args) {
		
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

		// Login test

		try {
			mySQLUserDAO.getUser("galoisnicolas@gmail.com", "toto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// insert test
		System.out.println(mySQLUserDAO.create(new User(null, null, "emailCreated", "pass", null, null)));
		
		// Delete test
		System.out.println(mySQLUserDAO.delete(new User(null, null, "emailCreated", "pass", null, null)));
	}
*/
}
