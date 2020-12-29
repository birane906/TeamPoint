/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.workspace.Workspace;
import gui.controller.WorkspaceController;
import business_logic.WorkspaceFacade;
import business_logic.user.User;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of WorkspaceFacade.
 * 
 * @author 
 */
public class WorkspaceFacade {
	/**
	 * Description of the property  .
	 */
	private WorkspaceController workspaceController;

	/**
	 * Description of the property currentWorkspace.
	 */
	public Workspace currentWorkspace = null;

	// Start of user code (user defined attributes for WorkspaceFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public WorkspaceFacade() {
		// Start of user code constructor for WorkspaceFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getWorkspaceFacadeInstance.
	 * @return 
	 */
	public static WorkspaceFacade getWorkspaceFacadeInstance() {
		// Start of user code for method getWorkspaceFacadeInstance
		WorkspaceFacade getWorkspaceFacadeInstance = null;
		return getWorkspaceFacadeInstance;
		// End of user code
	}

	/**
	 * Description of the method deleteWorkspace.
	 * @param workspace 
	 */
	public void deleteWorkspace(Workspace workspace) {
		// Start of user code for method deleteWorkspace
		// End of user code
	}

	/**
	 * Description of the method createWorkspace.
	 * @param name 
	 * @return 
	 */
	public Boolean createWorkspace(String name) {
		// Start of user code for method createWorkspace
		Boolean createWorkspace = Boolean.FALSE;
		return createWorkspace;
		// End of user code
	}

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace 
	 * @return 
	 */
	public Boolean retrieveWorkspace(Workspace workspace) {
		// Start of user code for method retrieveWorkspace
		Boolean retrieveWorkspace = Boolean.FALSE;
		return retrieveWorkspace;
		// End of user code
	}

	/**
	 * Description of the method getWorkspaceMembers.
	 * @param workspace 
	 * @return 
	 */
	public HashSet<User> getWorkspaceMembers(Workspace workspace) {
		// Start of user code for method getWorkspaceMembers
		HashSet<User> getWorkspaceMembers = new HashSet<User>();
		return getWorkspaceMembers;
		// End of user code
	}

	/**
	 * Description of the method sendInvitation.
	 * @param users 
	 * @param workspace 
	 * @param attendance 
	 */
	public void sendInvitation(HashSet<User> users, Workspace workspace, String attendance) {
		// Start of user code for method sendInvitation
		// End of user code
	}

	/**
	 * Returns currentWorkspace.
	 * @return currentWorkspace 
	 */
	public Workspace getCurrentWorkspace() {
		return this.currentWorkspace;
	}

	/**
	 * Sets a value to attribute currentWorkspace. 
	 * @param newCurrentWorkspace 
	 */
	public void setCurrentWorkspace(Workspace newCurrentWorkspace) {
		if (this.currentWorkspace != null) {
			this.currentWorkspace.set(null);
		}
		this.currentWorkspace.set(this);
	}

}
