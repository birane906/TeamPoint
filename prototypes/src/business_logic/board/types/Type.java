/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

/**
 * Description of AbstractType.
 * 
 * @author 
 */

public abstract class Type {

	/**
	 * Description of the property description.
	 */
	private String description;

	/**
	 * 
	 */
	private String nameType;

	/**
	 * 
	 */
	private int idType;

	/**
	 * The constructor.
	 */
	public Type(int id, String nameType, String description) {
		this.idType = id;
		this.description = description;
		this.nameType = nameType;
	}

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