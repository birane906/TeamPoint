/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

import gui.controller.*;

/**
 * Description of NotificationMessageView.
 * 
 * @author
 */
public class NotificationMessageView extends AbstractNotificationView {
	/**
	 * Description of the property notificationController.
	 */
	public NotificationMessageController notificationController = null;

	/**
	 * The constructor.
	 */
	public NotificationMessageView() {
		super();
	}

	/**
	 * Returns notificationController.
	 * @return notificationController 
	 */
	public NotificationMessageController getNotificationController() {
		return this.notificationController;
	}

	/**
	 * Sets a value to attribute notificationController. 
	 * @param newNotificationController 
	 */
	public void setNotificationController(NotificationMessageController newNotificationController) {
		if (this.notificationController != null) {
			this.notificationController.set(null);
		}
		this.notificationController.set(this);
	}

}
