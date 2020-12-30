/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

// Start of user code (user defined imports)

// End of user code

import java.util.Date;

/**
 * Description of DateType.
 * 
 * @author 
 */
public class DateType extends AbstractType {
	/**
	 * Description of the property date.
	 */
	private Date date = new Date();

	/**
	 * The constructor.
	 *
	 * @param id
	 * @param nameType
	 * @param description
	 */
	public DateType(int id, String nameType, String description) {
		super(id, nameType, description);
	}

	// Start of user code (user defined attributes for DateType)
	
	// End of user code
	
	
	// Start of user code (user defined methods for DateType)
	
	// End of user code
	/**
	 * Returns date.
	 * @return date 
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * Sets a value to attribute date. 
	 * @param newDate 
	 */
	public void setDate(Date newDate) {
	    this.date = newDate;
	}



}
