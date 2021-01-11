package business_logic.board.types;

/**
 * Description of AbstractType.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */

public abstract class Type {

	/**
	 * The type description 
	 */
	private String description;

	/**
	 * The type nameType equals to the name of the subType
	 */
	private String nameType;

	/**
	 * The type id
	 */
	private int idType;

	/**
	 * 
	 * @param id type id
	 * @param nameType type class Name as String
	 * @param description type description
	 */
	public Type(int id, String nameType, String description) {
		this.idType = id;
		this.description = description;
		this.nameType = nameType;
	}

	public Type(String nameType, String description) {
		this.nameType = nameType;
		this.description = description;
	}

	/**
	 * Returns description.
	 * @return description 
	 */
	public String getDescription() {
		return this.description;
	}

	public String getNameType() {
		return nameType;
	}

	public int getIdType() {
		return idType;
	}
}