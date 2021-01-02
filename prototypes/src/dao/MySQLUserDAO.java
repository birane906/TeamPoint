/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.User;
import business_logic.workspace.Workspace;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * MySQL specific DAO for User. This class extends {@link UserDAO}
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLUserDAO extends UserDAO {

	/**
	 * Removes the data corresponding to this object form the database.
	 * (Delete Query)
	 * @param email must exist in the database
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 */
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
			stmt = DAO.getConnection()
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

	@Override
	public HashSet<User> getWorkspaceMembers(Workspace workspace) {
		return null;
	}

	/**
	 * For a given email and password returns the corresponding {@link User}
	 * @param email an email as a {@link String}
	 * @param password the given password as a {@link String}
	 * @return Returns the corresponding {@link User} if found in the database
	 * otherwise throw an {@link Exception}
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
		PreparedStatement stmt = null;
		String query = "SELECT name, firstName, email, phoneNumber,"
				+ "profileDescription, birthday" + " FROM User "
				+ "WHERE email = ?"
				+ " AND password = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT idUser, name, firstName, email, phoneNumber,"
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
			
			resultat.add(rs.getInt("idUser") + "");
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

		int idUser = Integer.parseInt(resultat.get(0));
		String name = resultat.get(1);
		String firstName = resultat.get(2);
		String emailUser = resultat.get(3);
		String profileDesc = resultat.get(4);
		String phoneNumber = resultat.get(5);
		
		return new User(idUser, name, firstName, emailUser, profileDesc, phoneNumber);
	}

	/**
	 * Creates User in the database.
	 * (Insert query)
	 * @param name The object data structure must exist in the database
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code> 
	 */
	@Override
	public boolean signUp(String name, String firstname, 
		String email, String password) {
		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO User(name, firstName, email, password) VALUES(?, ?, ?, ?)";
		
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "INSERT INTO User"
				+ " (name, firstName, email, password) VALUES("
				+ DAO.stringFormat(name) + ", " 
				+ DAO.stringFormat(firstname) + ", " 
				+ DAO.stringFormat(email) + ", "
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

		// insert test
		System.out.println(mySQLUserDAO.signUp("name", "firstName", "emailCreated", "toto"));

		// Delete test
		System.out.println(mySQLUserDAO.delete("emailCreated"));
	}
}
