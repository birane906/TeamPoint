/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.notification;

// Start of user code (user defined imports)

// End of user code

import business_logic.user.User;

/**
 * Description of AbstractNotification.
 * 
 * @author Raphael
 */
public abstract class AbstractNotification {
	/**
	 * Description of the property isRead.
	 */
	private Object isRead;

	/**
	 * Description of the property date.
	 */
	private Object date;

	/**
	 * Description of the property user.
	 */
	public User user = null;

	// Start of user code (user defined attributes for AbstractNotification)

	// End of user code

	// Start of user code (user defined methods for AbstractNotification)

	// End of user code
	/**
	 * Returns isRead.
	 * @return isRead 
	 */
	public Object getIsRead() {
		return this.isRead;
	}

	/**
	 * Sets a value to attribute isRead. 
	 * @param newIsRead 
	 */
	public void setIsRead(Object newIsRead) {
		this.isRead = newIsRead;
	}

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
	 * Returns user.
	 * @return user 
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets a value to attribute user. 
	 * @param newUser 
	 */
	public void setUser(User newUser) {
		this.user = newUser;
	}

}
