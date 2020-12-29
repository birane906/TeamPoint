/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.Workspace.Workspace;
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
	 * Description of the method addWorkspace.
	 * @param workspaceName 
	 * @param user 
	 * @return 
	 */
	public abstract Boolean addWorkspace(String workspaceName, User user);

	/**
	 * Description of the method deleteWorkspace.
	 * @param workspace 
	 * @return 
	 */
	public abstract Boolean deleteWorkspace(Workspace workspace);

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace 
	 * @return 
	 */
	public abstract Workspace retrieveWorkspace(Workspace workspace);

	/**
	 * Description of the method getUserWorkspaces.
	 * @param user 
	 * @return 
	 */
	public abstract HashSet<Workspace> getUserWorkspaces(User user);

	/**
	 * Description of the method dateFormat.
	 * @param date 
	 * @return 
	 */
	public String dateFormat(Date date) {
		// Start of user code for method dateFormat
		String dateFormat = "";
		return dateFormat;
		// End of user code
	}

	/**
	 * Description of the method stringFormat.
	 * @param string 
	 * @return 
	 */
	public String stringFormat(String string) {
		// Start of user code for method stringFormat
		String stringFormat = "";
		return stringFormat;
		// End of user code
	}

	// Start of user code (user defined methods for WorkspaceDAO)

	// End of user code

}
