/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.workspace.Workspace;

import business_logic.board.Board;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Permission;
import business_logic.user.User;
import dao.DAO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of BoardDAO.
 * 
 * @author 
 */
public abstract class BoardDAO implements DAO {
	// Start of user code (user defined attributes for BoardDAO)

	// End of user code

	/**
	 * The constructor.
	 */
	public BoardDAO() {
		// Start of user code constructor for BoardDAO)
		super();
		// End of user code
	}

	/**
	 * Creates board in database.
	 * @param name of the board
	 * @param workspace where the user creates the board
	 * @param user is the board owner, must be the one who creates it
	 * @return 
	 */
	public abstract Board addBoard(String name, Workspace workspace, User user, Permission permission);

	/**
	 * delete the board in the database.
	 * @param board that will be deleted
	 * @return true or false according to success of deletion
	 */
	public abstract Boolean deleteBoard(Board board);

	/**
	 * Retrieve the board given.
	 * @param board that will be retrieved
	 * @return the board updated according to the one in the database
	 */
	public abstract Board retrieveBoard(Board board);

	/**
	 * add item collection to a board.
	 * @param itemCollectionName name of the item collection
	 * @param board where we want the collection to be in
	 * @return a boolean according to the success of insert
	 */
	public abstract Boolean addItemCollection(String itemCollectionName, Board board);

	/**
	 * delete Item Collection.
	 * @param itemCollection 
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteItemCollection(ItemCollection itemCollection);

	/**
	 * add Item.
	 * @param itemCollection the item collection we want the item to be in 
	 * @param itemLabel the name of the item
	 * @return a boolean according to the success of insert
	 */
	public abstract Boolean addItem(ItemCollection itemCollection, String itemLabel);

	/**
	 * Description of the method deleteItem.
	 * @param item to be inserted
	 * @return a boolean according to the success of delete
	 */
	public abstract Boolean deleteItem(Item item);

	// Start of user code (user defined methods for BoardDAO)

	// End of user code

}
