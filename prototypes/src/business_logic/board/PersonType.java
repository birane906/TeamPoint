package business_logic.board;

import business_logic.user.User;

import java.util.HashSet;

/**
 * Type used in a {@link Column} to specify a set of {@link User}
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class PersonType extends AbstractType {
	/**
	 * All the {@link User} of the {@link PersonType}
	 */
	public HashSet<User> users;
	
	/**
	 * Create an empty {@link PersonType}
	 */
	
	/**
	 * Create a {@link PersonType} giving a set of {@link User}
	 * @param users A set of {@link User}
	 */
	public PersonType(HashSet<User> users, int id, String nameType, String description) {
		super(id, nameType, description);
	}
	 
	/**
	 * @return All the {@link User} of the {@link PersonType}
	 */
	public HashSet<User> getUsers() {
		return this.users;
	}

}
