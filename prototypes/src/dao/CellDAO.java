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
	public abstract <T extends Type> Cell<? extends Type> addCell(Column<? extends Type> column, Item item, T value);

	/**
	 * delete Cell.
	 * @param cell 
	 * @return a boolean according to the success of delete
	 */
	public abstract <T extends Type> Boolean deleteCell(Cell<T> cell);

	/**
	 * edit Cell.
	 * @param cell 
	 * @param value 
	 * @return a boolean according to the success of update
	 */
	public abstract <T extends Type> Boolean editCell(Cell<T> cell, T value);
}
