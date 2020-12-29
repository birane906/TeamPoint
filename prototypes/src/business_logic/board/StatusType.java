/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

/**
 * Type used in a {@link Column} to specify a status
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class StatusType extends AbstractType implements  {
	/**
	 * The current status of the {@link StatusType}
	 */
	private StatusLabel currentStatusLabel;

	/**
	 * All the possible {@link StatusLable} for the {@link StatusType}
	 */
	public HashSet<StatusLabel> statusLabels;

	/**
	 * Create a new {@link StatusType} giving a {@link StatusLabel}
	 * @param currentStatusLabel The {@link StatusLabel} of the new {@link StatusType}
	 */
	public StatusType(StatusLabel currentStatusLabel) {
		this.currentStatusLabel = currentStatusLabel;
	}
	
	/**
	 * @return The current status of the {@link StatusType}
	 */
	public StatusLabel getCurrentStatusLabel() {
		return this.currentStatusLabel;
	}
	
	/**
	 * Sets the {@link StatusLabel} of the {@link StatusType}
	 * @param currentStatusLabel The new {@link StatusLabel}
	 */
	public void setCurrentStatusLabel(StatusLabel currentStatusLabel) {
	    this.currentStatusLabel = currentStatusLabel;
	}

	/**
	 * @return All the possible {@link StatusLabel} for the {@link StatusType}
	 */
	public HashSet<StatusLabel> getStatusLabels() {
		return statusLabels;
	}
}
