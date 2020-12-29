/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

import business_logic.workspace.Workspace;

import java.util.Date;

import business_logic.board.Board;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
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
	 * Description of the method addBoard.
	 * @param name 
	 * @param workspace 
	 * @param user 
	 * @return 
	 */
	public abstract Board addBoard(String name, Workspace workspace, User user);

	/**
	 * Description of the method deleteBoard.
	 * @param board 
	 * @return 
	 */
	public abstract Boolean deleteBoard(Board board);

	/**
	 * Description of the method retrieveBoard.
	 * @param board 
	 * @return 
	 */
	public abstract Board retrieveBoard(Board board);

	/**
	 * Description of the method addItemCollection.
	 * @param itemCollectionName 
	 * @param board 
	 * @return 
	 */
	public abstract Boolean addItemCollection(String itemCollectionName, Board board);

	/**
	 * Description of the method deleteItemCollection.
	 * @param itemCollection 
	 * @return 
	 */
	public abstract Boolean deleteItemCollection(ItemCollection itemCollection);

	/**
	 * Description of the method addItem.
	 * @param itemCollection 
	 * @param itemLabel 
	 * @return 
	 */
	public abstract Boolean addItem(ItemCollection itemCollection, String itemLabel);

	/**
	 * Description of the method deleteItem.
	 * @param item 
	 * @return 
	 */
	public abstract Boolean deleteItem(Item item);

	/**
	 * Description of the method dateFormat.
	 * @param date 
	 * @return 
	 */
	public String dateFormat(Date date) {
		// Start of user code for method dateFormat
		String dateFormat = "";
		return dateFormat;
		// End of user code
	}

	/**
	 * Description of the method stringFormat.
	 * @param string 
	 * @return 
	 */
	public String stringFormat(String string) {
		// Start of user code for method stringFormat
		String stringFormat = "";
		return stringFormat;
		// End of user code
	}

	// Start of user code (user defined methods for BoardDAO)

	// End of user code

}
