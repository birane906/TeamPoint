package business_logic.board;

import java.util.ArrayList;
import java.util.List;
/**
 * Description of ItemCollection.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class ItemCollection {

	/**
	 * Description of the property itemCollection_id.
	 */
	public int itemCollection_id;

	/**
	 * Description of the property name.
	 */
	private String name;

	/**
	 * Description of the property parentBoard.
	 */
	public Board parentBoard;

	/**
	 * Description of the property items.
	 */
	public List<Item> items;

	/**
	 * Constructor for empty ItemCollection
	 * @param name
	 * @param id
	 * @param parentBoard
	 */
	public ItemCollection(String name, int id, Board parentBoard) {
		this.itemCollection_id = id;
		this.name = name;
		this.parentBoard = parentBoard;
		this.items = new ArrayList<>();
	}
	
	/**
	 * Constructor for ItemCollection with items
	 * @param name
	 * @param id
	 * @param parentBoard
	 * @param items
	 */
	public ItemCollection(String name, int id, Board parentBoard, List<Item> items) {
		this.itemCollection_id = id;
		this.name = name;
		this.parentBoard = parentBoard;
		this.items = items;
	}

	/**
	 * Adds an item to the collection
	 * @param item 
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	public  void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * Deletes an item form the collection
	 * @param item 
	 */
	public void deleteItem(Item item) {
		items.remove(item);
	}

	/**
	 * Returns itemCollection_id.
	 * @return itemCollection_id 
	 */
	public int getItemCollection_id() {
		return this.itemCollection_id;
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
	public List<Item> getItems() {
		return this.items;
	}

}
