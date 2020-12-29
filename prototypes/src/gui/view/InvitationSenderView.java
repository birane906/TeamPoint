/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

import gui.controller.*;

/**
 * Description of InvitationSenderView.
 * 
 * @author Raphael
 */
public class InvitationSenderView {
	/**
	 * Description of the property invitationSenderController.
	 */
	public InvitationSenderController invitationSenderController = null;

	/**
	 * The constructor.
	 */
	public InvitationSenderView() {
		super();
	}

	/**
	 * Description of the method start.
	 */
	public void start() {
	}

	/**
	 * Returns invitationSenderController.
	 * @return invitationSenderController 
	 */
	public InvitationSenderController getInvitationSenderController() {
		return this.invitationSenderController;
	}

	/**
	 * Sets a value to attribute invitationSenderController. 
	 * @param newInvitationSenderController 
	 */
	public void setInvitationSenderController(InvitationSenderController newInvitationSenderController) {
		if (this.invitationSenderController != null) {
			this.invitationSenderController.set(null);
		}
		this.invitationSenderController.set(this);
	}

}
