/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import java.util.ArrayList;
import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Item.
 * 
 * @author 
 */
public class Item {
	/**
	 * Description of the property label.
	 */
	private String label = "";

	/**
	 * Description of the property item_id.
	 */
	public int item_id;

	/**
	 * Description of the property parentItemCollection.
	 */
	public ItemCollection parentItemCollection;

	/**
	 * Description of the property cells.
	 */
	public ArrayList<Cell> cells = new ArrayList<>();

	public Item(ItemCollection parentItemCollection, int id, String label) {
		this.item_id = id;
		this.parentItemCollection = parentItemCollection;
		this.label = label;
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
	 * Sets a value to attribute item_id. 
	 * @param newItem_id 
	 */
	public void setItem_id(int newItem_id) {
		this.item_id = newItem_id;
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
	public ArrayList<Cell> getCells() {
		return this.cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	public void addCell(Cell cell) {
		this.cells.add(cell);
	}

}
