/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.CellDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLCellDAO.
 * 
 * @author 
 */
public class MySQLCellDAO extends CellDAO {
	// Start of user code (user defined attributes for MySQLCellDAO)

	// End of user code

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
	public Boolean editCell(Cell cell, AbstractType value) {
		// TODO Auto-generated method stub
		return null;
	}

	// Start of user code (user defined methods for MySQLCellDAO)

	// End of user code
	
	public static void main(String[] args) {
		MySQLCellDAO mySQL = new MySQLCellDAO();
		
		
		Workspace parentWorkspace = new Workspace("salut");
		
		User boardOwner = new User("name", "firstName", "email", "profileDescription", "phoneNumber");
		Board parentBoard = new Board(0, "test", parentWorkspace, boardOwner);
		
		ItemCollection itemCol = new ItemCollection("test", 0, parentBoard);
		Item item = new Item(itemCol, 0, "salut");
		
		Column column = new Column(parentBoard, "sa", 0, 0);
		
		Cell cell = new Cell(item, column, "sa");
		
		//Boolean res = mySQL.deleteCell(cell);
		//System.out.println(res);
		
		System.out.println(mySQL.addCell(column, item, "sa"));
	}

}
