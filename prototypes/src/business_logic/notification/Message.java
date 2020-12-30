/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.notification;

// Start of user code (user defined imports)

// End of user code

import business_logic.user.User;

import java.util.HashSet;

/**
 * Description of Message.
 * 
 * @author Raphael
 */
public class Message {
	/**
	 * Description of the property date.
	 */
	private Object date;

	/**
	 * Description of the property messageSender.
	 */
	public User messageSender = null;

	/**
	 * Description of the property taggedUsers.
	 */
	public HashSet<User> taggedUsers = new HashSet<User>();

	/**
	 * Description of the property channel.
	 */
	public Channel channel = null;

	/**
	 * Description of the property notificationMessages.
	 */
	public HashSet<NotificationMessage> notificationMessages = new HashSet<NotificationMessage>();

	/**
	 * Description of the property content.
	 */
	private Object content;
	
	// Start of user code (user defined attributes for Message)
	
	// End of user code
	
	
	// Start of user code (user defined methods for Message)
	
	// End of user code
	/**
	 * Returns date.
	 * @return date 
	 */
	public Object getDate() {
		return this.date;
	}

	/**
	 * Sets a value to attribute date. 
	 * @param newDate 
	 */
	public void setDate(Object newDate) {
		this.date = newDate;
	}

	/**
	 * Returns messageSender.
	 * @return messageSender 
	 */
	public User getMessageSender() {
		return this.messageSender;
	}

	/**
	 * Sets a value to attribute messageSender. 
	 * @param newMessageSender 
	 */
	public void setMessageSender(User newMessageSender) {
		this.messageSender = newMessageSender;
	}

	/**
	 * Returns taggedUsers.
	 * @return taggedUsers 
	 */
	public HashSet<User> getTaggedUsers() {
		return this.taggedUsers;
	}

	/**
	 * Returns channel.
	 * @return channel 
	 */
	public Channel getChannel() {
		return this.channel;
	}

	/**
	 * Sets a value to attribute channel. 
	 * @param newChannel 
	 */
	public void setChannel(Channel newChannel) {
		this.channel = newChannel;
	}

	/**
	 * Returns notificationMessages.
	 * @return notificationMessages 
	 */
	public HashSet<NotificationMessage> getNotificationMessages() {
		return this.notificationMessages;
	}

	/**
	 * Returns content.
	 * @return content 
	 */
	public Object getContent() {
		return this.content;
	}

	/**
	 * Sets a value to attribute content. 
	 * @param newContent 
	 */
	public void setContent(Object newContent) {
		this.content = newContent;
	}

}
