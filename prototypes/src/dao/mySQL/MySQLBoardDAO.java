package dao.mySQL;

import business_logic.board.*;
import business_logic.board.types.*;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.BoardDAO;
import dao.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description of MySQLBoardDAO.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLBoardDAO extends BoardDAO {

	/**
	 * create the board given a name and add it to a workspace
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

		// GET CELLS OF a board
		setCells(board);

		return board;
	}

	public void setCells(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM cell "
				+ "WHERE idBoard = ?";

		try {
			// Get connection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ "FROM cell "
				+ "WHERE idBoard = " +DAO.stringFormat(board.getBoard_id() + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection(0);
			return;
		}

		List<Cell> cells = new ArrayList<>();

		try {
			while(true) {
				assert rs != null;

				if (!rs.next()) break;

				int idCell = rs.getInt("idCell");
				int idColumn = rs.getInt("idColumn");
				int idItem = rs.getInt("idItem");
				int idItemCollection = rs.getInt("idItemCollection");
				int idType = rs.getInt("idType");


				Item item = null;
				for (ItemCollection itmCol: board.getItemCollections()){
					for (Item itm: itmCol.getItems()) {
						if(itm.getItem_id() == idItem) {
							item = itm;
						}
					}
				}

				Type type = getValue(idCell, idType);

				switch (type.getNameType()) {
					case "DateType":
						int x = 20;

						Column<DateType> clmDate = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmDate = (Column<DateType>) col;
							}
						}

						DateType typeDate = (DateType) type;
						Cell<? extends Type> cellDate = new Cell<>(item, clmDate, typeDate, idCell);
						cells.add(cellDate);

						break;
					case "DependencyType":
						int y = 12;
						Column<DependencyType> clmDep = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmDep = (Column<DependencyType>) col;
							}
						}

						DependencyType dependencyType = (DependencyType) type;
						Cell<? extends Type> cellDep = new Cell<>(item, clmDep, dependencyType, idCell);
						cells.add(cellDep);

						break;
					case "NumberType":
						int xX = 0;
						Column<NumberType> clmNum = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmNum = (Column<NumberType>) col;
							}
						}

						NumberType numType = (NumberType) type;
						Cell<? extends Type> cellNum = new Cell<>(item, clmNum, numType, idCell);
						cells.add(cellNum);

						break;
					case "PersonType":
						int yy = 10;
						Column<PersonType> clmPer = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmPer = (Column<PersonType>) col;
							}
						}

						PersonType personType = (PersonType) type;
						Cell<? extends Type> cellPer = new Cell<>(item, clmPer, personType, idCell);
						cells.add(cellPer);

						break;
					case "StatusLabel":
						int b = 1;
						Column<StatusType> clmStat = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmStat = (Column<StatusType>) col;
							}
						}

						StatusType statusType = (StatusType) type;
						Cell<? extends Type> cellStat = new Cell<>(item, clmStat, statusType, idCell);

						cells.add(cellStat);

						break;
					case "TimelineType":
						int sa = 11;
						Column<TimelineType> clmTime = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmTime = (Column<TimelineType>) col;
							}
						}

						TimelineType timelineType = (TimelineType) type;
						Cell<? extends Type> cellTime = new Cell<>(item, clmTime, timelineType, idCell);
						cells.add(cellTime);

						break;
					case "TextType":
						int sasasa = 12;
						Column<TextType> clmText = null;
						for (Column<? extends Type> col: board.getColumns()) {
							if(col.getColumn_id() == idColumn) {
								clmText = (Column<TextType>) col;
							}
						}

						TextType textType = (TextType) type;

						Cell<? extends Type> cellText = new Cell<>(item, clmText, textType, idCell);
						cells.add(cellText);

						break;
					default:
				}
			}

		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
		}

		for (Column<? extends Type> col: board.getColumns()) {
			for (Cell cell: cells) {
				if(cell.getColumn().getColumn_id() == col.getColumn_id()) {
					col.addCell(cell);
				}
			}
		}

		for (ItemCollection itemCollection: board.getItemCollections()) {
			for (Item item: itemCollection.getItems()) {
				for (Cell cell: cells) {
					if(cell.getItem().getItem_id() == item.getItem_id()) {
						item.addCell(cell);
					}
				}
			}
		}

		DAO.closeConnection(0);
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
				int id = rs.getInt("idItemCollection");
				String name = rs.getString("itemCollectionName");

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
				+ "WHERE idBoard = ?"
				+ " AND idItemCollection = ?";

		ArrayList<Item> items = new ArrayList<>();
		int id;
		String name;

		try {
			// Get connection
			stmt = DAO.getConnection(1).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ "FROM item "
				+ "WHERE idBoard = " + DAO.stringFormat(itemCol.getParentBoard().getBoard_id() + "")
				+ " AND idItemCollection = " + DAO.stringFormat(itemCol.getItemCollection_id() + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
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
	private ArrayList<Column> getColumns(Board board) {
		// Query statement
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM `column` "
				+ "WHERE idBoard = ?";

		ArrayList<Column> col = new ArrayList<>();

		int id;
		String name;
		int idType;

		try {
			// Get connection
			stmt = DAO.getConnection(1).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ "FROM `column` "
				+ "WHERE idBoard = " + DAO.stringFormat(board.getBoard_id() + "");

		try {
			assert stmt != null;
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			DAO.closeConnection(1);
			return null;
		}

		try {
			assert rs != null;
			while (rs.next()) {

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
						int y = 12;
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
					case "TextType":
						int sasasa = 12;
						col.add(new Column<TextType>(board, name, id, t));
					default:
				}
			}
		} catch (SQLException e) {
			DAO.closeConnection(1);
			e.printStackTrace();
		}

		DAO.closeConnection(1);
		return col;
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
				req = "SELECT idItem" +
						" FROM dependencytype" +
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

				int statusId = -1;
				try {
					assert rs != null;
					if (rs.next()) {
						statusId = rs.getInt("statuslabelid");
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

				return new StatusType(getStatusLabelById(statusId).getLabel());

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
						Item item = getItemById(itemId);

						return new DependencyType(item);
					}
				} catch (SQLException e) {
					DAO.closeConnection(3);
					e.printStackTrace();
				}

			default:
				break;
		}

		return null;
	}

	private StatusLabel getStatusLabelById(int statusId) {
		if (statusId == -1) {
			return null;
		}
		// Result from database
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;
		String query = "SELECT * "
				+ " FROM statusLabel "
				+ "WHERE idStatusLabel = ?";

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection(4).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT * "
				+ " FROM statusLabel "
				+ "WHERE idStatusLabel = " + DAO.stringFormat(statusId + "");

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
		String name = "";
		try {
			assert rs != null;
			if(rs.next()) {
				int idStatusLabel = rs.getInt("idStatusLabel");
				String colorStatus = rs.getString("colorStatus");
				name = rs.getString("label");

				return new StatusLabel(name, colorStatus);
			}
		} catch (SQLException e) {
			DAO.closeConnection(4);
			e.printStackTrace();
		}

		DAO.closeConnection(4);
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
				+ "WHERE idItem = ?";

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
		String name = "";
		try {
			assert rs != null;
			if(rs.next()) {
				int idBoard = rs.getInt("idBoard");
				int idItemCol = rs.getInt("idItemCollection");
				name = rs.getString("itemName");

				return new Item(itemId, name);
			}
		} catch (SQLException e) {
			DAO.closeConnection(4);
			e.printStackTrace();
		}

		DAO.closeConnection(4);
		return null;
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
	public Item addItem(ItemCollection itemCollection, String itemLabel) {

		if(itemCollection == null || itemLabel.isBlank()) {
			return null;
		}

		if(DAO.isNameExist(itemLabel, "item")) {
			return null;
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
			ResultSet rs = stmt.getResultSet();

			rs.next();
			int itemId = rs.getInt(1);

			DAO.closeConnection(0);

			return new Item(itemId, itemLabel, itemCollection);


		} catch (SQLException e) {
			DAO.closeConnection(0);
			return null;
		}
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

		/*
		ItemCollection itemCol = new ItemCollection("test", 1, parentBoard);
		ItemCollection itemCol2 = new ItemCollection("test", 59, parentBoard);

		Column<NumberType> colNumber = new Column<>(parentBoard, "testCol", 1, new NumberType(3, "number"));
		Column<DateType> colDate = new Column<>(parentBoard, "testCol", 2, new DateType(5, "date"));
		Column<DependencyType> colDep = new Column<>(parentBoard, "", 3, new DependencyType(6, "000"));
		Column<PersonType> colPer = new Column<>(parentBoard, "", 4, new PersonType(4, ""));
		Column<StatusType> colStat = new Column<>(parentBoard, "", 5, new StatusType(2, ""));
		Column<TimelineType> colTime = new Column<>(parentBoard, "", 6, new TimelineType(0, ""));
		try {
			Column<TextType> colText = new Column<>(parentBoard, "", 54, new TextType(1, ""));
		} catch (Exception e) {
			e.printStackTrace();
		}

		parentBoard.addItemCollection(itemCol2);
		parentBoard.addItemCollection(itemCol);
*/
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

		Board boardRetrieved = mySQL.retrieveBoard(parentBoard);

		//System.out.println("retrieve " + boardRetrieved.getItemCollections().get(1).getItems().get(0).getCells().get(0));

		//System.out.println(boardRetrieved);
	}
}
