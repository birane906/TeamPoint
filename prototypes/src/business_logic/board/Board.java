/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.StatusLabel;
import business_logic.user.BoardOwner;
import business_logic.user.User;
import business_logic.workspace.Workspace;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Board.
 * 
 * @author 
 */
public class Board {
	/**
	 * Description of the property parentWorkspace.
	 */
	public Workspace parentWorkspace;

	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property itemCollections.
	 */
	public ArrayList<ItemCollection> itemCollections = new ArrayList<>();

	/**
	 * Description of the property columns.
	 */
	public ArrayList<Column> columns = new ArrayList<>();

	/**
	 * Description of the property permission.
	 */
	public Permission permission;

	/**
	 * Description of the property boardOwner.
	 */
	//TODO verify why class BoardOwner
	public User boardOwner;

	/**
	 * Description of the property creationDate.
	 */
	private Date creationDate = new Date();

	/**
	 * Description of the property board_id.
	 */
	private int board_id;

	public Board(int id, String name, Workspace parentWorkspace, User boardOwner) {
		this.parentWorkspace = parentWorkspace;
		this.board_id = id;
		this.boardOwner = boardOwner;
		this.name = name;
	}
	
	public Board(String name, Workspace parentWorkspace, User boardOwner) {
		this.parentWorkspace = parentWorkspace;
		this.boardOwner = boardOwner;
		this.name = name;
	}

	public Board(int idBoard, String nameBoard, User user, Permission permission, Workspace workspace, Date dateBoard) {
		this.board_id = idBoard;
		this.name = nameBoard;
		this.boardOwner = user;
		this.permission = permission;
		this.parentWorkspace = workspace;
		this.creationDate = dateBoard;
	}

	/**
	 * Description of the method addColumn.
	 * @param column 
	 */
	public void addColumn(Column column) {
		// Start of user code for method addColumn
		// End of user code
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
	}

	/**
	 * Description of the method deleteColumn.
	 * @param column 
	 */
	public void deleteColumn(Column column) {
		// Start of user code for method deleteColumn
		// End of user code
	}

	/**
	 * Description of the method addItemCollection.
	 * @param itemCollection 
	 */
	public void addItemCollection(ItemCollection itemCollection) {
		// Start of user code for method addItemCollection
		// End of user code
	}

	public void setItemCollections(ArrayList<ItemCollection> itemCollections) {
		this.itemCollections = itemCollections;
	}

	/**
	 * Description of the method deleteItemCollection.
	 * @param itemCollection 
	 */
	public void deleteItemCollection(ItemCollection itemCollection) {
		// Start of user code for method deleteItemCollection
		// End of user code
	}

	/**
	 * Description of the method addItem.
	 * @param itemCollection_id 
	 * @param item 
	 */
	public void addItem(int itemCollection_id, Item item) {
		// Start of user code for method addItem
		// End of user code
	}

	/**
	 * Description of the method deleteItem.
	 * @param itemCollection_id 
	 * @param item_id 
	 */
	public void deleteItem(int itemCollection_id, int item_id) {
		// Start of user code for method deleteItem
		// End of user code
	}

	/**
	 * Description of the method getColumnType.
	 * @param column_id 
	 * @return 
	 */
	public String getColumnType(int column_id) {
		// Start of user code for method getColumnType
		String getColumnType = "";
		return getColumnType;
		// End of user code
	}

	/**
	 * Description of the method getStatusColumnLabels.
	 * @param column_id 
	 * @return 
	 */
	public HashSet<StatusLabel> getStatusColumnLabels(int column_id) {
		// Start of user code for method getStatusColumnLabels
		HashSet<StatusLabel> getStatusColumnLabels = new HashSet<StatusLabel>();
		return getStatusColumnLabels;
		// End of user code
	}

	// Start of user code (user defined methods for Board)

	// End of user code
	/**
	 * Returns parentWorkspace.
	 * @return parentWorkspace 
	 */
	public Workspace getParentWorkspace() {
		return this.parentWorkspace;
	}

	/**
	 * Sets a value to attribute parentWorkspace. 
	 * @param newParentWorkspace 
	 */
	public void setParentWorkspace(Workspace newParentWorkspace) {
		this.parentWorkspace = newParentWorkspace;
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
	 * Returns itemCollections.
	 * @return itemCollections 
	 */
	public ArrayList<ItemCollection> getItemCollections() {
		return this.itemCollections;
	}

	/**
	 * Returns columns.
	 * @return columns 
	 */
	public ArrayList<Column> getColumns() {
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
	 * Sets a value to attribute boardOwner. 
	 * @param newBoardOwner 
	 */
	/*
	public void setBoardOwner(BoardOwner newBoardOwner) {
		if (this.boardOwner != null) {
			this.boardOwner.set(null);
		}
		this.boardOwner.set(this);
	}
	*/

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

	/**
	 * Returns board_id.
	 * @return board_id 
	 */
	public int getBoard_id() {
		return this.board_id;
	}

	/**
	 * Sets a value to attribute board_id. 
	 * @param newBoard_id 
	 */
	public void setBoard_id(int newBoard_id) {
		this.board_id = newBoard_id;
	}
}
