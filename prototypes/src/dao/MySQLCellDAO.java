/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business_logic.board.AbstractType;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
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
	public Cell addCell(Column column, Item item) {
		// TODO Auto-generated method stub
		return null;
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
				+ "FROM Cell";

		try {
			rs = stmt.executeQuery(req);
			if(rs.next()) {
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
		
		mySQL.deleteCell(new Cell(5));
	}

}
