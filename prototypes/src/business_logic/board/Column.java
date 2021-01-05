/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Description of Column.
 * 
 * @author 
 */
public class Column<T extends Type> {

	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property column_id.
	 */
	private int column_id;

	/**
	 * Description of the property parentBoard.
	 */
	private Board parentBoard;

	/**
	 * Description of the property cells.
	 */
	public List<Cell<T>> cells;

	/**
	 * Constructor with empty cells
	 * @param parentBoard the parent Board
	 * @param name
	 * @param column_id
	 */
	public Column(Board parentBoard, String name, int column_id) {
		this.parentBoard = parentBoard;
		this.column_id = column_id;
		this.name = name;
		this.cells = new ArrayList<>();
		//need to create the empty cells ?
	}
	
	/**
	 * Constructor with already existing cells
	 * @param parentBoard
	 * @param name
	 * @param column_id
	 * @param cells 
	 */
	public Column(Board parentBoard, String name, int column_id, List<Cell<T>> cells) {
		this.parentBoard = parentBoard;
		this.column_id = column_id;
		this.name = name;
		this.cells = cells;
	}
	
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
	public List<Cell<T>> getCells() {
		return this.cells;
	}

	public void setCells(List<Cell<T>> cells) {
		this.cells = cells;
	}

	/**
	 * Returns column_id.
	 * @return column_id 
	 */
	public int getColumn_id() {
		return this.column_id;
	}

	/**
	 * Sets a value to attribute column_id. 
	 * @param newColumn_id 
	 */
	public void setColumn_id(int newColumn_id) {
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

	public void addCell(Cell<T> cell) {
		this.cells.add(cell);
	}
}
