package business_logic.board;


/**
 * Description of Permission.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Permission {
	
	private int idPermission;
	
	/**
	 * Description of the property label.
	 */
	private String label;

	/**
	 * Description of the property description.
	 */
	private String description;
	
	/**
	 * Constructor
	 * @param id permission id int
	 * @param label permission label {@link String}
	 * @param description permission description {@link String}
	 */
	public Permission(int id, String label, String description) {
		this.idPermission = id;
		this.label = label;
		this.description = description;
	}

	/**
	 * Returns label.
	 * @return label 
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Returns description.
	 * @return description 
	 */
	public String getDescription() {
		return this.description;
	}

	public int getIdPermission() {
		return idPermission;
	}

}
