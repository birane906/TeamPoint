/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Column} describes a common property for all the {@link Item} of a {@link Board}
 *
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Column<T extends Type> {

	/**
	 * The {@link Type} of the {@link Column}
	 */
	private final Type typeParameterClass;

	/**
	 * The name of the {@link Column}
	 */
	private String columnName;

	/**
	 * The ID of the {@link Column}
	 */
	private int column_id;

	/**
	 * The {@link Board} to which belongs the {@link Column}
	 */
	private Board parentBoard;

	/**
	 * The {@link List} of the {@link Cell} of the {@link Column}
	 */
	public List<Cell<T>> cells;

	/**
	 * Constructor for {@link Column} with empty cells
	 * @param parentBoard The parent Board {@link Board}
	 * @param columnName The name of the column {@link String}
	 * @param column_id The ID of the newly created {@link Column}
	 * @param typeParameterClass The {@link Type} of the generic parameter
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
	 * @param parentBoard The parent Board {@link Board}
	 * @param columnName The name of the column {@link String}
	 * @param column_id The ID of the newly created {@link Column}
	 * @param cells The {@link List} of the cells
	 * @param typeParameterClass The {@link Type} of the generic parameter
	 */
	public Column(Board parentBoard, 
		String columnName, int column_id, 
		List<Cell<T>> cells, Type typeParameterClass) throws Exception {
		for (Cell<T> cell : cells) {
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
	 * @return The name of the {@link Column}
	 */
	public String getName() {
		return this.columnName;
	}

	/**
	 * Sets the name of the {@link Column}
	 * @param newcolumnName A name for the {@link Column}
	 */
	public void setcolumnName(String newcolumnName) {
		this.columnName = newcolumnName;
	}

	/**
	 * @return The {@link List} of the {@link Cell} of the {@link Column}
	 */
	public List<Cell<T>> getCells() {
		return this.cells;
	}

	/**
	 * Set the {@link List} of the {@link Cell} of the {@link Column}
	 * @param cells A {@link List} of the {@link Cell} of the {@link Column}
	 * @throws Exception if the cells type is not the same as the column
	 */
	public void setCells(List<Cell<T>> cells) throws Exception {
		for (Cell<T> cell : cells) {
			if (cell != null && !cell.getValue().getClass().getSimpleName().equals(typeParameterClass.getClass().getSimpleName())) {
				throw new Exception("The cells type must be"+
				 "the same as the Column type");
			}
		}
		this.cells = cells;
	}

	/**
	 * @return The ID of the {@link Column}
	 */
	public int getColumn_id() {
		return this.column_id;
	}

	/**
	 * Sets the ID of the {@link Column}
	 * @param newColumn_id an ID for the {@link Column}
	 */
	public void setColumn_id(int newColumn_id) {
		this.column_id = newColumn_id;
	}

	/**
	 * @return The {@link Board} to which belongs the {@link Column}
	 */
	public Board getParentBoard() {
		return this.parentBoard;
	}

	/**
	 * Sets the {@link Board} to which belongs the {@link Column}
	 * @param newParentBoard A {@link Board} to which belongs the {@link Column}
	 */
	public void setParentBoard(Board newParentBoard) {
		this.parentBoard = newParentBoard;
	}

	/**
	 * Add a {@link Cell} to the {@link List} of {@link Cell} of the {@link Column}
	 * @param cell A {@link Cell} of the same {@link Type} than the {@link Column}
	 */
	public void addCell(Cell<T> cell) {
		this.cells.add(cell);
	}

	/**
	 * Add an empty {@link Cell} to the {@link List} of {@link Cell} of the {@link Column}
	 */
	public Cell<T> addEmptyCell(Item item) {
		Cell cell = new Cell<T>(item, this, null);
		this.cells.add(cell);
		return cell;
	}

	/**
	 * @return The {@link Type} of the {@link Column}
	 */
	public Type getColumnType() {
		return this.typeParameterClass;
	}

	public String toString() {
		String str = "";

		str += "<<" + column_id + ">>\n";

		for (Cell cell: cells) {
			str += cell.toString();
		}
		return str;
	}
}
