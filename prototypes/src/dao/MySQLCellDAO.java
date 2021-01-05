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
 * @author 
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
	 * @param column 
	 * @param item 
	 * @return the cell created
	 */
	@Override
	public Cell addCell(Column column, Item item, Object value) {

		if(column == null || item == null || value == null) {
			return null;
		}

		// Query statement
		Statement stmt = null;

		try {
			// Getconnection
			stmt = DAO.getConnection().createStatement();
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
			stmt.execute(req);
		} catch (SQLException e) {
			return null;
		}
		
		return new Cell(item, column, value);
	}	

	/**
	 * delete Cell.
	 * @param cell 
	 * @return a boolean according to the success of delete
	 */
	@Override
	public Boolean deleteCell(Cell cell) {
		
		if (cell == null) {
			return false;
		}
		// Result from DB
		ResultSet rs = null;

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
			rs = stmt.executeQuery(req);

			while(rs.next()) {
				rs.deleteRow();
				return true;
			}
			// if rs is empty
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * edit Cell.
	 * @param cell 
	 * @param value 
	 * @return a boolean according to the success of update
	 */
	@Override
	public Boolean editCell(Cell cell, Type value) {

		if(cell == null || value == null) {
			System.out.println("sa");
			return false;
		}

		// Result from DB
		ResultSet rs = null;

		// Query statement
		PreparedStatement stmt = null;

		String query = "UPDATE cell "
				+ "SET cellValue = ? "
				+ "WHERE idBoard = ?"
				+ " AND idColumn = ? "
				+ " AND idItem = ?"
				+ " AND idItemCollection = ?";

		try {
			// Getconnection
			stmt = DAO.getConnection()
					.prepareStatement(query);
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		try {
			stmt.setObject(1, DAO.stringFormat(cell.getValue() + ""));
			stmt.setInt(2, cell.getItem().getParentItemCollection().getParentBoard().getBoard_id());
			stmt.setInt(3, cell.getColumn().getColumn_id());
			stmt.setInt(4, cell.getItem().getItem_id());
			stmt.setInt(5, cell.getItem().getParentItemCollection().getItemCollection_id());

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		// execute the java preparedstatement
		try {
			stmt.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
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
		
		Column column = new Column(parentBoard, "sa", 0, 0);
		
		Cell cell = new Cell(item, column, "sabusainekoz");
		
		//Boolean res = mySQL.deleteCell(cell);
		//System.out.println(res);
		
		//System.out.println(mySQL.addCell(column, item, "sa"));
		System.out.println(mySQL.editCell(cell, TypeFactory.createType(0, "TimelineType", "DATE")));
	}

}
