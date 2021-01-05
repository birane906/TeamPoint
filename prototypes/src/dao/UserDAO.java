package dao;

import business_logic.user.User;
import business_logic.workspace.Workspace;

import java.util.HashSet;

/**
 * {@link UserDAO} class implements {@link DAO} interface
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public abstract class UserDAO implements DAO{
	
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
	 * @param name of user
	 * @param firstname of user
	 * @param email of user
	 * @param password of user
	 *
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 *
	 */
	// TODO verify doc
	public abstract boolean signUp(String name, String firstname, String email, String password);

	/**
	 * Removes the data corresponding to this object form the database.
	 * (Delete Query)
	 * @param email of the user must exist in the database
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 */
	public abstract boolean delete(String email);

	public abstract User updateUserProfile(User oldUser, User newUser);

	public abstract HashSet<User> getWorkspaceMembers(Workspace workspace);
}
