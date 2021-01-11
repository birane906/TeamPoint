package business_logic.board.types;

import business_logic.board.Column;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	// TODO faire label StatusLabel
	public String label;

	/**
	 * All the possible {@link StatusLabel} for the {@link StatusType}
	 */
	public List<StatusLabel> statusLabels = new ArrayList<>();

	/**
	 * Constructor for an empty {@link StatusType}
	 * @param id of the status
	 * @param description of the status
	 */
	public StatusType(int id, String description) {
		super(id, StatusType.class.getSimpleName(), description);
		currentStatusLabel = null;
		statusLabels = new ArrayList<>();
	}

	public StatusType(String label) {
		super(StatusLabel.class.getSimpleName(), "Status type");
		this.statusLabels.add(new StatusLabel("color", label, this));
	}
	
	/**
	 * Constructor for an empty {@link StatusType} with an existing
	 * set of {@link StatusLabel}
	 * @param id of the status
	 * @param description of the status
	 * @param statusLbls set of labels
	 */
	public StatusType(int id, String description, List<StatusLabel> statusLbls) {
		super(id, StatusType.class.getSimpleName(), description);
		currentStatusLabel = null;
		statusLabels = statusLbls;
	}

	/**
	 * Constructor for an empty {@link StatusType} with an existing
	 * set of {@link StatusLabel}
	 * @param id of status
	 * @param description of status
	 * @param statusLbls set of labels
	 * @param statusLabel label of the label
	 */
	public StatusType(int id, String description, List<StatusLabel> statusLbls, StatusLabel statusLabel) {
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
	public List<StatusLabel> getStatusLabels() {
		return statusLabels;
	}

	public void setStatusLabels(List<StatusLabel> statusLabels) {
		this.statusLabels = statusLabels;
	}

	public String toString() {
		String str = "";

		for (StatusLabel statusLabel: getStatusLabels()) {
			str += statusLabel;
			str += "/";
		}
		System.out.println("str");
		return str;
	}
}
