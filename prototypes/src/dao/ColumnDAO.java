/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.util.Date;

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
	 * add Column to a board.
	 * @param columnName 
	 * @param board 
	 * @param typeName the String of the abstractType {@link AbstractType}
	 * @return a {@link Board}
	 */
	public abstract Board addColumn(String columnName, Board board, String typeName);

	/**
	 * delete Column.
	 * @param column 
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteColumn(Column column);

	/**
	 * getAllColumnTypes .
	 * @return column types String that describe type of all the column types
	 */
	public abstract Object getAllColumnTypes();

	// Start of user code (user defined methods for ColumnDAO)

	// End of user code

}
