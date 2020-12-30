/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.controller;

import business_logic.InvitationFacade;
import business_logic.notification.Invitation;
import gui.view.InvitationView;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of InvitationController.
 * 
 * @author Raphael
 */
public class InvitationController {
	/**
	 * Description of the property invitationView.
	 */
	public InvitationView invitationView = null;

	/**
	 * Description of the property invitationFacade.
	 */
	public InvitationFacade invitationFacade = null;

	// Start of user code (user defined attributes for InvitationController)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationController() {
		// Start of user code constructor for InvitationController)
		super();
		// End of user code
	}

	/**
	 * Description of the method acceptInvitation.
	 * @param invitation 
	 * @return 
	 */
	public Boolean acceptInvitation(Invitation invitation) {
		// Start of user code for method acceptInvitation
		Boolean acceptInvitation = Boolean.FALSE;
		return acceptInvitation;
		// End of user code
	}

	/**
	 * Description of the method refuseInvitation.
	 * @param invitation 
	 * @return 
	 */
	public Boolean refuseInvitation(Invitation invitation) {
		// Start of user code for method refuseInvitation
		Boolean refuseInvitation = Boolean.FALSE;
		return refuseInvitation;
		// End of user code
	}

	/**
	 * Description of the method markNotificationAsRead.
	 * @param invitation 
	 * @return 
	 */
	public Boolean markNotificationAsRead(Invitation invitation) {
		// Start of user code for method markNotificationAsRead
		Boolean markNotificationAsRead = Boolean.FALSE;
		return markNotificationAsRead;
		// End of user code
	}

	// Start of user code (user defined methods for InvitationController)

	// End of user code
	/**
	 * Returns invitationView.
	 * @return invitationView 
	 */
	public InvitationView getInvitationView() {
		return this.invitationView;
	}

	/**
	 * Sets a value to attribute invitationView. 
	 * @param newInvitationView 
	 */
	/*
	public void setInvitationView(InvitationView newInvitationView) {
		if (this.invitationView != null) {
			this.invitationView.set(null);
		}
		this.invitationView.set(this);
	}
	
	 */

	/**
	 * Returns invitationFacade.
	 * @return invitationFacade 
	 */
	public InvitationFacade getInvitationFacade() {
		return this.invitationFacade;
	}

	/**
	 * Sets a value to attribute invitationFacade. 
	 * @param newInvitationFacade 
	 */
	public void setInvitationFacade(InvitationFacade newInvitationFacade) {
		this.invitationFacade = newInvitationFacade;
	}

}
