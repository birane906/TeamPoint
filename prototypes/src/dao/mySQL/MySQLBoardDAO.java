package dao.mySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import business_logic.UserFacade;
import business_logic.board.Board;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Permission;
import business_logic.board.types.*;
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
	 * add a board to a workspace
	 * 
	 * @param name       of the board
	 * @param workspace  where the user creates the board
	 * @param user       is the board owner, must be the one who creates it
	 * @param permission of the board
	 * @return the board created
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
			stmt = DAO.getConnection(0).prepareStatement(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "INSERT INTO board" + " (userOwner, idPermission, boardName, parentWorkspace) VALUES("
				+ DAO.stringFormat(user.getUser_id() + "") + ", " + DAO.stringFormat(permission.getIdPermission() + "")
				+ ", " + DAO.stringFormat(name) + ", " + DAO.stringFormat(workspace.getWorkspace_id() + "") + ")";

		int boardId = -1;
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			
			DAO.closeConnection(0);
			e.printStackTrace();
			return null;
		
		}

		// Add the column id to board_contains

		try {
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			boardId = rs.getInt(1);

		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
		}
		
		DAO.closeConnection(0);
		Board board = new Board(boardId, name, workspace, user, new Date(), permission);
		return retrieveBoard(board);
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
	 * @param board to add the item collection
	 * @return an ArrayList<ItemCollection>
	 */
	private ArrayList<ItemCollection> getItemCollection(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM itemCollection "
				+ "WHERE idBoard = ?";

		ArrayList<ItemCollection> itemCollections = new ArrayList<>();
		int id = -1;
		String name = "NONE";

		try {
			// Get connection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ "FROM itemCollection "
				+ "WHERE idBoard = " +DAO.stringFormat(board.getBoard_id() + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection(0);
			return null;
		}

		try {
			while(true) {
				assert rs != null;

				if (!rs.next()) break;
				id = rs.getInt("idItemCollection");
				name = rs.getString("itemCollectionName");

				ItemCollection newItemCol = new ItemCollection(name, id, board);

				newItemCol.setItems(getItems(newItemCol));
				itemCollections.add(newItemCol);
			}
		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
		}
		
		DAO.closeConnection(0);
		return itemCollections;
	}

	/**
	 * get all the item from an item collection
	 * @param itemCol item collection we want the items
	 * @return an ArrayList of all the items
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
		int id;
		String name;

		try {
			// Get connection
			stmt = DAO.getConnection(1).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			assert stmt != null;
			if (stmt.execute(query)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			DAO.closeConnection(1);
			e.printStackTrace();
			return null;
		}

		try {
			while(true) {
				assert rs != null;
				if (!rs.next()) break;
				id = rs.getInt("idItem");
				name = rs.getString("itemName");

				Item item = new Item(id, name, itemCol);
				items.add(item);
			}
		} catch (SQLException e) {
			DAO.closeConnection(1);
			e.printStackTrace();
		}
		
		DAO.closeConnection(1);
		return items;
	}

	/**
	 * get all the column from a board
	 * @param board we want the columns
	 * @return an ArrayList of columns
	 */
	private ArrayList<Column<? extends Type>> getColumns(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM `column` "
				+ "WHERE idBoard = " + DAO.stringFormat(board.getBoard_id() + "");

		ArrayList<Column<? extends Type>> col = new ArrayList<>();

		int id;
		String name;
		int idType;

		try {
			// Get connection
			stmt = DAO.getConnection(1).prepareStatement(query);
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
			DAO.closeConnection(1);
			return null;
		}

		try {
			assert rs != null;
			if (rs.next()) {

				id = rs.getInt("idColumn");
				name = rs.getString("columnName");
				idType = rs.getInt("idColumnType");
				Type t = DAO.getTypeById(idType);

				switch (t.getNameType()) {
					case "DateType":
						int x = 20;
						col.add(new Column<DateType>(board, name, id, t));
						break;
					case "DependencyType":
						int y =12;
						col.add(new Column<DependencyType>(board, name, id, t));
						break;
					case "NumberType":
						int xX = 0;
						col.add(new Column<NumberType>(board, name, id, t));
						break;
					case "PersonType":
						int yy = 10;
						col.add(new Column<PersonType>(board, name, id, t));
						break;
					case "StatusType":
						int b = 1;
						col.add(new Column<StatusType>(board, name, id, t));
						break;
					case "TimelineType":
						int sa = 11;
						col.add(new Column<TimelineType>(board, name, id, t));
						break;
					default:
						return null;
				}
			}
		} catch (SQLException e) {
			DAO.closeConnection(1);
			e.printStackTrace();
		}

		DAO.closeConnection(1);
		return col;
	}

	/**
	 * get all the cells from a column
	 * @param board we want the column from
	 * @param column we want the columns from
	 * @return a List of cells
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
	 * @param board we want the items from
	 * @param item we want the items from
	 * @return a List of cells
	 */
	private List<Cell<? extends Type>> getCellsFromItem(Board board, Item item) {

		ArrayList<Cell<? extends Type>> cells = new ArrayList<>();

		for (Column<? extends Type> column: board.getColumns()) {
			cells.add(getCell(board, column, item));
		}
		return cells;
	}

	/**
	 * get the cell from a column and an item
	 * @param board we want the cell from
	 * @param column we want the cell from
	 * @param item we want the cell from
	 * @return a cell
	 */
	private <T extends Type> Cell<T> getCell(Board board, Column<T> column, Item item) {
		// GET CELLS FROM DB

		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT idCell "
				+ "FROM cell "
				+ "WHERE idBoard = ?"
				+ " AND idColumn = ?"
				+ " AND idItemCollection = ?"
				+ " AND idItem = ?";

		try {
			// Get connection
			stmt = DAO.getConnection(2).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT idCell, idType "
				+ "FROM cell "
				+ "WHERE idBoard = " + DAO.stringFormat(board.getBoard_id() + "")
				+ " AND idColumn = " + DAO.stringFormat(column.getColumn_id() + "")
				+ " AND idItemCollection = " + DAO.stringFormat(item.getParentItemCollection().getItemCollection_id() + "")
				+ " AND idItem = " + DAO.stringFormat(item.getItem_id() + "");

		int cellId = -1;
		int typeId = -1;

		try {
			assert stmt != null;

			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection(2);
			return null;
		}

		Type type = null;
		try {
			while(true) {
				assert rs != null;
				if (!rs.next()) break;
				cellId = rs.getInt("idCell");
				typeId = rs.getInt("idType");

				type = getValue(cellId, typeId);
			}
		} catch (SQLException e) {

			DAO.closeConnection(2);
			e.printStackTrace();
		}
		DAO.closeConnection(2);

		return (Cell<T>) new Cell(item, column, type);
	}

	private Type getValue(int cellId, int typeId) {
		Statement stmt = null;
		ResultSet rs = null;

		String req = "", query = "";

		switch (typeId) {
			case 0: // TimelineType

				query = "SELECT startDate, endDate" +
						" FROM timelinetype" +
						" WHERE idCell = ?";
				req = "SELECT startDate, endDate " +
						"FROM timelinetype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 1: // TextType
				query = "SELECT text " +
						"FROM texttype" +
						" WHERE idCell = ?";
				req = "SELECT text" +
						" FROM texttype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 2: //Status Type
				query = "SELECT statuslabelid" +
						" FROM statustype" +
						" WHERE idCell = ?";
				req = "SELECT statuslabelid " +
						"FROM statustype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 3: // numberType
				query = "SELECT unit, number " +
						"FROM numbertype" +
						" WHERE idCell = ?";
				req = "SELECT unit, number " +
						"FROM numbertype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 4: //personType

				query = "SELECT idUser " +
						"FROM persontype" +
						" WHERE idCell = ?";
				req = "SELECT idUser" +
						" FROM persontype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 5: // dateType

				query = "SELECT date" +
						" FROM datetype" +
						" WHERE idCell = ?";
				req = "SELECT date" +
						" FROM datetype" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			case 6: //dependency type

				query = "SELECT idItem" +
						" FROM dependencytype" +
						" WHERE idCell = ?";
				req = "SELECT text" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				break;
			default:
				break;
		}

		try {
			// Get connection
			stmt = DAO.getConnection(3).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection(3);
			return null;
		}

		switch (typeId) {
			case 0: // TimelineType
				Date startDate = new Date(), endDate = new Date();

				try {
					assert rs != null;
					if (rs.next()) {
						startDate = rs.getDate("startDate");
						endDate = rs.getDate("endDate");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				return new TimelineType(startDate, endDate);

			case 1: // TextType

				String text = "";

				try {
					assert rs != null;
					if (rs.next()) {
						text = rs.getString("text");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}
				try {
					return new TextType(text);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 2: //Status Type
				String label = "";

				try {
					assert rs != null;
					if (rs.next()) {
						label = rs.getString("statuslabelid");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				return new StatusType(label);

			case 3: // numberType
				String unit = "";
				int number = -1;

				try {
					assert rs != null;
					if (rs.next()) {
						unit = rs.getString("unit");
						number = rs.getInt("number");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				return new NumberType(unit, number);

			case 4: //personType

				int userId = -1;

				try {
					assert rs != null;
					if (rs.next()) {
						userId = rs.getInt("idUser");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				User user = null;
				try {
					user = DAO.getUserById(userId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new PersonType(user);

			case 5: // dateType

				query = "SELECT date" +
						" WHERE idCell = ?";
				req = "SELECT text" +
						" WHERE idCell = " + DAO.stringFormat(cellId + "");

				Date date = new Date();
				try {
					assert rs != null;
					if (rs.next()) {
						date = rs.getDate("date");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				return new DateType(date);

			case 6: //dependency type

				int itemId = -1;
				try {
					assert rs != null;
					if (rs.next()) {
						itemId = rs.getInt("idItem");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				//Item item = new Item(itemId, "label", );
				Item item = null;

				return new DependencyType(item);

			default:
				break;
		}

		return null;
	}

	public Item getItemById(int itemId) {
		if (itemId == -1) {
			return null;
		}
		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;
		String query = "SELECT * "
				+ " FROM Item "
				+ "WHERE idType = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection(4).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ " FROM Item "
				+ "WHERE idItem = " + DAO.stringFormat(itemId + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			DAO.closeConnection(4);
			e.printStackTrace();
		}

		Type type = null;
		try {
			assert rs != null;
			if(rs.next()) {
				int idBoard = rs.getInt("idType");
				int idItemCol = rs.getInt("idBoard");
				String name = rs.getString("itemName");

				// TODO faire requete pour avoir board
			}
		} catch (SQLException e) {
			DAO.closeConnection(4);
			e.printStackTrace();
		}
		Item item = null;

		DAO.closeConnection(4);
		return item;
	}

	/**
	 * add item collection to a board
	 * @param itemCollectionName name of the item collection
	 * @param board where we want the collection to be in
	 * @return a boolean according to the success of insert
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
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		String req = "INSERT INTO itemcollection"
				+ " (idBoard, itemCollectionName) VALUES("
				+ DAO.stringFormat(board.getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollectionName)
				+  ")";

		try {
			assert stmt != null;
			stmt.executeUpdate(req);
		
		} catch (SQLException e) {
			
			DAO.closeConnection(0);
			return false;
		}
		
		DAO.closeConnection(0);
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
	 * @return a boolean according to the success of insert
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
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String req = "INSERT INTO item"
				+ " (idBoard, idItemCollection, itemName) VALUES("
				+ DAO.stringFormat(itemCollection.getParentBoard().getBoard_id() + "") + ", " 
				+ DAO.stringFormat(itemCollection.getItemCollection_id() + "") + ", "
				+ DAO.stringFormat(itemLabel)
				+  ")";
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			DAO.closeConnection(0);
			return false;
		}
		
		DAO.closeConnection(0);
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
	// TODO verify if double connection ou simple
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
			// Get connection
			stmt = DAO.getConnection(0).prepareStatement(query);
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
			DAO.closeConnection(0);
			return null;
		}

		try {
			assert rs != null;
			if(rs.next()) {
				id = rs.getInt("idTypePermission");
				name = rs.getString("labelPermission");
				descr = rs.getString("description");
			}
		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
		}

		if(id == -1) {
			DAO.closeConnection(0);
			return null;
		}
		
		DAO.closeConnection(0);
		return new Permission(id, name, descr);
	}

	/**
	 * Create all the board for a workspace
	 * @param workspace we want the boards from
	 * @return an ArrayList of boards
	 */
	@Override
	public ArrayList<Board> getBoardsOfWorkspace(Workspace workspace) {
		// GET BOARDS
		if(workspace == null) {
			return null;
		}
		ArrayList<Board> res = new ArrayList<>();

		int idBoard;
		String nameBoard;
		int userId;
		int idType;
		Date dateBoard;

		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Get connection from JDBCConnector
			stmt = DAO.getConnection(0).createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT *"
				+ " FROM board "
				+ "WHERE parentWorkspace = " + workspace.getWorkspace_id();

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {

			while(true) {

				assert rs != null;

				if (!rs.next()) break;
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


				Board newBoard = new Board(idBoard, nameBoard, workspace, user, dateBoard, getPermissionById(idType));
				res.add(newBoard);
			}
		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
			return null;
		}
		
		DAO.closeConnection(0);
		return res;
	}

	/**
	 * get the permission given an id
	 * @param id of the type in the database
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
			stmt = DAO.getConnection(1).prepareStatement(query);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String req = "SELECT * "
				+ " FROM TypePermission "
				+ "WHERE idTypePermission = " + DAO.stringFormat(id + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			
			DAO.closeConnection(1);
			e.printStackTrace();
		}

		Permission perm = null;
		try {
			assert rs != null;
			if(rs.next()) {
				int idPermission = rs.getInt("idTypePermission");
				String labelPermission = rs.getString("labelPermission");
				String descr = rs.getString("description");

				perm = new Permission(idPermission, labelPermission, descr);
			}
			
		} catch (SQLException e) {
			DAO.closeConnection(1);
			e.printStackTrace();
		}
		
		DAO.closeConnection(1);
		return perm;
	}

	public static void main(String[] args) {
		MySQLBoardDAO mySQL = new MySQLBoardDAO();

		Workspace parentWorkspace = new Workspace("salut");
		User boardOwner = new User(1, "name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(75, "test", parentWorkspace, boardOwner, new Date(), new Permission(0, "", ""));
		ItemCollection itemCol = new ItemCollection("test", 1, parentBoard);
		ItemCollection itemCol2 = new ItemCollection("test", 59, parentBoard);

		parentBoard.addItemCollection(itemCol2);
		parentBoard.addItemCollection(itemCol);

		//Board res = mySQL.addBoard("Boarddaas", parentWorkspace, boardOwner, new Permission(0, "Perm", "desc"));
		//	System.out.println("addboard " + res);

		//Boolean resItemCol = mySQL.addItemCollection("testItemCol", parentBoard);
		//System.out.println("add item col " + resItemCol);

		//Boolean resItem = mySQL.addItem(itemCol, "itemTest");
		//System.out.println("additem " + resItem);

		//System.out.println("perm " + mySQL.getDefaultPermission());

		//mySQL.getBoardsOfWorkspace(parentWorkspace);

		//System.out.println("itemcol " + mySQL.getItemCollection(parentBoard));
		//System.out.println("item " + mySQL.getBoardsOfWorkspace(parentWorkspace));

		System.out.println("retrieve " + mySQL.retrieveBoard(parentBoard).getColumns().get(0));
	}
}
