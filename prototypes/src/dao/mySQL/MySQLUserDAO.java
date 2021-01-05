package dao.mySQL;

import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.DAO;
import dao.UserDAO;

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
		ResultSet rs;

		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
			stmt = DAO.getConnection(0)
				.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT idUser, email FROM User " 
			+ "WHERE email = " + DAO.stringFormat(email);

		try {
			assert stmt != null;
			rs = stmt.executeQuery(req);
			if(rs.next()) {
				rs.deleteRow();
				
				DAO.closeConnection(0);
				
				return true;
			}
			// if rs is empty
			
			DAO.closeConnection(0);
			return false;
		} catch (SQLException e) {
			
			DAO.closeConnection(0);
			return false;
		}
	}

	@Override
	public User updateUserProfile(User oldUser, User newUser) {
		// TODO user update query to the database
		return null;
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
		ArrayList<String> fieldOfUser = new ArrayList<>();
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
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT idUser, name, firstName, email, phoneNumber,"
				+ "profileDescription, birthday" + " FROM User "
				+ "WHERE email = " + DAO.stringFormat(email) 
				+ " AND password = " + DAO.stringFormat(password);


		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		assert rs != null;
		if(rs.next()){

			fieldOfUser.add(rs.getInt("idUser") + "");
			fieldOfUser.add(rs.getString("name"));
			fieldOfUser.add(rs.getString("firstName"));

			fieldOfUser.add(rs.getString("email"));

			fieldOfUser.add(rs.getString("profileDescription"));
			fieldOfUser.add(rs.getString("phoneNumber"));
		}

		if (fieldOfUser.size() == 0) {
			throw new Exception("User not found");
		}

		int idUser = Integer.parseInt(fieldOfUser.get(0));
		String name = fieldOfUser.get(1);
		String firstName = fieldOfUser.get(2);
		String emailUser = fieldOfUser.get(3);
		String profileDesc = fieldOfUser.get(4);
		String phoneNumber = fieldOfUser.get(5);
		
		DAO.closeConnection(0);
		
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

		if(DAO.isNameExist(email, "user")) {
			return false;
		}

		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO User(name, firstName, email, password) VALUES(?, ?, ?, ?)";
		
		try {
			// Getconnection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "INSERT INTO User"
				+ " (name, firstName, email, password) VALUES("
				+ DAO.stringFormat(name) + ", " 
				+ DAO.stringFormat(firstname) + ", " 
				+ DAO.stringFormat(email) + ", "
				+ DAO.stringFormat(password) + ")";
		try {
			assert stmt != null;
			stmt.executeQuery(req);
		} catch (SQLException e) {

			return false;
		}
		
		DAO.closeConnection(0);
		return true;
	}

	// TODO
	public boolean editUser(String field, String value) {
		return false;
	}

	public static void main(String[] args) {
		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

		User user = null;
		
		// Login test
		try {
			user = mySQLUserDAO.getUser("galoisnicolas@gmail.com", "toto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(user);

		// insert test
		System.out.println(mySQLUserDAO.signUp("name", "firstName", "emailCreated", "toto"));

		// Delete test
		System.out.println(mySQLUserDAO.delete("emailCreated"));
	}
}
