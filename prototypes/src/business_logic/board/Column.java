/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.Board;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Column.
 * 
 * @author 
 */
public class Column {
	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property cells.
	 */
	public HashSet<Cell> cells = new HashSet<Cell>();

	/**
	 * Description of the property column_id.
	 */
	public Int column_id = null;

	/**
	 * Description of the property parentBoard.
	 */
	public Board parentBoard = null;

	// Start of user code (user defined attributes for Column)

	// End of user code

	// Start of user code (user defined methods for Column)

	// End of user code
	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name. 
	 * @param newName 
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns cells.
	 * @return cells 
	 */
	public HashSet<Cell> getCells() {
		return this.cells;
	}

	/**
	 * Returns column_id.
	 * @return column_id 
	 */
	public Int getColumn_id() {
		return this.column_id;
	}

	/**
	 * Sets a value to attribute column_id. 
	 * @param newColumn_id 
	 */
	public void setColumn_id(Int newColumn_id) {
		this.column_id = newColumn_id;
	}

	/**
	 * Returns parentBoard.
	 * @return parentBoard 
	 */
	public Board getParentBoard() {
		return this.parentBoard;
	}

	/**
	 * Sets a value to attribute parentBoard. 
	 * @param newParentBoard 
	 */
	public void setParentBoard(Board newParentBoard) {
		this.parentBoard = newParentBoard;
	}

}
