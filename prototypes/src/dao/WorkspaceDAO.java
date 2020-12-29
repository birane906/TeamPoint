/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.workspace.Workspace;
import business_logic.user.User;
import dao.DAO;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of WorkspaceDAO.
 * 
 * @author 
 */
public abstract class WorkspaceDAO implements DAO {
	// Start of user code (user defined attributes for WorkspaceDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public WorkspaceDAO() {
		// Start of user code constructor for WorkspaceDAO)
		super();
		// End of user code
	}

	/**
	 * create Workspace in the database and add it to the user workspaces.
	 * @param workspaceName 
	 * @param user that created it {@link User}
	 * @return a boolean according to the success of insert
	 */
	public abstract Boolean createWorkspace(String workspaceName, User user);

	/**
	 * delete Workspace in the database.
	 * @param workspace to be deleted {@link Workspace}
	 * @return a boolean according to the success of insert
	 */
	public abstract Boolean deleteWorkspace(Workspace workspace);

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace {@link Workspace}
	 * @return a workspace {@link Workspace}
	 */
	public abstract Workspace retrieveWorkspace(Workspace workspace);

	/**
	 * get User Workspaces.
	 * @param user we want the worksapces from {@link User}
	 * @return a collection of workspace {@link Workspace}
	 */
	public abstract HashSet<Workspace> getUserWorkspaces(User user);

	// Start of user code (user defined methods for WorkspaceDAO)

	// End of user code

}
