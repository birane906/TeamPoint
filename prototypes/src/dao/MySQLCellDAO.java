package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business_logic.board.*;
import business_logic.board.types.Type;
import business_logic.board.types.TypeFactory;
import business_logic.user.User;
import business_logic.workspace.Workspace;

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
	public Cell addCell(Column column, Item item, Object value) {

		if(column == null || item == null || value == null) {
			return null;
		}

		// Query statement
		PreparedStatement stmt = null;

		String query = "INSERT INTO cell"
				+ " (idBoard, idColumn, idItem, idItemCollection, cellValue) VALUES(?, ?, ?, ?, ?)";

		try {
			// Getconnection
			stmt = DAO.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
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
		
		try {
			assert stmt != null;
			stmt.execute(req);
		} catch (SQLException e) {

			try {
				DAO.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return null;
		}

		try {
			DAO.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Cell(item, column, value);
	}	

	/**
	 * delete Cell.
	 * @param cell we must delete
	 * @return a boolean according to the success of delete
	 */
	@Override
	public Boolean deleteCell(Cell cell) {
		
		if (cell == null) {
			return false;
		}
		// Result from DB
		ResultSet rs;

		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
			stmt = DAO.getConnection()
				.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			// TODO explain database not found
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

				try {
					DAO.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return true;
			}
			// if rs is empty

			try {
				DAO.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return false;
		} catch (SQLException e) {

			try {
				DAO.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

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
	public Boolean editCell(Cell cell, Type value) {

		if(cell == null || value == null) {
			System.out.println("sa");
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
			stmt = DAO.getConnection()
					.prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
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
			e.printStackTrace();
		}

		// execute the java prepared statement
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DAO.getConnection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		try {
			DAO.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) {
		MySQLCellDAO mySQL = new MySQLCellDAO();
		
		
		Workspace parentWorkspace = new Workspace("salut");
		
		User boardOwner = new User("name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner);
		
		ItemCollection itemCol = new ItemCollection("test", 0, parentBoard);
		Item item = new Item(itemCol, 0, "salut");
		
		Column column = new Column(parentBoard, "sa", 0, DAO.getTypeById(0));
		
		Cell cell = new Cell(item, column, "sabusainekoz");

		//Boolean res = mySQL.deleteCell(cell);
		//System.out.println(res);

		//System.out.println(mySQL.addCell(column, item, "sa"));
		System.out.println(mySQL.editCell(cell, TypeFactory.createType(0, "TimelineType", "DATE")));
	}

}
