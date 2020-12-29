/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import java.util.HashSet;

import business_logic.InvitationFacade;
import business_logic.notification.Invitation;
import gui.controller.InvitationController;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of InvitationFacade.
 * 
 * @author Raphael
 */
public class InvitationFacade {
	/**
	 * Description of the property invitationControllers.
	 */
	public HashSet<InvitationController> invitationControllers = new HashSet<InvitationController>();

	// Start of user code (user defined attributes for InvitationFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationFacade() {
		// Start of user code constructor for InvitationFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getInvitationFacadeInstance.
	 * @return 
	 */
	public static InvitationFacade getInvitationFacadeInstance() {
		// Start of user code for method getInvitationFacadeInstance
		InvitationFacade getInvitationFacadeInstance = null;
		return getInvitationFacadeInstance;
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

	// Start of user code (user defined methods for InvitationFacade)

	// End of user code
	/**
	 * Returns invitationControllers.
	 * @return invitationControllers 
	 */
	public HashSet<InvitationController> getInvitationControllers() {
		return this.invitationControllers;
	}

}
