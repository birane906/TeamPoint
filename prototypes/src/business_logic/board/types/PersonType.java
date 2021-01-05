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
	private User user;

	/**
	 * Create an empty {@link PersonType} 
	 * @param users A set of {@link User}
	 * @param id an int
	 */
	public PersonType(int id, String description, User user) {
		super(id, PersonType.class.getSimpleName(), description);
		this.user = user;
	}

	/**
	 * Create a {@link PersonType} giving a set of {@link User}
	 * @param users A set of {@link User}
	 * @param id an int
	 * @param description a description of the type
	 */
	public PersonType(User user, int id, String description) {
		super(id, PersonType.class.getSimpleName(), description);
		this.user = user;
	}

	/**
	 * @return All the {@link User} of the {@link PersonType}
	 */
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
