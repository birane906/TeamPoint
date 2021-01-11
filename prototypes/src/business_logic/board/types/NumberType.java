package business_logic.board.types;

/**
 * Description of NumberType.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class NumberType extends Type {
	/**
	 * The unit as {@link String}
	 */
	private String unit;

	/**
	 * The value as {@link Integer}
	 */
	private Integer value;

	/**
	 * Constructor for empty NumberType
	 *
	 * @param id {@link NumberType}
	 * @param description {@link String} description of this type 
	 */
	public NumberType(int id, String description) {
		super(id, NumberType.class.getSimpleName(), description);
		value = null;
		unit = "";
	}

	/**
	 * Constructor for filled NumberType
	 * @param id {@link NumberType}
	 * @param description {@link String} description of this type 
	 * @param unit {@link String} the unit used for this value 
	 * @param value {@link Integer} is the value of the {@link NumberType}
	 */
	public NumberType(int id, String description, String unit, Integer value){
		super(id, NumberType.class.getSimpleName(), description);
		this.unit = unit;
		this.value = value;
	}

	public NumberType(String unit, Integer value){
		super(NumberType.class.getSimpleName(), "Number");
		this.unit = unit;
		this.value = value;
	}

	/**
	 * Constructor for filled {@link NumberType} without unit
	 * @param id {@link NumberType}
	 * @param description {@link String} description of this type 
	 * @param value {@link Integer} is the value of the {@link NumberType}
	 */
	public NumberType(int id, String description, Integer value){
		super(id, NumberType.class.getSimpleName(), description);
		this.unit = "";
		this.value = value;
	}

	/**
	 * Constructor for empty NumberType with unit
	 * @param id {@link NumberType}
	 * @param description {@link String} description of this type
	 * @param unit {@link String} the unit used for this value
	 */
	public NumberType(int id, String description, String unit){
		super(id, NumberType.class.getSimpleName(), description);
		this.unit = "";
	}

	/**
	 * Returns unit
	 * @return unit 
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Sets a value to attribute unit. 
	 * @param newUnit of the type
	 */
	public void setUnit(String newUnit) {
	    this.unit = newUnit;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String toString() {
		return getValue() + " " + getUnit();
	}
}
