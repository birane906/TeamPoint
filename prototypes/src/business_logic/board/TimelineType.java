/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.board;
import java.util.Date;

/**
 * Type used in a {@link Column} to specify a duration between a start date and an end date
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class TimelineType extends AbstractType  {
	/**
	 * Starting {@link Date} of the {@link TimelineType}
	 */
	private Date startDate;
	
	/**
	 * Ending {@link Date} of the {@link TimelineType}
	 */
	private Date endDate;

	/**
	 * Create a new {@link TimelineType} giving 2 {@link Date}
	 * @param startDate The starting {@link Date} of the {@link TimelineType}
	 * @param endDate The ending {@link Date} of the {@link TimelineType}
	 */
	public TimelineType(Date startDate, Date endDate, int id, String nameType, String description) {
		super(id, nameType, description);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return The starting {@link Date} of the {@link TimelineType}.
	 */
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * Sets the starting {@link Date} of the {@link TimelineType}
	 * @param startDate The new starting {@link Date}
	 */
	public void setStartDate(Date startDate) {
	    this.startDate = startDate;
	}

	/**
	 * Return the ending {@link Date} of the {@link TimelineType}.
	 * @return endDate 
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Sets the ending {@link Date} of the {@link TimelineType}
	 * @param endDate The new ending {@link Date}
	 */
	public void setEndDate(Date endDate) {
	    this.endDate = endDate;
	}

}
