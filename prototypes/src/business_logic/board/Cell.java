/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.types.Type;

/**
 * The {@link Cell} is a container of the value for a giving {@link Item} and {@link Column}
 * The type of the {@link Cell} must implements {@link Type}
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Cell<T extends Type> {

	private int cellId;

	/**
	 * The {@link Column} of the {@link Cell}
	 * The {@link Column} must have the same type than the {@link Cell}
	 */
	private Column<T> column;

	/**
	 * The effective value of type {@link Type} of the {@link Cell}
	 */
	private T value;

	/**
	 * The {@link Item} of the {@link Cell}
	 */
	private Item item;

	/**
	 * The constructor of the {@link Cell}
	 * @param item The {@link Item} to which belongs the {@link Cell}
	 * @param column The {@link Column} to which belongs the {@link Cell}
	 * @param value The value of type {@link Type} of the {@link Cell}
	 * @param idCell The ID of the newly created {@link Cell}
	 */
	public Cell(Item item, Column<T> column, T value, int idCell) {
		this.column = column;
		this.value = value;
		this.item = item;
		this.cellId = idCell;
	}

	/**
	 * The constructor of the {@link Cell}
	 * @param item The {@link Item} to which belongs the {@link Cell}
	 * @param column The {@link Column} to which belongs the {@link Cell}
	 * @param value The value of type {@link Type} of the {@link Cell}
	 */
	public Cell(Item item, Column<T> column, T value) {
		this.column = column;
		this.value = value;
		this.item = item;
	}
	/**
	 * @return The {@link Column} of the {@link Cell}
	 */
	public Column<T> getColumn() {
		return this.column;
	}

	/**
	 * Sets the {@link Column} of the {@link Cell}
	 * @param newColumn A {@link Column} of the same type as the {@link Cell}
	 */
	public void setColumn(Column<T> newColumn) {
		this.column = newColumn;
	}

	/**
	 * @return The effective value of type {@link Type} of the {@link Cell}
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Sets the effective value of type {@link Type} of the {@link Cell}
	 * @param newValue A value of the same type as the {@link Cell}
	 */
	public void setValue(T newValue) {
		this.value = newValue;
	}

	/**
	 * @return The {@link Item} of the {@link Cell}
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * Sets the {@link Item} of the {@link Cell}
	 * @param newItem An {@link Item}
	 */
	public void setItem(Item newItem) {
		this.item = newItem;
	}
	
	public String toString() {
		String str = "";

		str += "id: " + getCellId();
		str += " value: " + getValue();
		str += "\n";

		return str;
	}

	/**
	 * @return The id of the {@link Cell}
	 */
	public int getCellId() {
		return cellId;
	}
}
