/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Cell.
 * 
 * @author 
 */
public class Cell {
	/**
	 * Description of the property column.
	 */
	public Column column = null;

	/**
	 * Description of the property value.
	 */
	private Object value = null;

	/**
	 * Description of the property item.
	 */
	public Item item = null;

	public Cell(Item item, Column column, Object value) {
		this.column = column;
		this.value = value;
		this.item = item;
	}

	/**
	 * Returns column.
	 * @return column 
	 */
	public Column getColumn() {
		return this.column;
	}

	/**
	 * Sets a value to attribute column. 
	 * @param newColumn 
	 */
	public void setColumn(Column newColumn) {
		this.column = newColumn;
	}

	/**
	 * Returns value.
	 * @return value 
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * Sets a value to attribute value. 
	 * @param newValue 
	 */
	public void setValue(Object newValue) {
		this.value = newValue;
	}

	/**
	 * Returns item.
	 * @return item 
	 */
	public Item getItem() {
		return this.item;
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
}
