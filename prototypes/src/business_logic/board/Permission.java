package business_logic.board;


/**
 * Description of Permission.
 * 
 * @author 
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
	 * Sets a value to attribute label. 
	 * @param newLabel 
	 */
	public void setLabel(String newLabel) {
		this.label = newLabel;
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

	public int getIdPermission() {
		return idPermission;
	}

}
