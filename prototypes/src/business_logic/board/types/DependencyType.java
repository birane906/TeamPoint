package business_logic.board.types;

import java.util.HashSet;
import java.util.Set;

import business_logic.board.Item;

/**
 * Description of DependencyType.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class DependencyType extends Type  {
	/**
	 * The items that must be completed before the current item
	 */
	public Set<Item> items = new HashSet<Item>();

	/**
	 * Constructor  for empty {@link DependencyType}
	 *
	 * @param id
	 * @param description
	 */
	public DependencyType(int id, String description) {
		super(id, DependencyType.class.getSimpleName(), description);
		items = new HashSet<Item>();
	}

	/**
	 * Constructor  for empty {@link DependencyType}
	 * @param id
	 * @param description
	 * @param items
	 */
	public DependencyType(int id, String description, Set<Item> items) {
		super(id, DependencyType.class.getSimpleName(), description);
		this.items = items;
	}

    public DependencyType(Item item) {
        super(DependencyType.class.getSimpleName(), "User");
        this.addItem(item);
    }

    /**
	 * Description of the method addItem.
	 * @param item 
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}
	 
	/**
	 * Description of the method removeItem.
	 * @param item 
	 */
	public void removeItem(Item item) {
		this.items.remove(item);
	}

	/**
	 * Returns items.
	 * @return items 
	 */
	public Set<Item> getItems() {
		return this.items;
	}
}
