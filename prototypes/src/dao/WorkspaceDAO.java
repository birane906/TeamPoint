package dao;

import business_logic.workspace.Workspace;
import business_logic.user.User;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of WorkspaceDAO.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public abstract class WorkspaceDAO implements DAO {

	
	final String workspaceAdmin = "WorkspaceAdmin";

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
	 * @param workspaceName of the workspace
	 * @param user that created it {@link User}
	 * @return a boolean according to the success of insert
	 */
	public abstract Workspace createWorkspace(String workspaceName, User user);

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


	public abstract HashSet<Workspace> getUserWorkspaces(User user) throws Exception;
		// Start of user code (user defined methods for WorkspaceDAO)

	// End of user code

}
