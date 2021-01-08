/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;


import business_logic.board.types.Type;
import business_logic.user.User;
import business_logic.workspace.Workspace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description of Board.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Board {

	/**
	 * The board_id.
	 */
	private int board_id;

	/**
	 * The {@link Board} name
	 */
	private String name;

	/**
	 * The parent {@link Workspace}
	 */
	private Workspace parentWorkspace;

	/**
	 * The Board {@link ItemCollection}
	 */
	private List<ItemCollection> itemCollections;

	/**
	 * The Board {@link Column}
	 */
	private List<Column> columns;

	/**
	 * The Board {@link Permission}
	 */
	private Permission permission;

	/**
	 * A {@link User} as a board owner
	 */
	private User boardOwner;

	/**
	 * A {@link Date}
	 */
	private Date creationDate;

	/**
	 * Constructor for Board without colums and itemCollection
	 * @param boardId
	 * @param boardName
	 * @param parentWorkspace
	 * @param boardOwner
	 * @param creationDate
	 * @param permission
	 */
	public Board(int boardId, String boardName, Workspace parentWorkspace,
		User boardOwner, Date creationDate, Permission permission) {
		this.board_id = boardId;
		this.name = boardName;
		this.parentWorkspace = parentWorkspace;
		this.boardOwner = boardOwner;
		this.creationDate = creationDate;
		this.permission = permission;
		this.columns = new ArrayList<>();
		this.itemCollections = new ArrayList<>();
	}

	/**
	 * Constructor for Board without columns
	 * and with item collection
	 * @param boardId
	 * @param boardName
	 * @param parentWorkspace
	 * @param boardOwner
	 * @param creationDate
	 * @param permission
	 * @param itemCollections
	 */
	public Board(int boardId, String boardName, Workspace parentWorkspace, 
		User boardOwner, Date creationDate, Permission permission,
		List<ItemCollection> itemCollections) {
			this.board_id = boardId;
			this.name = boardName;
			this.parentWorkspace = parentWorkspace;
			this.boardOwner = boardOwner;
			this.creationDate = creationDate;
			this.permission = permission;
			this.columns = new ArrayList<>();
			this.itemCollections = itemCollections;
	}

	/**
	 * Constructor for Board without item collections
	 * and with columns
	 * @param boardName
	 * @param boardId
	 * @param parentWorkspace
	 * @param boardOwner
	 * @param creationDate
	 * @param permission
	 * @param columns
	 */
	public Board(String boardName,int boardId, Workspace parentWorkspace, 
		User boardOwner, Date creationDate, Permission permission,
		List<Column> columns) {
			this.board_id = boardId;
			this.name = boardName;
			this.parentWorkspace = parentWorkspace;
			this.boardOwner = boardOwner;
			this.creationDate = creationDate;
			this.permission = permission;
			this.columns = columns;
			this.itemCollections = new ArrayList<>();
	}

	/**
	 * Constructor for Board with columns and item collections
	 * @param boardId
	 * @param boardName
	 * @param parentWorkspace
	 * @param boardOwner
	 * @param creationDate
	 * @param permission
	 * @param columns
	 * @param itemCollections
	 */
	public Board(int boardId, String boardName, Workspace parentWorkspace, 
		User boardOwner, Date creationDate, Permission permission,
		List<Column> columns, List<ItemCollection> itemCollections) {
			this.board_id = boardId;
			this.name = boardName;
			this.parentWorkspace = parentWorkspace;
			this.boardOwner = boardOwner;
			this.creationDate = creationDate;
			this.permission = permission;
			this.columns = columns;
			this.itemCollections = itemCollections;
	}

	/**
	 * Add a {@link Column} to the board's list of columns 
	 * @param column Column of a subtype of {@link Type} 
	 */
	public<X extends Type> void addColumn(Column<X> column) {
		columns.add(column);
	}

	/**
	 * Set the board list of {@link Column}
	 * @param columns
	 */
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	/**
	 * Delete a column from the board columns
	 * @param column the column to remove
	 */
	public void deleteColumn(Column<? extends Type> column) {
		this.columns.remove(column);
	}

	/**
	 * Description of the method addItemCollection.
	 * @param itemCollection 
	 */
	public void addItemCollection(ItemCollection itemCollection) {
		this.itemCollections.add(itemCollection);
	}

	public void setItemCollections(ArrayList<ItemCollection> itemCollections) {
		this.itemCollections = itemCollections;
	}

	/**
	 * Description of the method deleteItemCollection.
	 * @param itemCollection 
	 */
	public void deleteItemCollection(ItemCollection itemCollection) {
		itemCollections.remove(itemCollection);
	}

	/**
	 * Returns parentWorkspace.
	 * @return parentWorkspace 
	 */
	public Workspace getParentWorkspace() {
		return this.parentWorkspace;
	}

	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns itemCollections.
	 * @return itemCollections 
	 */
	public List<ItemCollection> getItemCollections() {
		return this.itemCollections;
	}

	/**
	 * Returns columns.
	 * @return columns 
	 */
	public List<Column> getColumns() {
		return this.columns;
	}

	/**
	 * Returns permission.
	 * @return permission 
	 */
	public Permission getPermission() {
		return this.permission;
	}

	/**
	 * Sets a value to attribute permission. 
	 * @param newPermission 
	 */
	public void setPermission(Permission newPermission) {
		this.permission = newPermission;
	}

	/**
	 * Returns boardOwner.
	 * @return boardOwner 
	 */
	public User getBoardOwner() {
		return this.boardOwner;
	}

	/**
	 * Returns creationDate.
	 * @return creationDate 
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Returns board_id.
	 * @return board_id 
	 */
	public int getBoard_id() {
		return this.board_id;
	}

	public String toString() {
		String str = "";

		for (Column col: columns) {
			str += col.toString();
		}
		return str;
	}

}
