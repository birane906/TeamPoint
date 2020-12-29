/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

import gui.view.AbstractNotificationView;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of InvitationView.
 * 
 * @author Raphael
 */
public class InvitationView extends AbstractNotificationView {
	/**
	 * Description of the property invitationController.
	 */
	public InvitationController invitationController = null;

	// Start of user code (user defined attributes for InvitationView)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationView() {
		// Start of user code constructor for InvitationView)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for InvitationView)

	// End of user code
	/**
	 * Returns invitationController.
	 * @return invitationController 
	 */
	public InvitationController getInvitationController() {
		return this.invitationController;
	}

	/**
	 * Sets a value to attribute invitationController. 
	 * @param newInvitationController 
	 */
	public void setInvitationController(InvitationController newInvitationController) {
		if (this.invitationController != null) {
			this.invitationController.set(null);
		}
		this.invitationController.set(this);
	}

}
