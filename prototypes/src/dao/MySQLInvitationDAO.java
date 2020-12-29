/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

invalid
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
	 * Description of the method createInvitation.
	 * @param workspace 
	 * @param user 
	 * @param attendance 
	 * @return 
	 */
	public Invitation createInvitation(Workspace workspace, User user, String attendance) {
		// Start of user code for method createInvitation
		Invitation createInvitation = null;
		return createInvitation;
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
	 
	// Start of user code (user defined methods for MySQLInvitationDAO)
	
	// End of user code


}
