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
	 * is equals to T of Column<T>
	 */
	private final Type typeParameterClass;

	/**
	 * Description of the property name.
	 */
	private String columnName;

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
	public List<Cell<? extends Type>> cells;

	/**
	 * Constructor for {@link Column} with empty cells
	 * @param parentBoard the parent Board {@link Board}
	 * @param columnName the name of the column {@link String}
	 * @param column_id int
	 * @param typeParameterClass is the {@link Type} of the generic parameter 
	 */
	public Column(Board parentBoard, String columnName, int column_id, Type typeParameterClass) {
		this.parentBoard = parentBoard;
		this.column_id = column_id;
		this.typeParameterClass = typeParameterClass;
		this.columnName = columnName;
		this.cells = new ArrayList<>();
		for (ItemCollection itemCollection: parentBoard.getItemCollections()) {
			for (Item item : itemCollection.getItems()) {
				cells.add(new Cell<>(item,this,null));
			}
		}
	}
	
	/**
	 * Constructor with already existing cells
	 * @param parentBoard
	 * @param columnName
	 * @param column_id
	 * @param cells 
	 */
	public Column(Board parentBoard, 
		String columnName, int column_id, 
		List<Cell<? extends Type>> cells, Type typeParameterClass) throws Exception {
		for (Cell<? extends Type> cell : cells) {
			if (cell != null && !cell.getValue().getClass().getSimpleName().equals(typeParameterClass.getClass().getSimpleName())) {
				throw new Exception("The cells type must be"+
					"the same as the Column type");
			}
		}
		this.parentBoard = parentBoard;
		this.column_id = column_id;
		this.typeParameterClass = typeParameterClass;
		this.columnName = columnName;
		this.cells = cells;
	}
	
	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.columnName;
	}

	/**
	 * Sets a value to attribute columnName. 
	 * @param newcolumnName 
	 */
	public void setcolumnName(String newcolumnName) {
		this.columnName = newcolumnName;
	}

	/**
	 * Returns cells.
	 * @return cells 
	 */
	public List<Cell<? extends Type>> getCells() {
		return this.cells;
	}

	/**
	 * Set the column cells 
	 * @param cells
	 * @throws Exception if the cells type is not the same as the column
	 */
	public void setCells(List<Cell<? extends Type>> cells) throws Exception {
		for (Cell<? extends Type> cell : cells) {
			if (cell != null && !cell.getValue().getClass().getSimpleName().equals(typeParameterClass.getClass().getSimpleName())) {
				throw new Exception("The cells type must be"+
				 "the same as the Column type");
			}
		}
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

	public Type getColumnType() {
		return this.typeParameterClass;
	}
}
