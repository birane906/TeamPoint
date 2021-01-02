/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates a {@link WorkspaceDAO} object
	 * @return Returns a {@link WorkspaceDAO}
	 */
	@Override
	public WorkspaceDAO createWorkspaceDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates a {@link ColumnDAO} object
	 * @return Returns a {@link ColumnDAO}
	 */
	@Override
	public ColumnDAO createColumnDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvitationDAO createInvitationDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
