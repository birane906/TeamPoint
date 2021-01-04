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
	public abstract Boolean editCell(Cell cell, Type value);

	/**
	 * For every items and column set the cells according to the db
	 * @param board
	 * @return
	 */
		//TODO decide what to do with this @NicolasGalois
}
