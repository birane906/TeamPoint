package dao.mySQL;

import java.sql.*;
import java.sql.Date;

import business_logic.board.*;
import business_logic.board.types.*;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.CellDAO;
import dao.DAO;

/**
 * Description of MySQLCellDAO.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLCellDAO extends CellDAO {

	private java.util.Date utilDate;

	/**
	 * The constructor.
	 */
	public MySQLCellDAO() {
		// Start of user code constructor for MySQLCellDAO)
		super();
		// End of user code
	}

	/**
	 * add Cell.
	 * @param column of the cell
	 * @param item of the cell
	 * @param value of type
	 * @return the cell created
	 */
	@Override
	public <T extends Type> Cell<? extends Type> addCell(Column<? extends Type> column, Item item, T value) {

		if(column == null || item == null || value == null) {
			return null;
		}

		int idCell = -1;

		// Resulset
		ResultSet rs = null;
		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO cell"
				+ " (idBoard, idColumn, idItem, idType, idItemCollection) VALUES(?, ?, ?, ?, ?)";

		try {
			// Get connection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String req = "INSERT INTO cell"
				+ " (idBoard, idColumn, idItem, idType, idItemCollection) VALUES("
				+ DAO.stringFormat(column.getParentBoard().getBoard_id() + "") + ", "
				+ DAO.stringFormat(column.getColumn_id() + "") + ", " 
				+ DAO.stringFormat(item.getItem_id() + "") + ", "
				+ DAO.stringFormat(column.getColumnType().getIdType() + "") + ", "
				+ DAO.stringFormat(item.getParentItemCollection().getItemCollection_id() + "")
				+ ")";

		int cellId = -1;
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);

			rs = stmt.getGeneratedKeys();
			rs.next();
			cellId = rs.getInt(1);
			
		} catch (SQLException e) {

			DAO.closeConnection(0);
			e.printStackTrace();
			return null;
		}
		

		DAO.closeConnection(0);
		
		// GET THE COLUMN TYPE

		String type = value.getNameType();
		switch (type) {
		case "TimelineType":

			TimelineType valTime = (TimelineType) value;

			query = "INSERT INTO timelinetype (idCell, startDate, endDate)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO timelinetype (idCell, startDate, endDate)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(DAO.dateFormat(valTime.getStartDate()) + "") + ", "
					+ DAO.stringFormat(DAO.dateFormat(valTime.getEndDate()) + "")
					+ ")";
			break;

		case "TextType":
			TextType valText = (TextType) value;

			query = "INSERT INTO texttype (idCell, text)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO texttype (idCell, text)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valText.getText())
					+ ")";
			break;

		case "NumberType":
			NumberType valNumber = (NumberType) value;

			query = "INSERT INTO numbertype (idCell, number)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO numbertype (idCell, number)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valNumber.getValue() + "")
					+ ")";
			break;

		case "DateType":
			DateType valDate = (DateType) value;

			query = "INSERT INTO datetype (idCell, date)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO datetype (idCell, date)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(DAO.dateFormat(valDate.getDate()) + "")
					+ ")";
			break;

		case "PersonType":
			PersonType valPerson = (PersonType) value;

			query = "INSERT INTO persontype (idCell, idUser)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO persontype (idCell, idUser)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valPerson.getUser().getUser_id() + "")
					+ ")";
			break;

			//TODO faire requete sur les statuslabel
		case "StatusType":
			StatusType valStatus = (StatusType) value;

			query = "INSERT INTO StatusType (idCell, idUser)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO StatusType (idCell, idUser)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					// here
					+ DAO.stringFormat(valStatus.getStatusLabels()+ "")
					+ ")";
			break;

			// TODO faire req avec tous les items
		case "DependencyType":
			DependencyType valDep = (DependencyType) value;

			query = "INSERT INTO DependencyType (idCell, idItem)"
					+ " VALUE (?, ?)";
			req = "INSERT INTO DependencyType (idCell, idItem)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					// here
					+ DAO.stringFormat(valDep.getItems()+ "")
					+ ")";
			break;

		default:
			break;
		}

		try {
			// Get connection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				idCell = rs.getInt(1);
			}

		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
			return null;
		}

		DAO.closeConnection(0);
		return new Cell(item, column, value, idCell);
	}

	/**
	 * delete Cell.
	 * @param cell we must delete
	 * @return a boolean according to the success of delete
	 */
	@Override
	// TODO ne marche pas avec les nouvelles tables
	public <T extends Type> Boolean deleteCell(Cell<T> cell) {
		
		if (cell == null) {
			return false;
		}
		// Result from DB
		ResultSet rs;

		// Query statement
		Statement stmt = null;

		try {
			// Get connection
			stmt = DAO.getConnection(0)
				.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String req = "SELECT idCell "
				+ "FROM Cell "
				+ "WHERE idBoard = " + DAO.stringFormat(cell.getItem().getParentItemCollection().getParentBoard().getBoard_id() + "")
				+ " AND idColumn = " + DAO.stringFormat(cell.getColumn().getColumn_id() + "")
				+ " AND idItem = " + DAO.stringFormat(cell.getItem().getItem_id() + "")
				+ " AND idItemCollection = " + DAO.stringFormat(cell.getItem().getParentItemCollection().getItemCollection_id() + "");

		try {
			assert stmt != null;
			rs = stmt.executeQuery(req);

			if(rs.next()) {
				rs.deleteRow();

				DAO.closeConnection(0);
				return true;
			}
			// if rs is empty

			DAO.closeConnection(0);
			return false;
		} catch (SQLException e) {

			DAO.closeConnection(0);
			return false;
		}
	}

	/**
	 * edit Cell.
	 * @param cell we must edit
	 * @param value of the edition
	 * @return a boolean according to the success of update
	 */
	@Override
	public <T extends Type> Boolean editCell(Cell<T> cell, T value) {

		if(cell == null || value == null) {
			return false;
		}

		// Query statement
		PreparedStatement stmt;

		String query = "";

		String type = value.getNameType();
		switch (type) {
			case "TimelineType":
				query = "UPDATE timelinetype " +
						"SET startDate = ?, endDate = ?"
						+ " WHERE idCell = ?";

				break;

			case "TextType":
				query = "UPDATE texttype " +
						"SET text = ? "
						+ " WHERE idCell = ?";
				break;

			case "NumberType":
				query = "UPDATE numbertype " +
						"SET number = ?"
						+ " WHERE idCell = ?";
				break;

			case "DateType":
				query = "UPDATE datetype " +
						"SET date = ?" +
						" WHERE idCell = ?";
				break;

			case "PersonType":
				query = "UPDATE persontype" +
						"SET idUser = ?"
						+ " WHERE idCell = ?";
				break;

			//TODO faire requete sur les statuslabel
			case "StatusType":
				query = "UPDATE StatusType " +
						"SET idUser = ?"
						+ " WHERE idCell = ?";
				break;

			// TODO faire req avec tous les items
			case "DependencyType":
				query = "UPDATE DependencyType" +
						" SET idItem = ?"
						+ " WHERE idCell = ?";
				break;

			default:
				break;
		}

		try {
			// Get connection
			stmt = DAO.getConnection(0)
					.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		switch (type) {
			// TODO avec les date ne marche pas
			case "TimelineType":
				TimelineType valTime = (TimelineType) value;

				try {
					stmt.setDate(1, (Date) valTime.getStartDate());
					stmt.setDate(2, (Date) valTime.getEndDate());
					stmt.setInt(3, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			case "TextType":
				TextType valText = (TextType) value;

				try {
					stmt.setString(1, valText.getText());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			case "NumberType":
				NumberType valNumber = (NumberType) value;

				try {
					stmt.setInt(1, valNumber.getValue());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			case "DateType":
				DateType valDate = (DateType) value;

				try {
					stmt.setDate(1, (Date) valDate.getDate());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			case "PersonType":
				PersonType valPerson = (PersonType) value;

				try {
					stmt.setInt(1, valPerson.getUser().getUser_id());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			//TODO faire requete sur les statuslabel
			case "StatusType":
				StatusType valStatus = (StatusType) value;

				try {
					//stmt.setString(1, valStatus.getStatusLabels());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}

				break;

			// TODO faire req avec tous les items
			case "DependencyType":
				DependencyType valDep = (DependencyType) value;

				query = "UPDATE DependencyType" +
						" SET idItem = ?"
						+ " WHERE idCell = ?";

				try {
					//stmt.setInt(1, valDep.getItems());
					stmt.setInt(2, cell.getCellId());

				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			default:
				break;
		}

		// execute the java prepared statement
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

			DAO.closeConnection(0);
			return false;
		}

		DAO.closeConnection(0);
		return true;
	}

	public static void main(String[] args) {
		MySQLCellDAO mySQL = new MySQLCellDAO();
		
		
		Workspace parentWorkspace = new Workspace("salut");
		
		User boardOwner = new User("name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(75, "test", parentWorkspace, boardOwner, new java.util.Date(), new Permission(0, "", ""));

		
		ItemCollection itemCol = new ItemCollection("test", 1, parentBoard);
		Item item = new Item(4, "salut", itemCol);
		
		Column<TextType> column = new Column<>(parentBoard, "sa", 2, DAO.getTypeById(0));


		TextType textType = null;
		try {
			textType = new TextType(0, "", "ddededdedede");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Cell<TextType> cell = new Cell(item, column, textType, 0);

		//Boolean res = mySQL.deleteCell(cell);
		//System.out.println(res);

		//System.out.println(new Date());

		DateType dateType = new DateType(5, "", new java.util.Date());

		System.out.println(mySQL.addCell(column, item, dateType));
		//System.out.println(mySQL.editCell(cell, textType));
	}
}
