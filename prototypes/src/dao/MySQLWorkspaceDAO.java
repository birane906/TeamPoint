package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;

import business_logic.user.User;
import business_logic.workspace.Workspace;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLWorkspaceDAO.
 * 
 * @author Raphael Bourret, Salim Azharhoussen, Birane Ba, Nicolas Galois
 */
public class MySQLWorkspaceDAO extends WorkspaceDAO {
	// Start of user code (user defined attributes for MySQLWorkspaceDAO)

	// End of user code

	/**
	 * craete Workspace in the database.
	 * @param workspaceName name of workspace
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
		ResultSet rs;
		int workspaceId;
		
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
			assert prepStmt != null;
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
			assert stmt != null;
			stmt.execute(req);
		} catch (SQLException e) {

			try {
				DAO.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return null;
		}

		// The user has now a workspace
		try {
			DAO.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Workspace(workspaceName);
	}

	/**
	 * delete Workspace in the database.
	 * @param workspace to be deleted
	 * @return a boolean according to the success of insert
	 */
	public Boolean deleteWorkspace(Workspace workspace) {
		// TODO
		return false;
	}

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace workpsace {@link Workspace}
	 * @return a workspace {@link Workspace}
	 */
	public Workspace retrieveWorkspace(Workspace workspace) {

		if(workspace == null) {
			return null;
		}

		String name = "";
		int id = -1;

		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;

		String query = "SELECT idWorkspace, workspaceName"
				+ " FROM workspace "
				+ "WHERE idWorkspace = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT idWorkspace, workspaceName"
				+ " FROM workspace "
				+ "WHERE idWorkspace = " + workspace.getWorkspace_id();

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(true){
				assert rs != null;
				if (!rs.next()) break;
				id = rs.getInt("idWorkspace");
				name = rs.getString("workspaceName");
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		try {
			DAO.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new Workspace(name, id);
	}

	/**
	 * get User Workspaces.
	 * @param user we want the worksapces from
	 * @return a collection of workspace
	 */
	public HashSet<Workspace> getUserWorkspaces(User user) throws Exception {
		if(user == null) {
			return null;
		}

		ArrayList<Integer> resWs = new ArrayList<>();

		HashSet<Workspace> res = new HashSet<>();
		// query on user_workspace to get workspace id of user

		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;
		String query = "SELECT idUser, idWorkspace"
				+ " FROM user_workspace "
				+ "WHERE idUser = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT idWorkspace"
				+ " FROM user_workspace "
				+ "WHERE idUser = " + user.getUser_id();

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(true){
				assert rs != null;
				if (!rs.next()) break;
				resWs.add(rs.getInt("idWorkspace"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		if (resWs.size() == 0) {
			// TODO customize Exception
			throw new Exception("User has no workspace");
		}

		for (Integer resW : resWs) {
			req = "SELECT idWorkspace, workspaceName"
					+ " FROM workspace "
					+ "WHERE idWorkspace = " + resW;

			try {
				if (stmt.execute(req)) {
					rs = stmt.getResultSet();
				}
			} catch (SQLException e) {
				// TODO explain connection lost
				e.printStackTrace();
			}

			// if we have a result then move to the next line
			try {
				if (rs.next()) {
					String name = rs.getString("workspaceName");
					int id = rs.getInt("idWorkspace");

					Workspace ws = new Workspace(name, id);
					res.add(ws);
				}
			} catch (Exception e) {
				e.printStackTrace();

				try {
					DAO.getConnection().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				return null;
			}
		}

		try {
			DAO.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static void main(String[] args) {
		MySQLWorkspaceDAO mySQL = new MySQLWorkspaceDAO();

		MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

		User user = null;

		// Login test
		try {
			user = mySQLUserDAO.getUser("raph@gmail.com", "Rafael123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(user);
		
		//User workspaceOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		
		//System.out.println(mySQL.deleteCell(cell));
		
		//System.out.println(mySQL.createWorkspace("as", workspaceOwner));

		// Retrieve user workspaces
		try {

			HashSet<Workspace> res = mySQL.getUserWorkspaces(user);
			System.out.println(res);

			if(res == null){
				System.out.println("NULL");
			}else{
				System.out.println(res);
			}

			//System.out.println(mySQL.retrieveWorkspace(res.iterator().next()));


		} catch (Exception exception) {
			exception.printStackTrace();
		}



	}

}
