/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.BoardFacade;
import business_logic.Workspace.Workspace;
import business_logic.board.Board;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of BoardFacade.
 * 
 * @author 
 */
public class BoardFacade {
	/**
	 * Description of the property currentBoard.
	 */
	public Board currentBoard = null;

	// Start of user code (user defined attributes for BoardFacade)

	// End of user code

	/**
	 * The constructor.
	 */
	public BoardFacade() {
		// Start of user code constructor for BoardFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method getBoardFacadeInstance.
	 * @return 
	 */
	public static BoardFacade getBoardFacadeInstance() {
		// Start of user code for method getBoardFacadeInstance
		BoardFacade getBoardFacadeInstance = null;
		return getBoardFacadeInstance;
		// End of user code
	}

	/**
	 * Description of the method createBoard.
	 * @param name 
	 * @param workspace 
	 * @return 
	 */
	public Boolean createBoard(String name, Workspace workspace) {
		// Start of user code for method createBoard
		Boolean createBoard = Boolean.FALSE;
		return createBoard;
		// End of user code
	}

	/**
	 * Description of the method deleteBoard.
	 * @param board 
	 * @return 
	 */
	public Boolean deleteBoard(Board board) {
		// Start of user code for method deleteBoard
		Boolean deleteBoard = Boolean.FALSE;
		return deleteBoard;
		// End of user code
	}

	/**
	 * Description of the method retrieveBoard.
	 * @param board 
	 * @return 
	 */
	public Boolean retrieveBoard(Board board) {
		// Start of user code for method retrieveBoard
		Boolean retrieveBoard = Boolean.FALSE;
		return retrieveBoard;
		// End of user code
	}

	/**
	 * Description of the method addItemCollection.
	 * @param itemCollection 
	 * @return 
	 */
	public Boolean addItemCollection(ItemCollection itemCollection) {
		// Start of user code for method addItemCollection
		Boolean addItemCollection = Boolean.FALSE;
		return addItemCollection;
		// End of user code
	}

	/**
	 * Description of the method deleteItemCollection.
	 * @param itemCollection 
	 * @return 
	 */
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		// Start of user code for method deleteItemCollection
		Boolean deleteItemCollection = Boolean.FALSE;
		return deleteItemCollection;
		// End of user code
	}

	/**
	 * Description of the method addItem.
	 * @param itemLabel 
	 * @param itemCollection 
	 * @return 
	 */
	public Boolean addItem(String itemLabel, ItemCollection itemCollection) {
		// Start of user code for method addItem
		Boolean addItem = Boolean.FALSE;
		return addItem;
		// End of user code
	}

	/**
	 * Description of the method deleteItem.
	 * @param item 
	 * @return 
	 */
	public Boolean deleteItem(Item item) {
		// Start of user code for method deleteItem
		Boolean deleteItem = Boolean.FALSE;
		return deleteItem;
		// End of user code
	}

	// Start of user code (user defined methods for BoardFacade)

	// End of user code
	/**
	 * Returns currentBoard.
	 * @return currentBoard 
	 */
	public Board getCurrentBoard() {
		return this.currentBoard;
	}

	/**
	 * Sets a value to attribute currentBoard. 
	 * @param newCurrentBoard 
	 */
	public void setCurrentBoard(Board newCurrentBoard) {
		if (this.currentBoard != null) {
			this.currentBoard.set(null);
		}
		this.currentBoard.set(this);
	}

}
