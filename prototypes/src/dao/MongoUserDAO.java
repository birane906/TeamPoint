/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.User;

/**
 * MongoDB specific DAO for User. This class extends {@link UserDAO}
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MongoUserDAO extends UserDAO {
	/**
	 * The constructor.
	 */
	public MongoUserDAO() {
		//TODO construct the UserDAO object
	}

	@Override
	public boolean delete(String email) {
		// TODO user deletion query to the database
		return false;
	}

	@Override
	public User getUser(String email, String password) throws Exception {
		//TODO user select where email and pwd query in the database
		return null;
	}

	@Override
	public boolean signUp(String name, String firstname, String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}