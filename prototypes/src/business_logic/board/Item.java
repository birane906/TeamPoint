/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

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
	public Int item_id = null;

	/**
	 * Description of the property parentItemCollection.
	 */
	public ItemCollection parentItemCollection = null;

	/**
	 * Description of the property cells.
	 */
	public HashSet<Cell> cells = new HashSet<Cell>();

	// Start of user code (user defined attributes for Item)

	// End of user code

	// Start of user code (user defined methods for Item)

	// End of user code
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
	public Int getItem_id() {
		return this.item_id;
	}

	/**
	 * Sets a value to attribute item_id. 
	 * @param newItem_id 
	 */
	public void setItem_id(Int newItem_id) {
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
	public HashSet<Cell> getCells() {
		return this.cells;
	}

}
