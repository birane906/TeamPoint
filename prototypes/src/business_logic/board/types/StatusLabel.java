/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

/**
 * Class used in {@link StatusType} to define its label
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class StatusLabel {

	/**
	 * Hexadecimal code used to represent the {@link StatusLabel}
	 * color
	 */
	private String color;

	/**
	 * The label of the {@link StatusLabel}
	 */
	private String label;

	/**
	 * The {@link StatusType} using the {@link StatusLabel}
	 */
	private StatusType statusType;

	/**
	 * Constructor
	 * @param color Hexadecimal code as {@link String}
	 * @param label A {@link String}
	 * @param statusType The corresponding {@link StatusType}
	 */
	public StatusLabel(String color, String label, StatusType statusType){
		this.statusType = statusType;
		this.color = color;
		this.label = label;
	}

	/**
	 * @return The color used to represent the {@link StatusLabel}
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Sets the color of the {@link StatusLabel}
	 * @param color The new color of the {@link StatusLabel}
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return The label of the {@link StatusLabel}
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Sets the label of the {@link StatusLabel}
	 * @param label The new label of {@link StatusLabel}
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return The {@link StatusType} using the {@link StatusLabel}
	 */
	public StatusType getStatusType() {
		return this.statusType;
	}

	/**
	 * Sets the {@link StatusType} of the {@link StatusLabel}
	 * @param newStatusType The new {@link StatusType} of the {@link StatusLabel}
	 */
	public void setStatusType(StatusType newStatusType) {
		this.statusType = newStatusType;
	}

	public String toString() {
		return label;
	}

}
