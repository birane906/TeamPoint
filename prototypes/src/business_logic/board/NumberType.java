/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of NumberType.
 * 
 * @author 
 */
public class NumberType extends AbstractType {
	/**
	 * Description of the property unit.
	 */
	private String unit = "";

	/**
	 * The constructor.
	 *
	 * @param id
	 * @param nameType
	 * @param description
	 */
	public NumberType(int id, String nameType, String description) {
		super(id, nameType, description);
	}

	// Start of user code (user defined attributes for NumberType)
	
	// End of user code
	
	
	// Start of user code (user defined methods for NumberType)
	
	// End of user code
	/**
	 * Returns unit.
	 * @return unit 
	 */
	public String getUnit() {
		return this.unit;
	}
	
	/**
	 * Sets a value to attribute unit. 
	 * @param newUnit 
	 */
	public void setUnit(String newUnit) {
	    this.unit = newUnit;
	}



}
