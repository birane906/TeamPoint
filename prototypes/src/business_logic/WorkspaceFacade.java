/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.board.Board;
import business_logic.notification.Invitation;
import business_logic.user.AbstractUserAttendance;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.*;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * {@link WorkspaceFacade} is a Singleton class. Simplify the use of
 * business logic subsystem for the GUI layer. Facade pattern.
 * Contains the business methods.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class WorkspaceFacade {

	public Workspace currentWorkspace = null;

	private WorkspaceFacade() {}

	/**
	 * The {@link WorkspaceFacade} <code>static</code> nested class
	 * guarantees the uniqueness of {@link WorkspaceFacade} instance
	 */
	private static class WorkspaceFacadeHolder {
		/**
		 * The unique instance of {@link WorkspaceFacade}
		 */
		private static final WorkspaceFacade WORKSPACE_FACADE = new WorkspaceFacade();
	}

	/**
	 * <code>static</code> method. Gives the unique instance of {@link WorkspaceFacade}
	 * @return The {@link WorkspaceFacade}
	 */
	public static WorkspaceFacade getWorkspaceFacadeInstance() {
		return WorkspaceFacadeHolder.WORKSPACE_FACADE;
	}

	/**
	 * Asks for {@link WorkspaceDAO} to delete a {@link Workspace}
	 * @param workspace The {@link Workspace} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public boolean deleteWorkspace(Workspace workspace) {
		if (workspace == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		WorkspaceDAO workspaceDAO = daoFactory.createWorkspaceDAO();

		return workspaceDAO.deleteWorkspace(workspace);
	}

	/**
	 * Asks for {@link WorkspaceDAO} to create a {@link Workspace}
	 * @param name The new {@link Workspace}'s name. Can't be blank
	 * @return <code>true</code> if the creation succeed, <code>false</code> otherwise
	 */
	public boolean createWorkspace(String name) {
		if (name.isBlank()) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		WorkspaceDAO workspaceDAO = daoFactory.createWorkspaceDAO();

		UserFacade userFacade = UserFacade.getUserFacadeInstance();
		User user = userFacade.getCurrentUser();

		Workspace workspace = workspaceDAO.createWorkspace(name, user);

		if (workspaceDAO != null) {
			currentWorkspace = workspace;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link WorkspaceDAO} to load a {@link Workspace} in the <code>currentWorkspace</code> of the {@link WorkspaceFacade}
	 * @param workspace The {@link Workspace} to be loaded
	 * @return <code>true</code> if the load succeed, <code>false</code> otherwise
	 */
	public Boolean retrieveWorkspace(Workspace workspace) {
		if (workspace == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		WorkspaceDAO workspaceDAO = daoFactory.createWorkspaceDAO();

		workspace = workspaceDAO.retrieveWorkspace(workspace);

		if (workspace != null) {

			ArrayList<Board> boards = getBoardsOfWorkspace(workspace);

			for (Board board : boards) {
				workspace.addBoard(board);
			}

			currentWorkspace = workspace;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link WorkspaceDAO} to retrieve all {@link User} in the given {@link Workspace}
	 * @param workspace The {@link Workspace} considered
	 * @return <code>true</code> if the retrieval succeed, <code>false</code> otherwise
	 */
	public HashSet<User> getWorkspaceMembers(Workspace workspace) {
		if (workspace != null) {
			DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
			UserDAO userDAO = daoFactory.createUserDAO();

			HashSet<User> users = userDAO.getWorkspaceMembers(workspace);

			if (users != null) {
				return users;
			}
		}
		return new HashSet<User>();
	}

	/**
	 * Asks for {@link WorkspaceDAO} to load a {@link Workspace} in the <code>currentWorkspace</code> of the {@link WorkspaceFacade}
	 * @param workspace The {@link Workspace} to be loaded
	 * @return An {@link ArrayList} of the {@link Board} bellowing to the given {@link Workspace}
	 */
	public ArrayList<Board> getBoardsOfWorkspace(Workspace workspace) {
		if (workspace != null) {
			DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
			BoardDAO boardDAO = daoFactory.createBoardDAO();

			return boardDAO.getBoardsOfWorkspace(workspace);
		}
		return new ArrayList<Board>();
	}

	/**
	 * Asks for {@link WorkspaceDAO} to send an {@link Invitation} to all the given {@link User}
	 * @param users A {@link HashSet} of {@link User} to send an {@link Invitation}
	 * @param workspace The {@link Workspace} considered
	 * @param attendance The {@link AbstractUserAttendance} string description of the {@link Invitation}
	 * @return <code>true</code> if the {@link Invitation} is sent, <code>false</code> otherwise
	 */
	public boolean sendInvitation(HashSet<User> users, Workspace workspace, String attendance) {
		if (attendance.isBlank() || workspace == null || users.isEmpty()) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserFacade userFacade = UserFacade.getUserFacadeInstance();
		User user = userFacade.getCurrentUser();

		InvitationDAO invitationDAO = daoFactory.createInvitationDAO();
		return invitationDAO.createInvitation(workspace, user, attendance);
	}

	public Workspace getCurrentWorkspace() {
		return this.currentWorkspace;
	}

}
