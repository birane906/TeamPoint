/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Description of Item.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class Item {

	/**
	 * The label
	 */
	private String label;

	/**
	 * The item id
	 */
	public int item_id;

	/**
	 * The parent {@link ItemCollection}
	 */
	public ItemCollection parentItemCollection;

	/**
	 * The item cells
	 */
	public List<Cell<? extends Type>> cells;

	/**
	 * Constructor for Item with empty cells
	 * @param id
	 * @param label
	 * @param parentItemCollection
	 */
	public Item(int id, String label,ItemCollection parentItemCollection) {
		this.item_id = id;
		this.parentItemCollection = parentItemCollection;
		this.label = label;
		this.cells = new ArrayList<>();
		//TODO : check for bugs

		List<Column> columns = parentItemCollection.getParentBoard().getColumns();

		for (Column column : columns) {
			Cell cell = column.addEmptyCell(this);
			this.cells.add(cell);
		}
	}

	public Item(int id, String label) {
		this.item_id = id;
		this.label = label;
	}

	/**
	 * Constructor Item with cells
	 * @param id
	 * @param label
	 * @param parentItemCollection
	 */
	public Item(int id, String label,ItemCollection parentItemCollection, List<Cell<? extends Type>> cells) {
		this.item_id = id;
		this.parentItemCollection = parentItemCollection;
		this.label = label;
		this.cells = cells;
	}
	/**
	 * Returns label.
	 * @return label 
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Sets a value to attribute label. 
	 * @param newLabel 
	 */
	public void setLabel(String newLabel) {
		this.label = newLabel;
	}

	/**
	 * Returns item_id.
	 * @return item_id 
	 */
	public int getItem_id() {
		return this.item_id;
	}

	/**
	 * Returns parentItemCollection.
	 * @return parentItemCollection 
	 */
	public ItemCollection getParentItemCollection() {
		return this.parentItemCollection;
	}

	/**
	 * Sets a value to attribute parentItemCollection. 
	 * @param newParentItemCollection 
	 */
	public void setParentItemCollection(ItemCollection newParentItemCollection) {
		this.parentItemCollection = newParentItemCollection;
	}

	/**
	 * Returns cells.
	 * @return cells 
	 */
	public List<Cell<? extends Type>> getCells() {
		return this.cells;
	}

	public void addCell(Cell<? extends Type> cell) {
		this.cells.add(cell);
	}

	public void setCells(List<Cell<? extends Type>> cells) {
		this.cells = cells;
	}

	public String toString() {
		return this.label;
	}
}
