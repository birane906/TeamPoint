/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

invalid
// Start of user code (user defined imports)

// End of user code

/**
 * Description of PersonType.
 * 
 * @author 
 */
public class PersonType extends AbstractType implements  {
	/**
	 * Description of the property users.
	 */
	public HashSet<User> users = new HashSet<User>();
	
	// Start of user code (user defined attributes for PersonType)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public PersonType() {
		// Start of user code constructor for PersonType)
		super();
		// End of user code
	}
	
	/**
	 * Description of the method PersonTypes.
	 * @param users 
	 * @return 
	 */
	public PersonType PersonTypes(HashSet<User> users) {
		// Start of user code for method PersonTypes
		PersonType PersonTypes = null;
		return PersonTypes;
		// End of user code
	}
	 
	// Start of user code (user defined methods for PersonType)
	
	// End of user code
	/**
	 * Returns users.
	 * @return users 
	 */
	public HashSet<User> getUsers() {
		return this.users;
	}



}
