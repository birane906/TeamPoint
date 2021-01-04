/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

import java.util.Date;

/**
 * Description of DateType.
 * 
 * @author 
 */
public class DateType extends Type {
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
