/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao.mongoDB;

import java.util.HashSet;

import business_logic.notification.Message;
import business_logic.notification.NotificationMessage;
import business_logic.user.User;
import dao.NotificationMessageDAO;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoNotificationMessageDAO.
 * 
 * @author Raphael
 */
public class MongoNotificationMessageDAO extends NotificationMessageDAO {
	// Start of user code (user defined attributes for MongoNotificationMessageDAO)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public MongoNotificationMessageDAO() {
		// Start of user code constructor for MongoNotificationMessageDAO)
		super();
		// End of user code
	}
	
	/**
	 * Description of the method createNotificationMessage.
	 * @param message 
	 * @param user 
	 * @return 
	 */
	public Message createNotificationMessage(Message message, User user) {
		// Start of user code for method createNotificationMessage
		Message createNotificationMessage = null;
		return createNotificationMessage;
		// End of user code
	}
	 
	/**
	 * Description of the method deleteNotificationMessage.
	 * @param notificationMessage 
	 * @return 
	 */
	public Boolean deleteNotificationMessage(NotificationMessage notificationMessage) {
		// Start of user code for method deleteNotificationMessage
		Boolean deleteNotificationMessage = Boolean.FALSE;
		return deleteNotificationMessage;
		// End of user code
	}
	 
	/**
	 * Description of the method retrieveAllUserNotificationMessages.
	 * @param user 
	 * @return 
	 */
	public HashSet<NotificationMessage> retrieveAllUserNotificationMessages(User user) {
		// Start of user code for method retrieveAllUserNotificationMessages
		HashSet<NotificationMessage> retrieveAllUserNotificationMessages = new HashSet<NotificationMessage>();
		return retrieveAllUserNotificationMessages;
		// End of user code
	}
	 
	// Start of user code (user defined methods for MongoNotificationMessageDAO)
	
	// End of user code


}
