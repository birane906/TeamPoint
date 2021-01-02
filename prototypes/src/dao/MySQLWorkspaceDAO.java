/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	 * craete Workspace in the database.
	 * @param workspaceName 
	 * @param user that created it {@link User}
	 * @return a boolean according to the success of insert
	 */
	public Workspace createWorkspace(String workspaceName, User user) {

		if(user == null) {
			return null;
		}

		if(DAO.isNameExist(workspaceName, "workspace")) {
			return null;
		}

		// Query statement
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		int workspaceId = -1;
		
		String query = "INSERT INTO workspace (idUserOwner, workspaceName) "
				+ "VALUES(?, ?)";
		
		try {
			// Getconnection
			prepStmt = DAO.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
		
		String req = "INSERT INTO workspace"
				+ " (idUserOwner, workspaceName) VALUES("
				+ DAO.stringFormat(user.getUser_id() + "") + ", " 
				+ DAO.stringFormat(workspaceName) + ")";
					
		try {
			prepStmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			
			rs = prepStmt.getGeneratedKeys();
			rs.next();

			workspaceId = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		// Fill the association between user and workspace
		
		// Query statement
		PreparedStatement stmt = null;
		
		query = "INSERT INTO user_workspace(idUser, idWorkspace, userRole) VALUES(?, ?, ?)";
		
		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}
				
		req = "INSERT INTO user_workspace"
				+ " (idUser, idWorkspace, userRole) VALUES("
				+ DAO.stringFormat(user.getUser_id() + "") + ", " 
				+ DAO.stringFormat(workspaceId + "") + ", "
				+ DAO.stringFormat(workspaceAdmin)
				+ ")";
		
		try {
			stmt.execute(req);
		} catch (SQLException e) {
			return null;
		}
			
		// The user has now a workspace
		
		return new Workspace(workspaceName);
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

	public static void main(String[] args) {
		MySQLWorkspaceDAO mySQL = new MySQLWorkspaceDAO();
		
		User workspaceOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		
		//System.out.println(mySQL.deleteCell(cell));
		
		System.out.println(mySQL.createWorkspace("sa", workspaceOwner));
	}

}
