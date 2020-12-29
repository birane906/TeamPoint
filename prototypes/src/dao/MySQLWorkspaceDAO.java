/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.util.HashSet;

import business_logic.user.User;
import business_logic.workspace.Workspace;
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
	 * craete Workspace in the database.
	 * @param workspaceName 
	 * @param user that created it {@link User}
	 * @return a boolean according to the success of insert
	 */
	public Boolean createWorkspace(String workspaceName, User user) {
		// Start of user code for method addWorkspace
		Boolean addWorkspace = Boolean.FALSE;
		return addWorkspace;
		// End of user code
	}

	/**
	 * delete Workspace in the database.
	 * @param workspace to be deleted
	 * @return a boolean according to the success of insert
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
	 * @return a workspace {@link Workspace}
	 */
	public Workspace retrieveWorkspace(Workspace workspace) {
		// Start of user code for method retrieveWorkspace
		Workspace retrieveWorkspace = null;
		return retrieveWorkspace;
		// End of user code
	}

	/**
	 * get User Workspaces.
	 * @param user we want the worksapces from
	 * @return a collection of workspace
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
