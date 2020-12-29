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
// TODO verify if not really abstract
public class AbstractType {
	/**
	 * Description of the property description.
	 */
	private String description;
	private String nameType;
	private int idType;

	// Start of user code (user defined attributes for AbstractType)

	// End of user code

	/**
	 * The constructor.
	 */
	public AbstractType(int id, String nameType, String description) {
		this.idType = id;
		this.description = description;
		this.nameType = nameType;
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

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}
	
	public String toString() {
		String str = "";
		
		str += getIdType() + "/ ";
		str += getNameType() + "/ ";
		str += getDescription();
		
		return str;
	}

}
