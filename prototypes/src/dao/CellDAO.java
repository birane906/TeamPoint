/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.*;
import dao.DAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of CellDAO.
 * 
 * @author 
 */
public abstract class CellDAO implements DAO {
	// Start of user code (user defined attributes for CellDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public CellDAO() {
		// Start of user code constructor for CellDAO)
		super();
		// End of user code
	}

	/**
	 * add Cell.
	 * @param column 
	 * @param item 
	 * @return the cell created
	 */
	// TODO verify if really abstract
	public abstract Cell addCell(Column column, Item item, Object value);

	/**
	 * delete Cell.
	 * @param cell 
	 * @return a boolean according to the success of delete
	 */
	// TODO verify if really abstract
	public abstract Boolean deleteCell(Cell cell);
	/**
	 * edit Cell.
	 * @param cell 
	 * @param value 
	 * @return a boolean according to the success of update
	 */
	public abstract Boolean editCell(Cell cell, AbstractType value);

	/**
	 * For every items and column set the cells according to the db
	 * @param board
	 * @return
	 */
	public abstract boolean setCells(Board board, Column column, Item item);

	// Start of user code (user defined methods for CellDAO)

	// End of user code

}
