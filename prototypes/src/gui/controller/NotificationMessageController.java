/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.controller;

import business_logic.NotificationMessageFacade;
import business_logic.notification.NotificationMessage;
import gui.view.NotificationMessageView;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of NotificationMessageController.
 * 
 * @author Raphael
 */
public class NotificationMessageController {
	/**
	 * Description of the property notificationFacade.
	 */
	public NotificationMessageFacade notificationFacade = null;

	/**
	 * Description of the property notificationMessageView.
	 */
	public NotificationMessageView notificationMessageView = null;

	// Start of user code (user defined attributes for NotificationMessageController)

	// End of user code

	/**
	 * The constructor.
	 */
	public NotificationMessageController() {
		// Start of user code constructor for NotificationMessageController)
		super();
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

	// Start of user code (user defined methods for NotificationMessageController)

	// End of user code
	/**
	 * Returns notificationFacade.
	 * @return notificationFacade 
	 */
	public NotificationMessageFacade getNotificationFacade() {
		return this.notificationFacade;
	}

	/**
	 * Sets a value to attribute notificationFacade. 
	 * @param newNotificationFacade 
	 */
	public void setNotificationFacade(NotificationMessageFacade newNotificationFacade) {
		this.notificationFacade = newNotificationFacade;
	}

	/**
	 * Returns notificationMessageView.
	 * @return notificationMessageView 
	 */
	public NotificationMessageView getNotificationMessageView() {
		return this.notificationMessageView;
	}

	/**
	 * Sets a value to attribute notificationMessageView. 
	 * @param newNotificationMessageView 
	 */
	/*
	public void setNotificationMessageView(NotificationMessageView newNotificationMessageView) {
		if (this.notificationMessageView != null) {
			this.notificationMessageView.set(null);
		}
		this.notificationMessageView.set(this);
	}

	 */

}
