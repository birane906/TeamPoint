/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.util.HashSet;

import business_logic.notification.Message;
import business_logic.notification.NotificationMessage;
import business_logic.user.User;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLNotificationMessageDAO.
 * 
 * @author Raphael
 */
public class MySQLNotificationMessageDAO extends NotificationMessageDAO {
	// Start of user code (user defined attributes for MySQLNotificationMessageDAO)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public MySQLNotificationMessageDAO() {
		// Start of user code constructor for MySQLNotificationMessageDAO)
		super();
		// End of user code
	}
	
	/**
	 * create Notification Message. {@link NotificationMessage}
	 * @param message {@link Message}
	 * @param user {@link User}
	 * @return the message
	 */
	public Message createNotificationMessage(Message message, User user) {
		// Start of user code for method createNotificationMessage
		Message createNotificationMessage = null;
		return createNotificationMessage;
		// End of user code
	}
	 
	/**
	 * delete Notification Message.
	 * @param notificationMessage 
	 * @return a boolean according to the success of delete
	 */
	public Boolean deleteNotificationMessage(NotificationMessage notificationMessage) {
		// Start of user code for method deleteNotificationMessage
		Boolean deleteNotificationMessage = Boolean.FALSE;
		return deleteNotificationMessage;
		// End of user code
	}
	 
	/**
	 * retrieve All User Invitations.
	 * @param user we want the invitations
	 * @return a hashset of invitation and roles
	 */
	public HashSet<NotificationMessage> retrieveAllUserNotificationMessages(User user) {
		// Start of user code for method retrieveAllUserNotificationMessages
		HashSet<NotificationMessage> retrieveAllUserNotificationMessages = new HashSet<NotificationMessage>();
		return retrieveAllUserNotificationMessages;
		// End of user code
	}
	 
	// Start of user code (user defined methods for MySQLNotificationMessageDAO)
	
	// End of user code


}
