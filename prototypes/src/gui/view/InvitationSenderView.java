/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package gui.view;

// Start of user code (user defined imports)

// End of user code

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

	// Start of user code (user defined attributes for InvitationSenderView)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationSenderView() {
		// Start of user code constructor for InvitationSenderView)
		super();
		// End of user code
	}

	/**
	 * Description of the method start.
	 */
	public void start() {
		// Start of user code for method start
		// End of user code
	}

	// Start of user code (user defined methods for InvitationSenderView)

	// End of user code
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
