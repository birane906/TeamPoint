/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ChannelView.
 * 
 * @author Raphael
 */
public class ChannelView {
	/**
	 * Description of the property channelController.
	 */
	public ChannelController channelController = null;

	// Start of user code (user defined attributes for ChannelView)

	// End of user code

	/**
	 * The constructor.
	 */
	public ChannelView() {
		// Start of user code constructor for ChannelView)
		super();
		// End of user code
	}

	/**
	 * Description of the method start.
	 */
	public void start() {
		// Start of user code for method start
		// End of user code
	}

	// Start of user code (user defined methods for ChannelView)

	// End of user code
	/**
	 * Returns channelController.
	 * @return channelController 
	 */
	public ChannelController getChannelController() {
		return this.channelController;
	}

	/**
	 * Sets a value to attribute channelController. 
	 * @param newChannelController 
	 */
	public void setChannelController(ChannelController newChannelController) {
		if (this.channelController != null) {
			this.channelController.set(null);
		}
		this.channelController.set(this);
	}

}
