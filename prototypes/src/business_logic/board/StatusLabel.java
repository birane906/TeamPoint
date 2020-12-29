/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of StatusLabel.
 * 
 * @author 
 */
public class StatusLabel {
	/**
	 * Description of the property color.
	 */
	private String color = "";

	/**
	 * Description of the property label.
	 */
	private String label = "";

	/**
	 * Description of the property statusType.
	 */
	public StatusType statusType = null;

	// Start of user code (user defined attributes for StatusLabel)

	// End of user code

	// Start of user code (user defined methods for StatusLabel)

	// End of user code
	/**
	 * Returns color.
	 * @return color 
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Sets a value to attribute color. 
	 * @param newColor 
	 */
	public void setColor(String newColor) {
		this.color = newColor;
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
	 * Returns statusType.
	 * @return statusType 
	 */
	public StatusType getStatusType() {
		return this.statusType;
	}

	/**
	 * Sets a value to attribute statusType. 
	 * @param newStatusType 
	 */
	public void setStatusType(StatusType newStatusType) {
		this.statusType = newStatusType;
	}

}
