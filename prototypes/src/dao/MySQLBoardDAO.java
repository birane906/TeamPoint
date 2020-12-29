/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import business_logic.board.AbstractType;
import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.user.User;
import dao.ColumnDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MySQLBoardDAO.
 * 
 * @author 
 */
public class MySQLBoardDAO extends ColumnDAO {
	// Start of user code (user defined attributes for MySQLBoardDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MySQLBoardDAO() {
		// Start of user code constructor for MySQLBoardDAO)
		super();
		// End of user code
	}

	/**
	 * add Column.
	 * @param columnName 
	 * @param board we want the column to be created
	 * @param typeName String type of {@link AbstractType}
	 * @return the board with the new column
	 */
	public Board addColumn(String columnName, Board board, String typeName) {
		// Start of user code for method addColumn
		Board addColumn = null;
		return addColumn;
		// End of user code
	}

	/**
	 * delete Column.
	 * @param column to be deleted
	 * @return the board updated
	 */
	public Boolean deleteColumn(Column column) {
		return null;
	}

	/**
	 * getAllColumnTypes .
	 * @return column abtract types String that describe type of all the column types
	 */
	public ArrayList<AbstractType> getAllColumnTypes() {
		
		ArrayList<AbstractType> resultat = new ArrayList<AbstractType>();
		
		// Result from database
		ResultSet rs = null;
		// Query statement
		Statement stmt = null;

		try {
			// Getconnection from JDBCConnector
			stmt = DAO.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO explain database not found
			e.printStackTrace();
		}

		String req = "SELECT *"
				+ " FROM Celltype";

		try {
			if (stmt.execute(req)) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException e) {
			// TODO explain connection lost
			e.printStackTrace();
		}

		// if we have a result then move to the next line
		try {
			while(rs.next()){
				
				int id = rs.getInt("idCellType");
				String typeName = rs.getString("nameType");
				String description = rs.getString("descriptionType");
				
				
				resultat.add(new AbstractType(id, typeName, description));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
	}
	
	public static void main(String[] args) {
		MySQLBoardDAO mySQLBoardDAO = new MySQLBoardDAO();
		
		ArrayList<AbstractType> res = mySQLBoardDAO.getAllColumnTypes();
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

	// Start of user code (user defined methods for MySQLBoardDAO)

	// End of user code

}
