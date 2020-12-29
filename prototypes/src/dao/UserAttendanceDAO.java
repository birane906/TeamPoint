/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.AbstractUserAttendance;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.DAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserAttendanceDAO.
 * 
 * @author Raphael
 */
public abstract class UserAttendanceDAO implements DAO {
	// Start of user code (user defined attributes for UserAttendanceDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserAttendanceDAO() {
		// Start of user code constructor for UserAttendanceDAO)
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
	public abstract AbstractUserAttendance createUserAttendance(Workspace workspace, User user, String attendance);

	/**
	 * Description of the method deleteUserAttendance.
	 * @param userAttendance 
	 * @return 
	 */
	public abstract Boolean deleteUserAttendance(AbstractUserAttendance userAttendance);
	 
	// Start of user code (user defined methods for UserAttendanceDAO)
	
	// End of user code


}
