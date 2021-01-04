package business_logic;

import business_logic.board.*;
import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.BoardDAO;
import dao.CellDAO;
import dao.DAOFactory;

/**
 * {@link BoardFacade} is a Singleton class. Simplify the use of
 * business logic subsystem for the GUI layer. Facade pattern.
 * Contains the business methods.
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
		if (name.isBlank() || workspace == null) {
			return false;
		}

        DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();

        UserFacade userFacade = UserFacade.getUserFacadeInstance();
        User user  = userFacade.getCurrentUser();

        BoardDAO boardDAO = daoFactory.createBoardDAO();

        Permission permission = boardDAO.getDefaultPermission();

        Board board = boardDAO.addBoard(name, workspace, user, permission);

		if (board != null) {
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
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();
		
		return boardDAO.deleteBoard(board);
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
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
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
		if (itemCollectionName.isBlank() || board == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.addItemCollection(itemCollectionName, board);

	}

	/**
	 * Asks for {@link BoardDAO} to delete an {@link ItemCollection}
	 * @param itemCollection The {@link ItemCollection} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteItemCollection(ItemCollection itemCollection) {
		if (itemCollection == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.deleteItemCollection(itemCollection);
	}

	/**
	 * Asks for {@link BoardDAO} to create an {@link Item}
	 * @param itemLabel The new {@link Item}'s name. Can't be blank
	 * @param itemCollection The {@link ItemCollection} to which belongs the created {@link Item}
	 * @return <code>true</code> if the creation succeed, <code>false</code> otherwise
	 */
	public Boolean addItem(String itemLabel, ItemCollection itemCollection) {
		if (itemLabel.isBlank() || itemCollection == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.addItem(itemCollection, itemLabel);

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
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		BoardDAO boardDAO = daoFactory.createBoardDAO();

		return boardDAO.deleteItem(item);
	}

	/**
	 * @return The current board held by the {@link BoardFacade}
	 */
	public Board getCurrentBoard() {
		return this.currentBoard;
	}

}
