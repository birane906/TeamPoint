/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;

import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.types.Type;
import dao.CellDAO;
import dao.DAOFactory;

/**
 * {@link CellFacade} is a Singleton class. Simplify the use of
 * business logic subsystem for the GUI layer. Facade pattern.
 * Contains the business methods.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class CellFacade {

	/**
	 * private constructor
	 */
	private CellFacade() {}

	/**
	 * The {@link CellFacade} <code>static</code> nested class
	 * guarantees the uniqueness of {@link CellFacade} instance
	 */
	private static class CellFacadeHolder {
		/**
		 * The unique instance of {@link CellFacade}
		 */
		private static final CellFacade CELL_FACADE = new CellFacade();
	}

	/**
	 * <code>static</code> method. Gives the unique instance of {@link CellFacade}
	 * @return The {@link CellFacade}
	 */
	public static CellFacade getCellFacadeFacadeInstance() {
		return CellFacadeHolder.CELL_FACADE;
	}

	/**
	 * Asks for {@link CellDAO} to create a {@link Cell}
	 * @param column The new {@link Column} of the created {@link Cell}
	 * @param item The {@link Item} of the created {@link Cell}
	 * @param value The {@link business_logic.board.types.Type} value of the created {@link Cell}
	 * @return The newly created {@link Cell}, is <code>null</code> id creation failed
	 */
	public Cell<? extends Type> addCell(Column<? extends Type> column, Item item, Type value) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		CellDAO cellDAO = daoFactory.createCellDAO();

		return cellDAO.addCell(column, item, value);
	}

	/**
	 * Asks for {@link CellDAO} to create a {@link Cell}
	 * @param cell The {@link Cell} to be deleted
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise
	 */
	public Boolean deleteCell(Cell<? extends Type> cell) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		CellDAO cellDAO = daoFactory.createCellDAO();

		return cellDAO.deleteCell(cell);
	}

	/**
	 * Asks for {@link dao.CellDAO} to edit th value of a {@link Cell}
	 * @param cell The {@link Cell} to be edited
	 * @param value The new value of the {@link Cell}
	 * @return <code>true</code> if the edition succeed, <code>false</code> otherwise
	 */
	public Boolean editCell(Cell<? extends Type> cell, Type value) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		CellDAO cellDAO = daoFactory.createCellDAO();

		return cellDAO.editCell(cell, value);
	}

	/**
	 * Asks for {@link dao.CellDAO} to clear th value of a {@link Cell}
	 * @param cell The {@link Cell} to be edited
	 * @return <code>true</code> if the clearance succeed, <code>false</code> otherwise
	 */
	public Boolean clearCell(Cell<? extends Type> cell) {
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		CellDAO cellDAO = daoFactory.createCellDAO();

		return cellDAO.editCell(cell, null);
	}


}
