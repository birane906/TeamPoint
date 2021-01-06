/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.types.Type;

/**
 * Description of Cell.
 * 
 * @author 
 */
public class Cell<T extends Type> {

	/**
	 * is equals to T of Cell<T>
	 */
	private Type typeParameterClass;

	private int cellId;

	/**
	 * Description of the property column.
	 */
	public Column<T> column = null;

	/**
	 * Description of the property value.
	 */
	private T value = null;

	/**
	 * Description of the property item.
	 */
	public Item item = null;

	/**
	 *  @param item
	 * @param column
	 * @param value
	 */

	public Cell(Item item, Column<T> column, T value, int idCell) {
		this.column = column;
		this.value = value;
		this.item = item;
		this.cellId = idCell;
	}

	public Cell(Item item, Column<T> column, T value) {
			this.column = column;
			this.value = value;
			this.item = item;
	}

	/**
	 * Returns column.
	 * @return column 
	 */
	public Column<T> getColumn() {
		return this.column;
	}

	/**
	 * Sets a value to attribute column. 
	 * @param newColumn 
	 */
	public void setColumn(Column<T> newColumn) {
		this.column = newColumn;
	}

	/**
	 * Returns value.
	 * @return value 
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Sets a value to attribute value. 
	 * @param newValue 
	 */
	public void setValue(T newValue) {
		this.value = newValue;
	}

	/**
	 * Returns item.
	 * @return item 
	 */
	public Item getItem() {
		return this.item;
	}

	public Type getTypeParameterClass() {
		return typeParameterClass;
	}

	/**
	 * Sets a value to attribute item. 
	 * @param newItem 
	 */
	public void setItem(Item newItem) {
		this.item = newItem;
	}
	
	public String toString() {
		String str = "";
		
		str += "column: " + getColumn().getName();
		str += " item: " + getItem().getLabel();
		str += " value: " + getValue();
		
		return str;
	}

	public int getCellId() {
		return cellId;
	}
}
