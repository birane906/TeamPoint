/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.controller;

import business_logic.user.User;
import business_logic.workspace.Workspace;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of InvitationSenderController.
 * 
 * @author Raphael
 */
public class InvitationSenderController {
	/**
	 * Description of the property invitationSenderFacade.
	 */
	public WorkspaceFacade invitationSenderFacade = null;

	/**
	 * Description of the property invitationSenderView.
	 */
	public InvitationSenderView invitationSenderView = null;

	// Start of user code (user defined attributes for InvitationSenderController)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationSenderController() {
		// Start of user code constructor for InvitationSenderController)
		super();
		// End of user code
	}

	/**
	 * Description of the method sendInvitation.
	 * @param users 
	 * @param workspace 
	 * @param attendance 
	 */
	public void sendInvitation(HashSet<User> users, Workspace workspace, String attendance) {
		// Start of user code for method sendInvitation
		// End of user code
	}

	// Start of user code (user defined methods for InvitationSenderController)

	// End of user code
	/**
	 * Returns invitationSenderFacade.
	 * @return invitationSenderFacade 
	 */
	public WorkspaceFacade getInvitationSenderFacade() {
		return this.invitationSenderFacade;
	}

	/**
	 * Sets a value to attribute invitationSenderFacade. 
	 * @param newInvitationSenderFacade 
	 */
	public void setInvitationSenderFacade(WorkspaceFacade newInvitationSenderFacade) {
		this.invitationSenderFacade = newInvitationSenderFacade;
	}

	/**
	 * Returns invitationSenderView.
	 * @return invitationSenderView 
	 */
	public InvitationSenderView getInvitationSenderView() {
		return this.invitationSenderView;
	}

	/**
	 * Sets a value to attribute invitationSenderView. 
	 * @param newInvitationSenderView 
	 */
	public void setInvitationSenderView(InvitationSenderView newInvitationSenderView) {
		if (this.invitationSenderView != null) {
			this.invitationSenderView.set(null);
		}
		this.invitationSenderView.set(this);
	}

}
