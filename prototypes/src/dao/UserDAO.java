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
	 * Creates an User in the database.
	 * (Insert query)
	 * @param name The name of the {@link User}
	 * @param firstname The first name of the {@link User}
	 * @param email The email of the {@link User}
	 * @param password The hashed password of the {@link User}
	 *
	 * @return Returns <code>true</code> if the operation succeed, <code>false</code> otherwise
	 *
	 */
	public abstract boolean signUp(String name, String firstname, String email, String password);

	/**
	 * Removes the data corresponding to this object form the database.
	 * (Delete Query)
	 * @param email of the user must exist in the database
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 */
	public abstract boolean delete(String email);

	/**
	 * Update the values of an {@link User}
	 * @param oldUser The {@link User} to be updated
	 * @param newUser The new {@link User} holding the changed values
	 * @return The {@link User} updated if the operation succeed, <code>null</code> otherwise
	 */
	public abstract User updateUserProfile(User oldUser, User newUser);

	/**
	 * Retrieve all the {@link User} of a {@link Workspace}
	 * @param workspace The given {@link Workspace}
	 * @return A {@link HashSet} of the {@link User} of the {@link Workspace}
	 */
	public abstract HashSet<User> getWorkspaceMembers(Workspace workspace);
}
