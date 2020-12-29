package business_logic.board;


/**
 * Description of Permission.
 * 
 * @author 
 */
public class Permission {
	/**
	 * Description of the property label.
	 */
	private Object label = null;

	/**
	 * Description of the property description.
	 */
	private Object description = null;

	/**
	 * Returns label.
	 * @return label 
	 */
	public Object getLabel() {
		return this.label;
	}

	/**
	 * Sets a value to attribute label. 
	 * @param newLabel 
	 */
	public void setLabel(Object newLabel) {
		this.label = newLabel;
	}

	/**
	 * Returns description.
	 * @return description 
	 */
	public Object getDescription() {
		return this.description;
	}

	/**
	 * Sets a value to attribute description. 
	 * @param newDescription 
	 */
	public void setDescription(Object newDescription) {
		this.description = newDescription;
	}

}
