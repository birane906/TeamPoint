/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import dao.WorkspaceDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLWorkspaceDAO.
 * 
 * @author 
 */
public class MySQLWorkspaceDAO extends WorkspaceDAO {
	// Start of user code (user defined attributes for MySQLWorkspaceDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MySQLWorkspaceDAO() {
		// Start of user code constructor for MySQLWorkspaceDAO)
		super();
		// End of user code
	}

	/**
	 * Description of the method addWorkspace.
	 * @param workspaceName 
	 * @param user 
	 * @return 
	 */
	public Boolean addWorkspace(String workspaceName, User user) {
		// Start of user code for method addWorkspace
		Boolean addWorkspace = Boolean.FALSE;
		return addWorkspace;
		// End of user code
	}

	/**
	 * Description of the method deleteWorkspace.
	 * @param workspace 
	 * @return 
	 */
	public Boolean deleteWorkspace(Workspace workspace) {
		// Start of user code for method deleteWorkspace
		Boolean deleteWorkspace = Boolean.FALSE;
		return deleteWorkspace;
		// End of user code
	}

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace 
	 * @return 
	 */
	public Workspace retrieveWorkspace(Workspace workspace) {
		// Start of user code for method retrieveWorkspace
		Workspace retrieveWorkspace = null;
		return retrieveWorkspace;
		// End of user code
	}

	/**
	 * Description of the method getUserWorkspaces.
	 * @param user 
	 * @return 
	 */
	public HashSet<Workspace> getUserWorkspaces(User user) {
		// Start of user code for method getUserWorkspaces
		HashSet<Workspace> getUserWorkspaces = new HashSet<Workspace>();
		return getUserWorkspaces;
		// End of user code
	}

	// Start of user code (user defined methods for MySQLWorkspaceDAO)

	// End of user code

}
