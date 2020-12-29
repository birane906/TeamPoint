/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.notification;

import business_logic.notification.AbstractNotification;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Invitation.
 * 
 * @author Raphael
 */
public class Invitation extends AbstractNotification {
	/**
	 * Description of the property role.
	 */
	private Object role = ;

	/**
	 * Description of the property workspace.
	 */
	public Workspace workspace = null;

	// Start of user code (user defined attributes for Invitation)

	// End of user code

	/**
	 * Description of the method accept.
	 */
	public void accept() {
		// Start of user code for method accept
		// End of user code
	}

	/**
	 * Description of the method refuse.
	 */
	public void refuse() {
		// Start of user code for method refuse
		// End of user code
	}

	/**
	 * Description of the method AbstractNotification.
	 */
	public void AbstractNotification() {
		// Start of user code for method AbstractNotification
		// End of user code
	}

	// Start of user code (user defined methods for Invitation)

	// End of user code
	/**
	 * Returns role.
	 * @return role 
	 */
	public Object getRole() {
		return this.role;
	}

	/**
	 * Sets a value to attribute role. 
	 * @param newRole 
	 */
	public void setRole(Object newRole) {
		this.role = newRole;
	}

	/**
	 * Returns workspace.
	 * @return workspace 
	 */
	public Workspace getWorkspace() {
		return this.workspace;
	}

	/**
	 * Sets a value to attribute workspace. 
	 * @param newWorkspace 
	 */
	public void setWorkspace(Workspace newWorkspace) {
		this.workspace = newWorkspace;
	}

}
