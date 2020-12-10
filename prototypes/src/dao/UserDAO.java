/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.User;

/**
 * {@link UserDAO} class implements {@link DAO} interface
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public abstract class UserDAO implements DAO<User>{
	
	/**
	 * For a given email and password returns the corresponding {@link User}
	 * @param email an email as a {@link String}
	 * @param password the given password as a {@link String}
	 * @return Returns the corresponding {@link User} if found in the database
	 * otherwise throw an {@link Exception}
	 */
	public abstract User getUser(String email, String password) throws Exception;

	/**
	 * Creates User in the database.
	 * (Insert query)
	 * @param obj The object data structure must exist in the database 
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code> 
	 */
	// TODO docs
	public abstract boolean signUp(String name, String firstname, String email, String password);

	/**
	 * Removes the data corresponding to this object form the database.
	 * (Delete Query)
	 * @param obj The object data structure must exist in the database 
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 */
	// TODO docs
	/**
	 * Delete the user given in parameter in the MySQL database
	 * 
	 * @param the user that will be deleted
	 * @return true if the user is deleted, false if not precondition : user obj
	 *         must have an email postcondition: user obj is deleted in the
	 *         database, if an email is in the database multiple times the user
	 *         corresponding to the database is only deleted once
	 */
	public abstract boolean delete(String email);
}
