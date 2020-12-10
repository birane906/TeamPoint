/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * DAO interface
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public interface DAO<T> {
	
	/**
	 * Creates the given object in the database.
	 * (Insert query)
	 * @param obj The object data structure must exist in the database 
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code> 
	 */
	public Boolean create(T obj);

	/**
	 * Removes the data corresponding to this object form the database.
	 * (Delete Query)
	 * @param obj The object data structure must exist in the database 
	 * @return Returns <code>true</code> if the operation succeed otherwise <code>false</code>
	 */
	public Boolean delete(T obj);
	
	/**
	 *  
	 * @param date from Date java package
	 * @return the correct String format according to SQL "yyyy-mm-dd"
	 */
	public static String dateFormat(Date date) {
		
		if(date == null) {
			return null;
		}
		
		// The ZoneId here has no implication since we only keep the year, month and day
		ZonedDateTime localDate = date.toInstant().atZone(ZoneId.of("Europe/Paris"));
		
		Integer year = localDate.getYear(); // Year
		String dateFormat = year.toString();
		dateFormat += "-";
		dateFormat += localDate.getMonthValue(); // Month
		dateFormat += "-";
		dateFormat += localDate.getDayOfMonth(); // Day
		
		return dateFormat;
	}
	
	/**
	 * @param String str
	 * @return a null pointer if str null, if not null return 'str'
	 */
	public static String nullStringFormat(String str) {
		
		if(str == null) {
			return null;
		}
		
		return "\"" + str + "\"";
	}

}