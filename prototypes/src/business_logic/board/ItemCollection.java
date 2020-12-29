package business_logic.board;

import business_logic.board.Board;
import business_logic.board.Item;

import java.util.HashSet;

/**
 * Description of ItemCollection.
 * 
 * @author 
 */
public class ItemCollection {
	/**
	 * Description of the property itemCollection_id.
	 */
	public int itemCollection_id;

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

	public ItemCollection(String name, int id, Board parentBoard) {
		this.itemCollection_id = id;
		this.name = name;
		this.parentBoard = parentBoard;
	}
	
	/**
	 * Description of the method addItem.
	 * @param item 
	 */
	public void addItem(Item item) {
	}

	/**
	 * Description of the method deleteItem.
	 * @param item 
	 */
	public void deleteItem(Item item) {
	}

	/**
	 * Returns itemCollection_id.
	 * @return itemCollection_id 
	 */
	public int getItemCollection_id() {
		return this.itemCollection_id;
	}

	/**
	 * Sets a value to attribute itemCollection_id. 
	 * @param newItemCollection_id 
	 */
	public void setItemCollection_id(int newItemCollection_id) {
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
