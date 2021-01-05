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
	private Set<User> users;

	/**
	 * Create an empty {@link PersonType} 
	 * @param users A set of {@link User}
	 * @param id an int
	 */
	public PersonType(int id, String description) {
		super(id, PersonType.class.getSimpleName(), description);
		users = new HashSet<>();
	}

	/**
	 * Create a {@link PersonType} giving a set of {@link User}
	 * @param users A set of {@link User}
	 * @param id an int
	 * @param description a description of the type
	 */
	public PersonType(Set<User> users, int id, String description) {
		super(id, PersonType.class.getSimpleName(), description);
		this.users = users;
	}

	/**
	 * @return All the {@link User} of the {@link PersonType}
	 */
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
