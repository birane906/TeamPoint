package business_logic.workspace;


import business_logic.board.Board;
import business_logic.user.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Description of Workspace.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Workspace {

	/**
	 * Description of the property workspace_id.
	 */
	private int workspace_id;

	/**
	 * Description of the property name.
	 */
	private String name;

	/**
	 * Description of the property creationDate.
	 */
	private Date creationDate;
	
	/**
	 * Description of the property workspaceUsers.
	 */
	public Set<AbstractUserAttendance> workspaceUsers;

	/**
	 * Description of the property boards.
	 */
	public Set<Board> boards;

	/**
	 * 
	 * @param name
	 */
	public Workspace(String name){
		this.name = name;
		this.creationDate = new Date();
		this.boards = new HashSet<Board>();
		this.workspaceUsers= new HashSet<AbstractUserAttendance>();
	}

	/**
	 * Description of the method addBoard.
	 * @param board 
	 */
	public void addBoard(Board board) {
		//TODO
	}

	/**
	 * Description of the method deleteBoard.
	 * @param board 
	 */
	public void deleteBoard(Board board) {
		//TODO
	}

	/**
	 * Description of the method deleteWorkspace.
	 */
	public void deleteWorkspace() {
		//TODO
	}

	/**
	 * Description of the method removeUser.
	 * @param user 
	 */
	public void removeUser(User user) {
		//TODO
	}

	/**
	 * Description of the method getWorkspaceUsers.
	 * @return 
	 */
	public Set<AbstractUserAttendance> getWorkspaceUsers() {
		
		return this.workspaceUsers;
	}

	/**
	 * Returns boards.
	 * @return boards 
	 */
	public Set<Board> getBoards() {
		return this.boards;
	}

	/**
	 * Returns workspace_id.
	 * @return workspace_id 
	 */
	public int getWorkspace_id() {
		return this.workspace_id;
	}

	/**
	 * Sets a value to attribute workspace_id. 
	 * @param newWorkspace_id 
	 */
	public void setWorkspace_id(int newWorkspace_id) {
		this.workspace_id = newWorkspace_id;
	}

	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name. 
	 * @param newName 
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns creationDate.
	 * @return creationDate 
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets a value to attribute creationDate. 
	 * @param newCreationDate 
	 */
	public void setCreationDate(Date newCreationDate) {
		this.creationDate = newCreationDate;
	}

}
