/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of AbstractType.
 * 
 * @author 
 */
public abstract class AbstractType {
	/**
	 * Description of the property description.
	 */
	public String description = "";

	// Start of user code (user defined attributes for AbstractType)

	// End of user code

	/**
	 * The constructor.
	 */
	public AbstractType() {
		// Start of user code constructor for AbstractType)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for AbstractType)

	// End of user code
	/**
	 * Returns description.
	 * @return description 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets a value to attribute description. 
	 * @param newDescription 
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

}
