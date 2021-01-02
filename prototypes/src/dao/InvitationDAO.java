/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Invitation;
import business_logic.user.User;
import business_logic.workspace.Workspace;

import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of InvitationDAO.
 * 
 * @author Raphael
 */
public abstract class InvitationDAO implements DAO {
	// Start of user code (user defined attributes for InvitationDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public InvitationDAO() {
		// Start of user code constructor for InvitationDAO)
		super();
		// End of user code
	}

	/**
	 * create Invitation to a workspace.
	 * @param workspace
	 * @param user the user we invite
	 * @param attendance the role we give to the user
	 * @return an Invitation {@link Invitation}
	 */
	public abstract boolean createInvitation(Workspace workspace, User user, String attendance);

	/**
	 * delete Invitation.
	 * @param invitation to be deleted
	 * @return a boolean according to the success of delete 
	 */
	public abstract Boolean deleteInvitation(Invitation invitation);

	/**
	 * retrieve All User Invitations.
	 * @param user we want the invitations
	 * @return a hashset of invitation and roles
	 */
	public abstract HashSet<Invitation> retrieveAllUserInvitations(User user);
	 
	// Start of user code (user defined methods for InvitationDAO)
	
	// End of user code


}
