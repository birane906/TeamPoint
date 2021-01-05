/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.types.Type;
/**
 * Description of CellDAO.
 * 
 * @author 
 */
public abstract class CellDAO implements DAO {

	/**
	 * add Cell.
	 * @param column 
	 * @param item 
	 * @return the cell created
	 */
	public abstract Cell<? extends Type> addCell(Column<? extends Type> column, Item item, Type value);

	/**
	 * delete Cell.
	 * @param cell 
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteCell(Cell<? extends Type> cell);

	/**
	 * edit Cell.
	 * @param cell 
	 * @param value 
	 * @return a boolean according to the success of update
	 */
	public abstract Boolean editCell(Cell<? extends Type> cell, Type value);
}
