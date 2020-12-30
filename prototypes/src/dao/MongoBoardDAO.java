/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Permission;
import business_logic.user.User;
// Start of user code (user defined imports)
import business_logic.workspace.Workspace;

// End of user code

/**
 * Description of MongoBoardDAO.
 * 
 * @author 
 */
public class MongoBoardDAO extends BoardDAO {
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
		return null;
		// Start of user code for method getAllColumnTypes
		// End of user code
	}

	@Override
	public Board addBoard(String name, Workspace workspace, User user, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board retrieveBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addItemCollection(String itemCollectionName, Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addItem(ItemCollection itemCollection, String itemLabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	// Start of user code (user defined methods for MongoBoardDAO)

	// End of user code

}
