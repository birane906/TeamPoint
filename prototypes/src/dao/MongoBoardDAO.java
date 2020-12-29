/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import dao.ColumnDAO;
import dao.UserDAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of MongoBoardDAO.
 * 
 * @author 
 */
public class MongoBoardDAO extends UserDAOColumnDAO {
	// Start of user code (user defined attributes for MongoBoardDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public MongoBoardDAO() {
		// Start of user code constructor for MongoBoardDAO)
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

	/**
	 * Description of the method addColumn.
	 * @param columnName 
	 * @param board 
	 * @param typeName 
	 * @return 
	 */
	public Board addColumn(String columnName, Board board, String typeName) {
		// Start of user code for method addColumn
		Board addColumn = null;
		return addColumn;
		// End of user code
	}

	/**
	 * Description of the method deleteColumn.
	 * @param column 
	 * @return 
	 */
	public Boolean deleteColumn(Column column) {
		// Start of user code for method deleteColumn
		Boolean deleteColumn = Boolean.FALSE;
		return deleteColumn;
		// End of user code
	}

	/**
	 * Description of the method getAllColumnTypes.
	 * @return 
	 */
	public Object getAllColumnTypes() {
		// Start of user code for method getAllColumnTypes
		// End of user code
	}

	// Start of user code (user defined methods for MongoBoardDAO)

	// End of user code

}
