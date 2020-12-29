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
	 * Description of the method createNotificationMessage.
	 * @param message 
	 * @param user 
	 * @return 
	 */
	public abstract Message createNotificationMessage(Message message, User user);

	/**
	 * Description of the method deleteNotificationMessage.
	 * @param notificationMessage 
	 * @return 
	 */
	public abstract Boolean deleteNotificationMessage(NotificationMessage notificationMessage);

	/**
	 * Description of the method retrieveAllUserNotificationMessages.
	 * @param user 
	 * @return 
	 */
	public abstract HashSet<NotificationMessage> retrieveAllUserNotificationMessages(User user);

	/**
	 * Description of the method dateFormat.
	 * @param date 
	 * @return 
	 */
	public Object dateFormat(Date date) {
		// Start of user code for method dateFormat
		// End of user code
	}

	/**
	 * Description of the method stringFormat.
	 * @param String str 
	 * @return 
	 */
	public Object stringFormat(String String str) {
		// Start of user code for method stringFormat
		// End of user code
	}
	 
	// Start of user code (user defined methods for NotificationMessageDAO)
	
	// End of user code


}
