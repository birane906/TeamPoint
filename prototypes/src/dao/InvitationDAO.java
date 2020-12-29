/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.notification.Invitation;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.DAO;

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
	 * Description of the method createInvitation.
	 * @param workspace 
	 * @param user 
	 * @param attendance 
	 * @return 
	 */
	public abstract Invitation createInvitation(Workspace workspace, User user, String attendance);

	/**
	 * Description of the method deleteInvitation.
	 * @param invitation 
	 * @return 
	 */
	public abstract Boolean deleteInvitation(Invitation invitation);

	/**
	 * Description of the method retrieveAllUserInvitations.
	 * @param user 
	 * @return 
	 */
	public abstract HashSet<Invitation> retrieveAllUserInvitations(User user);
	 
	// Start of user code (user defined methods for InvitationDAO)
	
	// End of user code


}
