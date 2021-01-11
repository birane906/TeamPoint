package business_logic.board.types;
import java.util.Date;

/**
 * Type used in a to specify a duration between a start date and an end date
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class TimelineType extends Type  {
	/**
	 * Starting {@link Date} of the {@link TimelineType}
	 */
	private Date startDate;
	
	/**
	 * Ending {@link Date} of the {@link TimelineType}
	 */
	private Date endDate;

	/**
	 * Create a new empty {@link TimelineType} giving 2 {@link Date}
	 * Precondition : d1 < d2
	 * @param id of the type
	 * @param description of the type
	 * @param d1 The starting {@link Date} of the {@link TimelineType}
	 * @param d2 The ending {@link Date} of the {@link TimelineType}
	 */
	public TimelineType(int id, String description, Date d1, Date d2) throws IllegalArgumentException {
		super(id, TimelineType.class.getSimpleName(), description);
		this.startDate = null;
		this.endDate = null;
	}

	public TimelineType(Date startDate, Date endDate) {
		super(TimelineType.class.getSimpleName(), "Two date");
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * Constructor for empty {@link TimelineType} 
	 * @param id of the type
	 * @param description of the type
	 */
	public TimelineType(int id, String description) {
		super(id, TimelineType.class.getSimpleName(), description);
		this.startDate = null;
		this.endDate = null;
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

	public String toString() {
		return startDate + ">" + endDate;
	}

}
