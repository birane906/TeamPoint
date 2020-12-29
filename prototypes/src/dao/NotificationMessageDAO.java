/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Message;
import business_logic.notification.NotificationMessage;
import business_logic.user.User;
import dao.DAO;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of NotificationMessageDAO.
 * 
 * @author Raphael
 */
public abstract class NotificationMessageDAO implements DAO {
	// Start of user code (user defined attributes for NotificationMessageDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public NotificationMessageDAO() {
		// Start of user code constructor for NotificationMessageDAO)
		super();
		// End of user code
	}

	/**
	 * create Notification Message. {@link NotificationMessage}
	 * @param message {@link Message}
	 * @param user {@link User}
	 * @return the message
	 */
	public abstract Message createNotificationMessage(Message message, User user);

	/**
	 * delete Notification Message.
	 * @param notificationMessage 
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteNotificationMessage(NotificationMessage notificationMessage);

	/**
	 * retrieve All User Invitations.
	 * @param user we want the invitations
	 * @return a hashset of invitation and roles
	 */
	public abstract HashSet<NotificationMessage> retrieveAllUserNotificationMessages(User user);
	 
	// Start of user code (user defined methods for NotificationMessageDAO)
	
	// End of user code


}
