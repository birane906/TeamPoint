/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao.mySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business_logic.board.Board;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Permission;
import business_logic.board.types.DateType;
import business_logic.board.types.DependencyType;
import business_logic.board.types.NumberType;
import business_logic.board.types.PersonType;
import business_logic.board.types.StatusType;
import business_logic.board.types.TimelineType;
import business_logic.board.types.Type;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.BoardDAO;
import dao.DAO;

/**
 * Description of MySQLBoardDAO.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLBoardDAO extends BoardDAO {

	/**
	 * The constructor.
	 */
	public MySQLBoardDAO() {
		// Start of user code constructor for MySQLBoardDAO)
		super();
		// End of user code
	}

	/**
	 * add a board to a workspace
	 * 
	 * @param name       of the board
	 * @param workspace  where the user creates the board
	 * @param user       is the board owner, must be the one who creates it
	 * @param permission
	 * @return
	 */
	@Override
	public Board addBoard(String name, Workspace workspace, User user, Permission permission) {

		if (name.isBlank() || workspace == null | user == null || permission == null) {
			return null;
		}

		if (DAO.isNameExist(name, "board")) {
			return null;
		}

		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO board"
				+ " (userOwner, idPermission, boardName, parentWorkspace) VALUES(?, ?, ?, ?)";

		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "INSERT INTO board" + " (userOwner, idPermission, boardName, parentWorkspace) VALUES("
				+ DAO.stringFormat(user.getUser_id() + "") + ", " + DAO.stringFormat(permission.getIdPermission() + "")
				+ ", " + DAO.stringFormat(name) + ", " + DAO.stringFormat(workspace.getWorkspace_id() + "") + ")";

		int boardId = -1;
		
		try {
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			
			DAO.closeConnection();
			e.printStackTrace();
			return null;
		
		}

		// Add the column id to board_contains

		try {
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			boardId = rs.getInt(1);

		} catch (SQLException throwables) {
			DAO.closeConnection();
			throwables.printStackTrace();
		}
		
		DAO.closeConnection();

		return new Board(boardId, name, workspace, user, new Date(), permission);
	}

	@Override
	public Boolean deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create the board with all his columns and items
	 * 
	 * @param board that will be retrieved
	 * @return a complete board with all of his component created (item,
	 *         itemCollection, column, permission, types, cells)
	 */
	// TODO SET PERMISSION AND TYPE
	@Override
	public Board retrieveBoard(Board board) {
		if (board == null) {
			return null;
		}
		// CREATE COLUMN, ITEMCOL, ITEM, CELL, PERMISSION, TYPE

		// SET COLUMN TO BOARD
		board.setColumns(getColumns(board));

		// SET ITEM TO ITEMCOLLECTIONS
		board.setItemCollections(getItemCollection(board));

		// SET CELLS
		for (int i = 0; i < board.getColumns().size(); i++) {
			for (Column<? extends Type> column : board.getColumns()) {
				Column<? extends Type> col = board.getColumns().get(i);
				try {
					col.setCells(getCellsFromColumn(board, column));
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < board.getItemCollections().size(); i++) {
			for (int j = 0; j < board.getItemCollections().get(i).getItems().size(); j++) {
				Item item = board.getItemCollections().get(i).getItems().get(j);
				item.setCells(getCellsFromItem(board, board.getItemCollections().get(i).getItems().get(j)));
			}
		}
		return board;
	}

	/**
	 * get all the item collection from a board
	 * @param board
	 * @return an ArrayList<ItemCollection>
	 */
	private ArrayList<ItemCollection> getItemCollection(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM itemCollection "
				+ "WHERE idBoard = " +DAO.stringFormat(board.getBoard_id() + "");

		ArrayList<ItemCollection> itemCollections = new ArrayList<>();
		int id = -1;
		String name = "NONE";

		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection();
			return null;
		}

		try {
			while(rs.next()) {
				id = rs.getInt("idItemCollection");
				name = rs.getString("itemCollectionName");

				ItemCollection newItemCol = new ItemCollection(name, id, board);

				newItemCol.setItems(getItems(newItemCol));

				itemCollections.add(newItemCol);
			}
		} catch (SQLException throwables) {
			DAO.closeConnection();
			throwables.printStackTrace();
		}
		
		DAO.closeConnection();
		
		return itemCollections;
	}

	/**
	 * get all the item from an item collection
	 * @param itemCol
	 * @return
	 */
	private ArrayList<Item> getItems(ItemCollection itemCol) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM item "
				+ "WHERE idBoard = " + DAO.stringFormat(itemCol.getParentBoard().getBoard_id() + "")
				+ " AND idItemCollection = " + DAO.stringFormat(itemCol.getItemCollection_id() + "");

		ArrayList<Item> items = new ArrayList<>();
		int id = -1;
		String name = "NONE";

		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			DAO.closeConnection();
			e.printStackTrace();
		}

		try {
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection();
			return null;
		}

		try {
			while(rs.next()) {
				id = rs.getInt("idItem");
				name = rs.getString("itemName");

				Item item = new Item(id, name, itemCol);
				items.add(item);
			}
		} catch (SQLException e) {
			DAO.closeConnection();
			e.printStackTrace();
		}
		
		DAO.closeConnection();

		return items;
	}

	/**
	 * get all the column from a board
	 * @param board
	 * @return
	 */
	private ArrayList<Column<? extends Type>> getColumns(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM `column` "
				+ "WHERE idBoard = " + DAO.stringFormat(board.getBoard_id() + "");

		ArrayList<Column<? extends Type>> col = new ArrayList<>();

		int id = -1;
		String name = "NONE";
		int idType = -1;

		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			assert stmt != null;
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection();
			return null;
		}

		try {
			while(rs.next()) {
				id = rs.getInt("idColumn");
				name = rs.getString("columnName");
				idType = rs.getInt("idColumnType");
				Type t = DAO.getTypeById(idType);
				switch (t.getNameType()) {
					case "DateType":
						col.add(new Column<DateType>(board, name, id, t));
					case "DependencyType":
						col.add(new Column<DependencyType>(board, name, id, t));
					case "NumberType":
						col.add(new Column<NumberType>(board, name, id, t));
					case "PersonType":
						col.add(new Column<PersonType>(board, name, id, t));
					case "StatusType":
						col.add(new Column<StatusType>(board, name, id, t));
					case "TimelineType":
						col.add(new Column<TimelineType>(board, name, id, t));
					default:
						return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DAO.closeConnection();
		
		return col;
	}

	/**
	 * get all the cells from a column
	 * @param board
	 * @param column
	 * @return
	 */
	private List<Cell<? extends Type>> getCellsFromColumn(Board board, Column<? extends Type> column) {

		ArrayList<Cell<? extends Type>> cells = new ArrayList<>();

		for (int i = 0; i < board.getItemCollections().size(); i++) {
			for (Item item: board.getItemCollections().get(i).getItems()) {
				cells.add(getCell(board, column, item));
			}
		}
		return cells;
	}

	/**
	 * get all the cells from an item
	 * @param board
	 * @param item
	 * @return
	 */
	private ArrayList<Cell<? extends Type>> getCellsFromItem(Board board, Item item) {

		ArrayList<Cell<? extends Type>> cells = new ArrayList<>();

		for (Column<? extends Type> column: board.getColumns()) {
			cells.add(getCell(board, column, item));
		}
		return cells;
	}

	/**
	 * get the cell from a column and an item
	 * @param board
	 * @param column
	 * @param item
	 * @return
	 */
	private Cell<? extends Type> getCell(Board board, Column<? extends Type> column, Item item) {
		// GET CELLS FROM DB

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT cellValue "
				+ "FROM cell "
				+ "WHERE idBoard = " + DAO.stringFormat(board.getBoard_id() + "")
				+ " AND idColumn = " + DAO.stringFormat(column.getColumn_id() + "")
				+ " AND idItemCollection = " + DAO.stringFormat(item.getParentItemCollection().getItemCollection_id() + "")
				+ " AND idItem = " + DAO.stringFormat(item.getItem_id() + "");

		Cell<? extends Type> cell = null;

		//Type value;

		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			assert stmt != null;
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		try {
			while(rs.next()) {
				//TODO : Fix DB And Rewrite this part
				/*value = rs.getBlob("cellValue").;
				cell = new Cell(item, column, value);*/

			}
		} catch (SQLException e) {
			DAO.closeConnection();
			e.printStackTrace();
		}
		
		DAO.closeConnection();
		
		return cell;
	}

	/**
	 * add item collection to a board
	 * @param itemCollectionName name of the item collection
	 * @param board where we want the collection to be in
	 * @return
	 */
	@Override
	public Boolean addItemCollection(String itemCollectionName, Board board) {

		if(board == null || itemCollectionName.isBlank()) {
			return false;
		}

		if(DAO.isNameExist(itemCollectionName, "itemCollection")) {
			return false;
		}

		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO itemcollection"
				+ " (idBoard, itemCollectionName) VALUES(?, ?)";
		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		String req = "INSERT INTO itemcollection"
				+ " (idBoard, itemCollectionName) VALUES("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollectionName)
				+  ")";

		try {	
			stmt.executeUpdate(req);
		
		} catch (SQLException e) {
			
			DAO.closeConnection();
			return false;
		}
		
		DAO.closeConnection();
		return true;
	}

	@Override
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * add an item to an item collection
	 * @param itemCollection the item collection we want the item to be in
	 * @param itemLabel the name of the item
	 * @return
	 */
	@Override
	public Boolean addItem(ItemCollection itemCollection, String itemLabel) {

		if(itemCollection == null || itemLabel.isBlank()) {
			return false;
		}

		if(DAO.isNameExist(itemLabel, "item")) {
			return false;
		}

		// Query statement
		PreparedStatement stmt = null;
		String query = "INSERT INTO item"
				+ " (idBoard, idItemCollection, itemName) VALUES(?, ?, ?)";

		try {
			// Get connection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {

			DAO.closeConnection();
			e.printStackTrace();
		}
		
		String req = "INSERT INTO item"
				+ " (idBoard, idItemCollection, itemName) VALUES("
				+ DAO.stringFormat(itemCollection.getParentBoard().getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollection.getItemCollection_id() + "") + ", "
				+ DAO.stringFormat(itemLabel)
				+  ")";
		
		try {
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			
			DAO.closeConnection();
			return false;
		}
		
		DAO.closeConnection();
		
		return true;
	}

	@Override
	public Boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the default permission which is edit everything
	 * @return permission with the id 0 in the database
	 */
	@Override
	public Permission getDefaultPermission() {

		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM typePermission "
				+ "WHERE idTypePermission = 0";

		int id = -1;
		String name = "NONE", descr = "NONE";

		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			DAO.closeConnection();
			e.printStackTrace();
			return null;
		}

		try {
			if(rs.next()) {
				id = rs.getInt("idTypePermission");
				name = rs.getString("labelPermission");
				descr = rs.getString("description");
			}
		} catch (SQLException throwables) {
			DAO.closeConnection();
			throwables.printStackTrace();
		}

		if(id == -1) {
			DAO.closeConnection();
			return null;
		}
		
		DAO.closeConnection();
		return new Permission(id, name, descr);
	}

	/**
	 * Create all the board for a workspace
	 * @param workspace
	 * @return
	 */
	@Override
	public ArrayList<Board> getBoardsOfWorkspace(Workspace workspace) {
		// GET BOARDS
		if(workspace == null) {
			return null;
		}
		ArrayList<Board> res = new ArrayList<>();

		int idBoard = -1;
		String nameBoard = "NONE";
		int userId = -1;
		int idType = -1;
		Date dateBoard;

		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT *"
				+ " FROM board "
				+ "WHERE parentWorkspace = " + workspace.getWorkspace_id();

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			
			DAO.closeConnection();
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(rs.next()){
				idBoard = rs.getInt("idBoard");
				nameBoard = rs.getString("boardName");
				userId = rs.getInt("userOwner");
				idType = rs.getInt("idPermission");
				dateBoard = rs.getDate("boardCreationDate");

				// GET Board Owner
				User user = null;
				try {
					user = DAO.getUserById(userId);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Board newBoard = new Board(idBoard, nameBoard, workspace, user,dateBoard, getPermissionById(idType));
				res.add(newBoard);
			}
		} catch (SQLException throwables) {
		
			DAO.closeConnection();
			throwables.printStackTrace();
		
		}
		
		DAO.closeConnection();
		return res;
	}

	/**
	 * get the permission given an id
	 * @param id
	 * @return Permission
	 */
	private Permission getPermissionById(int id) {
		if (id == -1) {
			return null;
		}
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;
		String query = "SELECT * "
				+ " FROM TypePermission "
				+ "WHERE idTypePermission = ?";

		try {
			// Get connection from JDBCConnector
			stmt = DAO.getConnection().prepareStatement(query);
			
		} catch (SQLException e) {
			
			DAO.closeConnection();
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ " FROM TypePermission "
				+ "WHERE idTypePermission = " + DAO.stringFormat(id + "");

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			
			DAO.closeConnection();
			e.printStackTrace();
		
		}

		Permission perm = null;
		try {
			if(rs.next()) {
				int idPermission = rs.getInt("idTypePermission");
				String labelPermission = rs.getString("labelPermission");
				String descr = rs.getString("description");

				perm = new Permission(idPermission, labelPermission, descr);
			}
			
		} catch (SQLException throwables) {
			DAO.closeConnection();
			throwables.printStackTrace();
		}
		
		DAO.closeConnection();
		return perm;
	}

	/*public static void main(String[] args) {
		MySQLBoardDAO mySQL = new MySQLBoardDAO();

		Workspace parentWorkspace = new Workspace("salut");
		User boardOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner);
		ItemCollection itemCol = new ItemCollection("test", 0, parentBoard);

		//Board res = mySQL.addBoard("Boarddaas", parentWorkspace, boardOwner, new Permission(0, "Perm", "desc"));
		//System.out.println(res);

		//Boolean res = mySQL.addItemCollection("testItemCol", parentBoard);
		//System.out.println(res);

		//res = mySQL.addItem(itemCol, "itemTest");
		//System.out.println(res);

		//System.out.println(mySQL.getDefaultPermission());

		//mySQL.getBoardsOfWorkspace(parentWorkspace);

		//System.out.println(mySQL.getItemCollection(parentBoard));
		System.out.println(mySQL.getBoardsOfWorkspace(parentWorkspace).get(0).getPermission());

		System.out.println(mySQL.retrieveBoard(parentBoard).getColumns().get(0).getColumnType());
	}*/
}
