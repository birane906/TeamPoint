/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.notification;

import business_logic.notification.AbstractNotification;
import business_logic.notification.Message;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of NotificationMessage.
 * 
 * @author Raphael
 */
public class NotificationMessage extends AbstractNotification {
	/**
	 * Description of the property message.
	 */
	public Message message = null;

	// Start of user code (user defined attributes for NotificationMessage)

	// End of user code

	/**
	 * Description of the method AbstractNotification.
	 */
	public void AbstractNotification() {
		// Start of user code for method AbstractNotification
		// End of user code
	}

	// Start of user code (user defined methods for NotificationMessage)

	// End of user code
	/**
	 * Returns message.
	 * @return message 
	 */
	public Message getMessage() {
		return this.message;
	}

	/**
	 * Sets a value to attribute message. 
	 * @param newMessage 
	 */
	public void setMessage(Message newMessage) {
		this.message = newMessage;
	}

}
