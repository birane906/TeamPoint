/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.user.User;
import dao.CellDAO;
import dao.UserDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoCellDAO.
 * 
 * @author 
 */
public class MongoCellDAO extends CellDAO {
	// Start of user code (user defined attributes for MongoCellDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MongoCellDAO() {
		// Start of user code constructor for MongoCellDAO)
		super();
		// End of user code
	}

	/**
	 * Description of the method getUser.
	 * @param email 
	 * @param password 
	 * @return 
	 */
	public User getUser(String email, String password) {
		// Start of user code for method getUser
		User getUser = null;
		return getUser;
		// End of user code
	}

	/**
	 * Description of the method delete.
	 * @param email 
	 * @return 
	 */
	public Boolean delete(String email) {
		// Start of user code for method delete
		Boolean delete = Boolean.FALSE;
		return delete;
		// End of user code
	}

	/**
	 * Description of the method signup.
	 * @param name 
	 * @param firstName 
	 * @param email 
	 * @param password 
	 * @return 
	 */
	public User signup(String name, String firstName, String email, String password) {
		// Start of user code for method signup
		User signup = null;
		return signup;
		// End of user code
	}

	// Start of user code (user defined methods for MongoCellDAO)

	// End of user code

}
