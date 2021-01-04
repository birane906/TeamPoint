/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

import java.util.HashSet;
import java.util.Set;

/**
 * Type used in a {@link Column} to specify a status
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class StatusType extends Type   {
	/**
	 * The current status of the {@link StatusType}
	 */
	private StatusLabel currentStatusLabel;

	/**
	 * All the possible {@link StatusLable} for the {@link StatusType}
	 */
	public Set<StatusLabel> statusLabels;

	/**
	 * Create a new {@link StatusType} giving a {@link StatusLabel}
	 * @param currentStatusLabel The {@link StatusLabel} of the new {@link StatusType}
	 */
	public StatusType(int id, String nameType, String description) {
		super(id, nameType, description);
		currentStatusLabel = null;
		statusLabels = new HashSet<>();
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
	public Set<StatusLabel> getStatusLabels() {
		return statusLabels;
	}
}
