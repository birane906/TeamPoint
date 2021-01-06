package dao.mySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business_logic.board.*;
import business_logic.board.types.DateType;
import business_logic.board.types.DependencyType;
import business_logic.board.types.NumberType;
import business_logic.board.types.PersonType;
import business_logic.board.types.StatusType;
import business_logic.board.types.TextType;
import business_logic.board.types.TimelineType;
import business_logic.board.types.Type;
import dao.CellDAO;
import dao.DAO;

/**
 * Description of MySQLCellDAO.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLCellDAO extends CellDAO {

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
	 * @return the cell created
	 */
	@Override
	public Cell<? extends Type> addCell(Column<? extends Type> column, Item item, Type value) {

		if(column == null || item == null || value == null) {
			return null;
		}

		// Resulset
		ResultSet rs;
		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO cell"
				+ " (idBoard, idColumn, idItem, idItemCollection, cellValue) VALUES(?, ?, ?, ?, ?)";

		try {
			// Getconnection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String req = "INSERT INTO cell"
				+ " (idBoard, idColumn, idItem, idItemCollection, cellValue) VALUES("
				+ DAO.stringFormat(column.getParentBoard().getBoard_id() + "") + ", " 
				+ DAO.stringFormat(column.getColumn_id() + "") + ", " 
				+ DAO.stringFormat(item.getItem_id() + "") + ", "
				+ DAO.stringFormat(item.getParentItemCollection().getItemCollection_id() + "") + ", "
				+ DAO.stringFormat(value + "")
				+ ")";

		int cellId = -1;
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			
			rs = stmt.getGeneratedKeys();
			cellId = rs.getInt(1);
			
		} catch (SQLException e) {

			DAO.closeConnection(0);
			return null;
		}
		

		DAO.closeConnection(0);
		
		// GET THE COLUMN TYPE

		String type = column.getColumnType().getNameType();
		switch (type) {
		case "TimelineType":
			
			TimelineType valTime = (TimelineType) value;
			
			query = "INSERT INTO timelinetype (idCell, startDate, endDate)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO timelinetype (idCell, startDate, endDate)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valTime.getEndDate() + "") + ", "
					+ DAO.stringFormat(valTime.getEndDate() + "")
					+ ")";
			break;
			
		case "TextType":
			TextType valText = (TextType) value;
			
			query = "INSERT INTO timelinetype (idCell, text)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO timelinetype (idCell, text)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valText.getText())
					+ ")";
			break;
			
		case "NumberType":
			NumberType valNumber = (NumberType) value;
			
			query = "INSERT INTO numbertype (idCell, number)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO numbertype (idCell, number)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valNumber.getValue() + "")
					+ ")";
			break;
			
		case "DateType":
			DateType valDate = (DateType) value;
			
			query = "INSERT INTO datetype (idCell, date)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO datetype (idCell, date)"
					+ " VALUE ("
					+ DAO.stringFormat(cellId + "") + ", "
					+ DAO.stringFormat(valDate.getDate() + "")
					+ ")";
			break;
			
		case "PersonType":
			PersonType valPerson = (PersonType) value;
			
			query = "INSERT INTO persontype (idCell, idUser)"
					+ " VALUE (?, ?, ?)";
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
					+ " VALUE (?, ?, ?)";
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
			
			query = "INSERT INTO DependencyType (idCell, idUser)"
					+ " VALUE (?, ?, ?)";
			req = "INSERT INTO DependencyType (idCell, idUser)"
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
			// Getconnection
			stmt = DAO.getConnection(0).prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			assert stmt != null;
			stmt.executeUpdate(req);
			
		} catch (SQLException e) {
			DAO.closeConnection(0);
			return null;
		}

		DAO.closeConnection(0);
		
		//TODO : Fix DB And Rewrite this part
		//return new Cell(item, column, (Type) value);
		return null;
	}	

	/**
	 * delete Cell.
	 * @param cell we must delete
	 * @return a boolean according to the success of delete
	 */
	@Override
	public Boolean deleteCell(Cell<? extends Type> cell) {
		
		if (cell == null) {
			return false;
		}
		// Result from DB
		ResultSet rs;

		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
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
	public Boolean editCell(Cell<? extends Type> cell, Type value) {

		if(cell == null || value == null) {
			return false;
		}

		// Query statement
		PreparedStatement stmt;

		String query = "UPDATE cell "
				+ "SET cellValue = ? "
				+ "WHERE idBoard = ?"
				+ " AND idColumn = ? "
				+ " AND idItem = ?"
				+ " AND idItemCollection = ?";

		try {
			// Get connection
			stmt = DAO.getConnection(0)
					.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		try {
			assert stmt != null;
			stmt.setObject(1, DAO.stringFormat(cell.getValue() + ""));
			stmt.setInt(2, cell.getItem().getParentItemCollection().getParentBoard().getBoard_id());
			stmt.setInt(3, cell.getColumn().getColumn_id());
			stmt.setInt(4, cell.getItem().getItem_id());
			stmt.setInt(5, cell.getItem().getParentItemCollection().getItemCollection_id());

		} catch (SQLException e) {
			DAO.closeConnection(0);
			e.printStackTrace();
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

	/*public static void main(String[] args) {
		MySQLCellDAO mySQL = new MySQLCellDAO();
		
		
		Workspace parentWorkspace = new Workspace("salut");
		
		User boardOwner = new User("name", "firstName", "email", "profileDescription", "phoneNumber");
		//Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner);
		
		//ItemCollection itemCol = new ItemCollection("test", 0, parentBoard);
		//Item item = new Item(itemCol, 0, "salut");
		
		//Column column = new Column(parentBoard, "sa", 0, DAO.getTypeById(0));
		
		//Cell cell = new Cell(item, column, "sabusainekoz");

		//Boolean res = mySQL.deleteCell(cell);
		//System.out.println(res);

		//System.out.println(mySQL.addCell(column, item, "sa"));
		//System.out.println(mySQL.editCell(cell, TypeFactory.createType(0, "TimelineType", "DATE")));
	}
	*/
}
