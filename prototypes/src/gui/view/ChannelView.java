package gui.view;

import gui.controller.*;
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


	/**
	 * The constructor.
	 */
	public ChannelView() {
		super();
	}

	/**
	 * Description of the method start.
	 */
	public void start() {

	}

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
