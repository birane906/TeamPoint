/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;

invalid
// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimelineType.
 * 
 * @author 
 */
public class TimelineType extends AbstractType implements  {
	/**
	 * Description of the property startDate.
	 */
	private Date startDate = new Date();
	
	/**
	 * Description of the property endDate.
	 */
	private Date endDate = new Date();
	
	// Start of user code (user defined attributes for TimelineType)
	
	// End of user code
	
	
	// Start of user code (user defined methods for TimelineType)
	
	// End of user code
	/**
	 * Returns startDate.
	 * @return startDate 
	 */
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Sets a value to attribute startDate. 
	 * @param newStartDate 
	 */
	public void setStartDate(Date newStartDate) {
	    this.startDate = newStartDate;
	}

	/**
	 * Returns endDate.
	 * @return endDate 
	 */
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * Sets a value to attribute endDate. 
	 * @param newEndDate 
	 */
	public void setEndDate(Date newEndDate) {
	    this.endDate = newEndDate;
	}



}
