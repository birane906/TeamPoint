/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.Board;
import business_logic.board.Column;
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
	 * Description of the method addColumn.
	 * @param columnName 
	 * @param board 
	 * @param typeName 
	 * @return 
	 */
	public Board addColumn(String columnName, Board board, String typeName) {
		// Start of user code for method addColumn
		Board addColumn = null;
		return addColumn;
		// End of user code
	}

	/**
	 * Description of the method deleteColumn.
	 * @param column 
	 * @return 
	 */
	public Boolean deleteColumn(Column column) {
		// Start of user code for method deleteColumn
		Boolean deleteColumn = Boolean.FALSE;
		return deleteColumn;
		// End of user code
	}

	/**
	 * Description of the method getAllColumnTypes.
	 * @return 
	 */
	public Object getAllColumnTypes() {
		return null;
		// Start of user code for method getAllColumnTypes
		// End of user code
	}

	// Start of user code (user defined methods for MySQLBoardDAO)

	// End of user code

}
