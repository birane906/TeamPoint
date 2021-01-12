/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import java.util.HashSet;

import business_logic.notification.Channel;
import business_logic.notification.Message;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ChannelFacade.
 * 
 * @author Raphael
 */
public class ChannelFacade {
	/**
	 * Description of the property channelControllers.
	 */
	public HashSet<ChannelController> channelControllers = new HashSet<ChannelController>();

	// Start of user code (user defined attributes for ChannelFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public ChannelFacade() {
		// Start of user code constructor for ChannelFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getChannelFacadeInstance.
	 * @return 
	 */
	public static ChannelFacade getChannelFacadeInstance() {
		// Start of user code for method getChannelFacadeInstance
		ChannelFacade getChannelFacadeInstance = null;
		return getChannelFacadeInstance;
		// End of user code
	}

	/**
	 * Description of the method sendMessage.
	 * @param channel 
	 * @param message 
	 */
	public void sendMessage(Channel channel, String message) {
		// Start of user code for method sendMessage
		// End of user code
	}

	/**
	 * Description of the method notifyUsers.
	 * @param message 
	 * @return 
	 */
	public Boolean notifyUsers(Message message) {
		// Start of user code for method notifyUsers
		Boolean notifyUsers = Boolean.FALSE;
		return notifyUsers;
		// End of user code
	}

	// Start of user code (user defined methods for ChannelFacade)

	// End of user code
	/**
	 * Returns channelControllers.
	 * @return channelControllers 
	 */
	public HashSet<ChannelController> getChannelControllers() {
		return this.channelControllers;
	}

}
