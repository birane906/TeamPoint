package business_logic.board;


import java.util.HashSet;

/**
 * Description of DependencyType.
 * 
 * @author 
 */
public class DependencyType extends AbstractType  {
	/**
	 * Description of the property items.
	 */
	public HashSet<Item> items = new HashSet<Item>();

	/**
	 * The constructor.
	 *
	 * @param id
	 * @param nameType
	 * @param description
	 */
	public DependencyType(int id, String nameType, String description) {
		super(id, nameType, description);
	}


	/**
	 * Description of the method addItem.
	 * @param item 
	 */
	public void addItem(Item item) {
	}
	 
	/**
	 * Description of the method removeItem.
	 * @param item 
	 */
	public void removeItem(Item item) {
	}

	/**
	 * Returns items.
	 * @return items 
	 */
	public HashSet<Item> getItems() {
		return this.items;
	}



}
