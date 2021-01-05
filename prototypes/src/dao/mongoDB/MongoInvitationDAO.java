/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao.mongoDB;

import java.util.HashSet;

import business_logic.notification.Invitation;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.InvitationDAO;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoInvitationDAO.
 * 
 * @author Raphael
 */
public class MongoInvitationDAO extends InvitationDAO {
	// Start of user code (user defined attributes for MongoInvitationDAO)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public MongoInvitationDAO() {
		// Start of user code constructor for MongoInvitationDAO)
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
	public boolean createInvitation(Workspace workspace, User user, String attendance) {
		// Start of user code for method createInvitation
		Invitation createInvitation = null;
		return false;
		// End of user code
	}
	 
	/**
	 * Description of the method deleteInvitation.
	 * @param invitation 
	 * @return 
	 */
	public Boolean deleteInvitation(Invitation invitation) {
		// Start of user code for method deleteInvitation
		Boolean deleteInvitation = Boolean.FALSE;
		return deleteInvitation;
		// End of user code
	}
	 
	/**
	 * Description of the method retrieveAllUserInvitations.
	 * @param user 
	 * @return 
	 */
	public HashSet<Invitation> retrieveAllUserInvitations(User user) {
		// Start of user code for method retrieveAllUserInvitations
		HashSet<Invitation> retrieveAllUserInvitations = new HashSet<Invitation>();
		return retrieveAllUserInvitations;
		// End of user code
	}
	 
	// Start of user code (user defined methods for MongoInvitationDAO)
	
	// End of user code


}
