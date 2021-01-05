package dao.factory;

import dao.*;
import dao.mySQL.*;

/**
 * Concrete Factory for MySQLDAO products.
 * Implements the {@link DAOFactory} interface
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class MySQLDAOFactory extends DAOFactory {
	
	/**
	 * The constructor.
	 */
	public MySQLDAOFactory() {}

	/**
	 * Creates a {@link UserDAO} object
	 * @return Returns a {@link UserDAO}
	 */
	public UserDAO createUserDAO() {
		return new MySQLUserDAO();
	}

	/**
	 * Creates a {@link BoardDAO} object
	 * @return Returns a {@link BoardDAO}
	 */
	@Override
	public BoardDAO createBoardDAO() {
		return new MySQLBoardDAO();
	}

	/**
	 * Creates a {@link WorkspaceDAO} object
	 * @return Returns a {@link WorkspaceDAO}
	 */
	@Override
	public WorkspaceDAO createWorkspaceDAO() {
		return new MySQLWorkspaceDAO();
	}

	/**
	 * Creates a {@link ColumnDAO} object
	 * @return Returns a {@link ColumnDAO}
	 */
	@Override
	public ColumnDAO createColumnDAO() {
		return new MySQLColumnDAO();
	}

	@Override
	public CellDAO createCellDAO(){ return new MySQLCellDAO(); }

	@Override
	public InvitationDAO createInvitationDAO() {
		return new MySQLInvitationDAO();
	}
}
