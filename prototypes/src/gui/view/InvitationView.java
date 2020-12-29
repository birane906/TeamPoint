/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

import gui.controller.*;

/**
 * Description of InvitationView.
 * 
 * @author
 */
public class InvitationView extends AbstractNotificationView {
	/**
	 * Description of the property invitationController.
	 */
	public InvitationController invitationController = null;

	/**
	 * The constructor.
	 */
	public InvitationView() {
		super();
	}

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
