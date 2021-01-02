/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.util.HashSet;

import business_logic.notification.Invitation;
import business_logic.user.User;
import business_logic.workspace.Workspace;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLInvitationDAO.
 * 
 * @author Raphael
 */
public class MySQLInvitationDAO extends InvitationDAO {
	// Start of user code (user defined attributes for MySQLInvitationDAO)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public MySQLInvitationDAO() {
		// Start of user code constructor for MySQLInvitationDAO)
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
	public boolean createInvitation(Workspace workspace, User user, String attendance) {
		// Start of user code for method createInvitation
		Invitation createInvitation = null;
		return createInvitation;
		// End of user code
	}
	 
	/**
	 * delete Invitation.
	 * @param invitation to be deleted
	 * @return a boolean according to the success of delete 
	 */
	public Boolean deleteInvitation(Invitation invitation) {
		// Start of user code for method deleteInvitation
		Boolean deleteInvitation = Boolean.FALSE;
		return deleteInvitation;
		// End of user code
	}
	 
	/**
	 * retrieve All User Invitations.
	 * @param user we want the invitations
	 * @return a hashset of invitation and roles
	 */
	public HashSet<Invitation> retrieveAllUserInvitations(User user) {
		// Start of user code for method retrieveAllUserInvitations
		HashSet<Invitation> retrieveAllUserInvitations = new HashSet<Invitation>();
		return retrieveAllUserInvitations;
		// End of user code
	}
	 
	// Start of user code (user defined methods for MySQLInvitationDAO)
	
	// End of user code


}
