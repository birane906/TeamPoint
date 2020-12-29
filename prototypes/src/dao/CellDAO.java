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
	public Cell addCell(Column column, Item item) {
		// Start of user code for method addCell
		Cell addCell = null;
		return addCell;
		// End of user code
	}

	/**
	 * delete Cell.
	 * @param cell 
	 * @return a boolean according to the success of delete
	 */
	public Boolean deleteCell(Cell cell) {
		// Start of user code for method deleteCell
		Boolean deleteCell = Boolean.FALSE;
		return deleteCell;
		// End of user code
	}

	/**
	 * edit Cell.
	 * @param cell 
	 * @param value 
	 * @return a boolean according to the success of update
	 */
	public Boolean editCell(Cell cell, AbstractType value) {
		// Start of user code for method editCell
		Boolean editCell = Boolean.FALSE;
		return editCell;
		// End of user code
	}

	// Start of user code (user defined methods for CellDAO)

	// End of user code

}
