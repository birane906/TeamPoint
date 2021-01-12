/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import java.util.HashSet;

import business_logic.notification.NotificationMessage;
// Start of user code (user defined imports)


// End of user code

/**
 * Description of NotificationMessageFacade.
 * 
 * @author Raphael
 */
public class NotificationMessageFacade {
	/**
	 * Description of the property notificationControllers.
	 */
	public HashSet<NotificationMessageController> notificationControllers = new HashSet<NotificationMessageController>();

	// Start of user code (user defined attributes for NotificationMessageFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public NotificationMessageFacade() {
		// Start of user code constructor for NotificationMessageFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getNotificationFacadeInstance.
	 * @return 
	 */
	public static NotificationMessageFacade getNotificationFacadeInstance() {
		// Start of user code for method getNotificationFacadeInstance
		NotificationMessageFacade getNotificationFacadeInstance = null;
		return getNotificationFacadeInstance;
		// End of user code
	}

	/**
	 * Description of the method markNotificationAsRead.
	 * @param notification 
	 * @return 
	 */
	public Boolean markNotificationAsRead(NotificationMessage notification) {
		// Start of user code for method markNotificationAsRead
		Boolean markNotificationAsRead = Boolean.FALSE;
		return markNotificationAsRead;
		// End of user code
	}

	/**
	 * Description of the method deleteNotification.
	 * @param notification 
	 * @return 
	 */
	public Boolean deleteNotification(NotificationMessage notification) {
		// Start of user code for method deleteNotification
		Boolean deleteNotification = Boolean.FALSE;
		return deleteNotification;
		// End of user code
	}

	// Start of user code (user defined methods for NotificationMessageFacade)

	// End of user code
	/**
	 * Returns notificationControllers.
	 * @return notificationControllers 
	 */
	public HashSet<NotificationMessageController> getNotificationControllers() {
		return this.notificationControllers;
	}

}
