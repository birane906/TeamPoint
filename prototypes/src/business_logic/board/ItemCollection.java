/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

import business_logic.board.Board;
import business_logic.board.Item;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ItemCollection.
 * 
 * @author 
 */
public class ItemCollection {
	/**
	 * Description of the property itemCollection_id.
	 */
	public Int itemCollection_id = null;

	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property parentBoard.
	 */
	public Board parentBoard = null;

	/**
	 * Description of the property items.
	 */
	public HashSet<Item> items = new HashSet<Item>();

	// Start of user code (user defined attributes for ItemCollection)

	// End of user code

	/**
	 * Description of the method addItem.
	 * @param item 
	 */
	public void addItem(Item item) {
		// Start of user code for method addItem
		// End of user code
	}

	/**
	 * Description of the method deleteItem.
	 * @param item 
	 */
	public void deleteItem(Item item) {
		// Start of user code for method deleteItem
		// End of user code
	}

	// Start of user code (user defined methods for ItemCollection)

	// End of user code
	/**
	 * Returns itemCollection_id.
	 * @return itemCollection_id 
	 */
	public Int getItemCollection_id() {
		return this.itemCollection_id;
	}

	/**
	 * Sets a value to attribute itemCollection_id. 
	 * @param newItemCollection_id 
	 */
	public void setItemCollection_id(Int newItemCollection_id) {
		this.itemCollection_id = newItemCollection_id;
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

	/**
	 * Returns items.
	 * @return items 
	 */
	public HashSet<Item> getItems() {
		return this.items;
	}

}
