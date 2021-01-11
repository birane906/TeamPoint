/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board.types;

import java.util.Date;

/**
 * Description of DateType.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class DateType extends Type {

	/**
	 * A {@link Date}
	 */
	private Date date;

	/**
	 * Constructor for empty date 
	 * @param id an int
	 * @param description the type description
	 */
	public DateType(int id, String description) {
		super(id, DateType.class.getSimpleName(), description);
		this.date = null;
	}

	/**
	 * Constructor for filled date
	 * @param id an int
	 * @param description the type description
	 * @param date {@link Date} instance
	 */
	public DateType(int id, String description, Date date) {
		super(id, DateType.class.getSimpleName(), description);
		this.date = date;
	}

	public DateType(Date date) {
		super(DateType.class.getSimpleName(), "date");
		this.date = date;
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

	public String toString(){
		return this.date.toString();
	}

}
