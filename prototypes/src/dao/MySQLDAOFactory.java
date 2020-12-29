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

	@Override
	public BoardDAO createBoardDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkspaceDAO createWorkspaceDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColumnDAO createColumnDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
