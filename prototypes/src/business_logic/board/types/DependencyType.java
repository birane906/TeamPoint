package business_logic.board.types;

import business_logic.board.Item;

import java.util.HashSet;
import java.util.Set;

/**
 * Description of DependencyType.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class DependencyType extends Type  {
	/**
	 * The items that must be completed before the current item
	 */
	public Set<Item> items = new HashSet<>();

	/**
	 * Constructor  for empty {@link DependencyType}
	 *
	 * @param id of the type
	 * @param description of the type
	 */
	public DependencyType(int id, String description) {
		super(id, DependencyType.class.getSimpleName(), description);
		items = new HashSet<>();
	}

	/**
	 * Constructor  for empty {@link DependencyType}
	 * @param id of the type
	 * @param description of the type
	 * @param items that depends on the types
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
	 * @param item of the type
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}
	 
	/**
	 * Description of the method removeItem.
	 * @param item of the type
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

	public String toString() {
		StringBuilder rep = new StringBuilder();

		for (Item item : this.items) {
			rep.append(item.toString()).append("; ");
		}
		return rep.toString();
	}
}
