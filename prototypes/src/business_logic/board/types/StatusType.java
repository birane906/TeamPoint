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
public class StatusType extends Type {

	/**
	 * The current status of the {@link StatusType}
	 */
	private StatusLabel currentStatusLabel;

	/**
	 * All the possible {@link StatusLable} for the {@link StatusType}
	 */
	public Set<StatusLabel> statusLabels;

	/**
	 * Constructor for an empty {@link StatusType}
	 * @param id
	 * @param description
	 */
	public StatusType(int id, String description) {
		super(id, StatusType.class.getSimpleName(), description);
		currentStatusLabel = null;
		statusLabels = new HashSet<>();
	}
	
	/**
	 * Constructor for an empty {@link StatusType} with an existing
	 * set of {@link StatusLabel}
	 * @param id
	 * @param description
	 * @param statusLbls 
	 */
	public StatusType(int id, String description, Set<StatusLabel> statusLbls) {
		super(id, StatusType.class.getSimpleName(), description);
		currentStatusLabel = null;
		statusLabels = statusLbls;
	}

	/**
	 * Constructor for an empty {@link StatusType} with an existing
	 * set of {@link StatusLabel}
	 * @param id
	 * @param description
	 * @param statusLbls 
	 * @param statusLabel
	 */
	public StatusType(int id, String description, Set<StatusLabel> statusLbls, StatusLabel statusLabel) {
		super(id, StatusType.class.getSimpleName(), description);
		currentStatusLabel = statusLabel;
		statusLabels = statusLbls;
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

	public void setStatusLabels(Set<StatusLabel> statusLabels) {
		this.statusLabels = statusLabels;
	}
}
