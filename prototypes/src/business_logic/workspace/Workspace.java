package business_logic.workspace;

import business_logic.board.Board;
import business_logic.user.AbstractUserAttendance;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Workspace public class representing a workspace
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Workspace {

	/**
	 * <code>int</code> used to identify the workspace must corespond ton the id store in 
	 * the database.
	 */
	private int workspace_id;

	/**
	 * The workspace name
	 */
	private String name;

	/**
	 * The workspace creation date  
	 */
	private Date creationDate;
	
	/**
	 * All users in this workspace wheter it is a WorkspaceMember or a 
	 * WorkspaceVistor
	 */
	public Set<AbstractUserAttendance> workspaceUsers;

	/**
	 * The boards inside this workspace
	 */
	public Set<Board> boards;

	/**
	 * Workspace constructor for a given name give the corresponding
	 * worspace class intance
	 * @param name the Workspace name
	 */
	public Workspace(String name){
		this.name = name;
		this.creationDate = new Date();
		this.boards = new HashSet<Board>();
		this.workspaceUsers= new HashSet<AbstractUserAttendance>();
	}

	public Workspace(String name, int workspace_id){
		this.workspace_id = workspace_id;
		this.name = name;
		this.creationDate = new Date();
		this.boards = new HashSet<Board>();
		this.workspaceUsers= new HashSet<AbstractUserAttendance>();
	}

	/**
	 * Adds the given board to the collection of boards contained 
	 * in this workspace. If this workspace already contains 
	 * the element, the call leaves the workspace unchanged and returns false.
	 * @param board is the {@link Board} object to be added to this workspace.
	 * @return <code>true</code> if the {@link Workspace} did not already contain the
	 * specified element.
	 */
	public boolean addBoard(Board board) {
		return this.boards.add(board);
	}

	/**
	 * Removes the specified board from this Workspace if it is present.
	 * @param board the board to be removed form this workspace.
	 * @return <code>true</code> if this set contained the specified element
	 */
	public boolean removeBoard(Board board) {
		return this.boards.remove(board);
	}

	/**
	 * Getter for the workspace's boards
	 * @return a {@link Set} of {@link Board}
	 */
	public Set<Board> getBoards() {
		return this.boards;
	}

	/**
	 * Adds the specified {@link AbstractUserAttendance} from the workspace
	 * @param userAttendance is the {@link AbstractUserAttendance} object to
	 * be added from the workspace.
	 * @return <code>true</code> if the {@link Workspace} did not already contain the
	 * specified element.
	 */
	public boolean addUser(AbstractUserAttendance userAttendance) {
		return this.workspaceUsers.add(userAttendance);
	}

	/**
	 * Removes the specified board from this Workspace if it is present.
	 * @param userAttendance the {@link AbstractUserAttendance} to be 
	 * removed form this workspace.
	 * @return <code>true</code> if this set contained the specified element
	 */
	public boolean removeUser(AbstractUserAttendance userAttendance) {
		return this.workspaceUsers.remove(userAttendance);
	}

	/**
	 * Getter for the workspace's users
	 * @return a {@link Set} of {@link AbstractUserAttendance}
	 */
	public Set<AbstractUserAttendance> getWorkspaceUsers() {
		return this.workspaceUsers;
	}

	/**
	 * Getter for workspace id
	 * @return an <code>int</code>
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
	 * Getter for the workspace name
	 * @return a {@link String}
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name. 
	 * @param newName is the {@link String} that will replace the 
	 * previous workspace name.
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Getter for the creation date of the workspace
	 * @return the {@link Date}
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets a value to attribute creationDate. 
	 * @param newCreationDate is the {@link Date} to be as new creation date
	 */
	public void setCreationDate(Date newCreationDate) {
		this.creationDate = newCreationDate;
	}
}
