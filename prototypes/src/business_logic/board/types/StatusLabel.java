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
	 * The color used to represent the {@link StatusLabel}
	 */
	private String color;

	/**
	 * The label of the {@link StatusLabel}
	 */
	private String label;

	/**
	 * The {@link StatusType} using the {@link StatusLabel}
	 */
	public StatusType statusType;

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

}
