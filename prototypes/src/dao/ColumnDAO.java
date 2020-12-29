/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.Board;
import business_logic.board.Column;
import dao.DAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ColumnDAO.
 * 
 * @author 
 */
public abstract class ColumnDAO implements DAO {
	// Start of user code (user defined attributes for ColumnDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public ColumnDAO() {
		// Start of user code constructor for ColumnDAO)
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
	public abstract Board addColumn(String columnName, Board board, String typeName);

	/**
	 * Description of the method deleteColumn.
	 * @param column 
	 * @return 
	 */
	public abstract Boolean deleteColumn(Column column);

	/**
	 * Description of the method getAllColumnTypes.
	 * @return 
	 */
	public abstract Object getAllColumnTypes();

	/**
	 * Description of the method dateFormat.
	 * @param date 
	 * @return 
	 */
	public String dateFormat(Date date) {
		// Start of user code for method dateFormat
		String dateFormat = "";
		return dateFormat;
		// End of user code
	}

	/**
	 * Description of the method stringFormat.
	 * @param string 
	 * @return 
	 */
	public String stringFormat(String string) {
		// Start of user code for method stringFormat
		String stringFormat = "";
		return stringFormat;
		// End of user code
	}

	// Start of user code (user defined methods for ColumnDAO)

	// End of user code

}
