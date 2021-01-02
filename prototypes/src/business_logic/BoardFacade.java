/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

/**
 * {@link BoardFacade} is a Singleton class. Simplify the use of
 * buisness logic subsystem for the GUI layer. Facade pattern.
 * Contains the buisness methods.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class BoardFacade {

	/**
	 * The current {@link Board} loaded in the {@link BoardFacade}
	 */
	public Board currentBoard = null;

	/**
	 * private constructor
	 */
	private BoardFacade() {}

	/**
	 * The {@link BoardFacade} <code>static</code> nested class
	 * guarantees the uniqueness of {@link BoardFacade} instance
	 */
	private static class BoardFacadeHolder {
		/**
		 * The unique instance of {@link BoardFacade}
		 */
		private static final BoardFacade BOARD_FACADE = new BoardFacade();
	}

	/**
	 * <code>static</code> method. Gives the unique instance of {@link BoardFacade}
	 * @return The {@link BoardFacade}
	 */
	public static BoardFacade getBoardFacadeInstance() {
		return BoardFacadeHolder.BOARD_FACADE;
	}

	/**
	 * Asks for {@link BoardDAO} to create a {@link Board}
	 * @param name The new {@link Board}'s name. Can't be blank
	 * @param workspace The {@link Workspace} to which belongs the created {@link Board}
	 * @return <code>true</code> if the creation succeed, <code>false</code> otherwise
	 */
	public Boolean createBoard(String name, Workspace workspace) {
		if (name.isBlank() or workspace == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		board = boardDAO.createBoard(name, workspace);

		if (boardDAO != null) {
			currentBoard = board;
			return true;
		}
		else {
			return false;
		}

	}

	/**
	 * Asks for {@link BoardDAO} to delete a {@link Board}
	 * @param board The {@link Board} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteBoard(Board board) {
		if (board == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();
		
		return boardDAO.deleteBoard(board)
	}

	/**
	 * Asks for {@link BoardDAO} to load a {@link Board} in the <code>currentBoard</code> of the {@link BoardFacade}
	 * @param board The {@link Board} to be loaded
	 * @return <code>true</code> if the load succeed, <code>false</code> otherwise
	 */
	public Boolean retrieveBoard(Board board) {
		if (board == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		board = boardDAO.retrieveBoard(board);

		if (board != null) {
			currentBoard = board;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link BoardDAO} to create an {@link ItemCollection}
	 * @param itemCollectionName The new {@link ItemCollection}'s name. Can't be blank
	 * @param board The {@link Board} to which belongs the created {@link ItemCollection}
	 * @return <code>true</code> if the creation succeed, <code>false</code> otherwise
	 */
	public Boolean addItemCollection(String itemCollectionName, Board board) {
		if (itemCollectionName.isBlank() or board == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		ItemCollection itemCollection = boardDAO.addItemCollection(itemCollectionName, board);

		if (itemCollection != null) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link BoardDAO} to delete an {@link ItemColection}
	 * @param itemCollection The {@link ItemCollection} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		if (itemCollection == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.deleteItemCollection(itemCollection);
	}

	/**
	 * Asks for {@link BoardDAO} to create an {@link Item}
	 * @param item The new {@link Item}'s name. Can't be blank
	 * @param itemCollection The {@link ItemCollection} to which belongs the created {@link Item}
	 * @return <code>true</code> if the creation succeed, <code>false</code> otherwise
	 */
	public Boolean addItem(String itemLabel, ItemCollection itemCollection) {
		if (itemLabel.isBlank() or itemCollection == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		Item item = boardDAO.addItem(itemLabel, itemCollection);

		if (item != null) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link BoardDAO} to delete an {@link Item}
	 * @param item The {@link Item} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteItem(Item item) {
		if (item == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.deleteItem(item);
	}

	/**
	 * @return The current board holded by the {@link BoardFacade}
	 */
	public Board getCurrentBoard() {
		return this.currentBoard;
	}

}
