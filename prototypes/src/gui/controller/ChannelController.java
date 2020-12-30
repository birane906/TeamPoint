/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.controller;

import business_logic.ChannelFacade;
import business_logic.notification.Channel;
import gui.view.ChannelView;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ChannelController.
 * 
 * @author Raphael
 */
public class ChannelController {
	/**
	 * Description of the property channelView.
	 */
	public ChannelView channelView = null;

	/**
	 * Description of the property channelFacade.
	 */
	public ChannelFacade channelFacade = null;

	// Start of user code (user defined attributes for ChannelController)

	// End of user code

	/**
	 * The constructor.
	 */
	public ChannelController() {
		// Start of user code constructor for ChannelController)
		super();
		// End of user code
	}

	/**
	 * Description of the method sendMessage.
	 * @param channel 
	 * @param message 
	 * @return 
	 */
	public Boolean sendMessage(Channel channel, String message) {
		// Start of user code for method sendMessage
		Boolean sendMessage = Boolean.FALSE;
		return sendMessage;
		// End of user code
	}

	// Start of user code (user defined methods for ChannelController)

	// End of user code
	/**
	 * Returns channelView.
	 * @return channelView 
	 */
	public ChannelView getChannelView() {
		return this.channelView;
	}

	/**
	 * Sets a value to attribute channelView. 
	 * @param newChannelView 
	 */
	/*
	public void setChannelView(ChannelView newChannelView) {
		if (this.channelView != null) {
			this.channelView.set(null);
		}
		this.channelView.set(this);
	}

	 */

	/**
	 * Returns channelFacade.
	 * @return channelFacade 
	 */
	public ChannelFacade getChannelFacade() {
		return this.channelFacade;
	}

	/**
	 * Sets a value to attribute channelFacade. 
	 * @param newChannelFacade 
	 */
	public void setChannelFacade(ChannelFacade newChannelFacade) {
		this.channelFacade = newChannelFacade;
	}

}
