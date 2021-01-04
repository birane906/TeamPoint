package business_logic.board.types;

import business_logic.user.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Type used in a {@link Column} to specify a set of {@link User}
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class PersonType extends Type {
	/**
	 * All the {@link User} of the {@link PersonType}
	 */
	public Set<User> users;
	
	/**
	 * Create an empty {@link PersonType}
	 */
	
	/**
	 * Create a {@link PersonType} giving a set of {@link User}
	 * @param users A set of {@link User}
	 */
	public PersonType(int id, String nameType, String description) {
		super(id, nameType, description);
		users = new HashSet<>();
	}
	 
	/**
	 * @return All the {@link User} of the {@link PersonType}
	 */
	public Set<User> getUsers() {
		return this.users;
	}

}
