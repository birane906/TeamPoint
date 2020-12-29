/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

invalid
// Start of user code (user defined imports)

// End of user code

/**
 * Description of StatusType.
 * 
 * @author 
 */
public class StatusType extends AbstractType implements  {
	/**
	 * Description of the property currentStatusLabel.
	 */
	private StatusLabel currentStatusLabel = null;
	
	/**
	 * Description of the property statusLabels.
	 */
	public HashSet<StatusLabel> statusLabels = new HashSet<StatusLabel>();
	
	// Start of user code (user defined attributes for StatusType)
	
	// End of user code
	
	
	/**
	 * Description of the method getStatusLabels.
	 * @return 
	 */
	public HashSet<StatusLabel> getStatusLabels() {
		// Start of user code for method getStatusLabels
		HashSet<StatusLabel> getStatusLabels = new HashSet<StatusLabel>();
		return getStatusLabels;
		// End of user code
	}
	 
	// Start of user code (user defined methods for StatusType)
	
	// End of user code
	/**
	 * Returns currentStatusLabel.
	 * @return currentStatusLabel 
	 */
	public StatusLabel getCurrentStatusLabel() {
		return this.currentStatusLabel;
	}
	
	/**
	 * Sets a value to attribute currentStatusLabel. 
	 * @param newCurrentStatusLabel 
	 */
	public void setCurrentStatusLabel(StatusLabel newCurrentStatusLabel) {
	    this.currentStatusLabel = newCurrentStatusLabel;
	}

	/**
	 * Returns statusLabels.
	 * @return statusLabels 
	 */
	public HashSet<StatusLabel> getStatusLabels() {
		return this.statusLabels;
	}



}
