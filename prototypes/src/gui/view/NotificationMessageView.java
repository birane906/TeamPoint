/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

import gui.view.AbstractNotificationView;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of NotificationMessageView.
 * 
 * @author Raphael
 */
public class NotificationMessageView extends AbstractNotificationView {
	/**
	 * Description of the property notificationController.
	 */
	public NotificationMessageController notificationController = null;

	// Start of user code (user defined attributes for NotificationMessageView)

	// End of user code

	/**
	 * The constructor.
	 */
	public NotificationMessageView() {
		// Start of user code constructor for NotificationMessageView)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for NotificationMessageView)

	// End of user code
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
