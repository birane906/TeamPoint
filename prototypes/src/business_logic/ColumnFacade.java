/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.board.types.Type;
import business_logic.board.Board;
import business_logic.board.Column;
import dao.ColumnDAO;
import dao.DAOFactory;

import java.util.ArrayList;

/**
 * {@link ColumnFacade} is a Singleton class. Simplify the use of
 * business logic subsystem for the GUI layer. Facade pattern.
 * Contains the business methods.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class ColumnFacade {
	/**
	 * The current {@link Column} loaded in the {@link ColumnFacade}
	 */
	public Column currentColumn = null;

	/**
	 * private constructor
	 */
	private ColumnFacade() {}

	/**
	 * The {@link ColumnFacade} <code>static</code> nested class
	 * guarantees the uniqueness of {@link ColumnFacade} instance
	 */
	private static class ColumnFacadeHolder {
		/**
		 * The unique instance of {@link ColumnFacade}
		 */
		private static final ColumnFacade COLUMN_FACADE = new ColumnFacade();
	}

	/**
	 * <code>static</code> method. Gives the unique instance of {@link ColumnFacade}
	 * @return The {@link ColumnFacade}
	 */
	public static ColumnFacade getColumnFacadeInstance() { return ColumnFacadeHolder.COLUMN_FACADE;	}

	/**
	 * Asks for {@link ColumnDAO} to create a {@link Column} in the given {@link Board}
	 * @param columnName The name of the new created {@link Column}
	 * @param board The {@link Board} of the created {@link Column}
	 * @param typeName The string description of the {@link Type} of the new created {@link Column}
	 * @return 
	 */
	public Boolean addColumn(String columnName, Board board, String typeName) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		ColumnDAO columnDAO = daoFactory.createColumnDAO();

		Column column = columnDAO.addColumn(columnName, board, typeName);

		if (column != null) {
			BoardFacade boardFacade = BoardFacade.getBoardFacadeInstance();
			boardFacade.getCurrentBoard().addColumn(column);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Asks for {@link ColumnDAO} to retrieve all the {@link Type} of the {@link Column}s
	 * @return An {@link ArrayList} of the {@link Type} of the {@link Column}s
	 */
	public ArrayList<Type> retrieveColumnTypes() {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		ColumnDAO columnDAO = daoFactory.createColumnDAO();

		return columnDAO.getAllColumnTypes();
	}

	/**
	 * Asks for {@link ColumnDAO} to delete a {@link Column}
	 * @param column The {@link Column} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteColumn(Column column) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		ColumnDAO columnDAO = daoFactory.createColumnDAO();

		return columnDAO.deleteColumn(column);
	}

	/**
	 * Asks for {@link ColumnDAO} to retrieve all the {@link Type} of one {@link Column}
	 * @param column The given {@link Column}
	 * @return A string representation of the {@link Type} of the {@link Column}
	 */
	public String getColumnType(Column column) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		ColumnDAO columnDAO = daoFactory.createColumnDAO();

		return columnDAO.getColumnType(column).getNameType();
	}

	/**
	 * @return The current column held by the {@link ColumnFacade}
	 */
	public Column getCurrentColumn() {
		return this.currentColumn;
	}

}
