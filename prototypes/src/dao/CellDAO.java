/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.AbstractType;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
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
	public abstract Cell addCell(Column column, Item item);

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
	// TODO verify if really abstract
	public abstract Boolean editCell(Cell cell, AbstractType value);

	// Start of user code (user defined methods for CellDAO)

	// End of user code

}
