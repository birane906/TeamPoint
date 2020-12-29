/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.AbstractUserAttendance;
import business_logic.user.User;
import business_logic.workspace.Workspace;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoUserAttendanceDAO.
 * 
 * @author Raphael
 */
public class MongoUserAttendanceDAO extends UserAttendanceDAO {
	// Start of user code (user defined attributes for MongoUserAttendanceDAO)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public MongoUserAttendanceDAO() {
		// Start of user code constructor for MongoUserAttendanceDAO)
		super();
		// End of user code
	}
	
	/**
	 * Description of the method createUserAttendance.
	 * @param workspace 
	 * @param user 
	 * @param attendance 
	 * @return 
	 */
	public AbstractUserAttendance createUserAttendance(Workspace workspace, User user, String attendance) {
		// Start of user code for method createUserAttendance
		AbstractUserAttendance createUserAttendance = null;
		return createUserAttendance;
		// End of user code
	}
	 
	/**
	 * Description of the method deleteUserAttendance.
	 * @param userAttendance 
	 * @return 
	 */
	public Boolean deleteUserAttendance(AbstractUserAttendance userAttendance) {
		// Start of user code for method deleteUserAttendance
		Boolean deleteUserAttendance = Boolean.FALSE;
		return deleteUserAttendance;
		// End of user code
	}
	 
	// Start of user code (user defined methods for MongoUserAttendanceDAO)
	
	// End of user code


}
