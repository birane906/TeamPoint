/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package dao;

/**
 * {@link DAOFactory} is the Abstract Factory for {@link DAO} objects.
 * 
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public abstract class DAOFactory {


	private static class DAOFactoryHolder {
		/**
		 * The concrete factory for creating {@link DAO} object family
		 */
		private static final DAOFactory DAO_FACTORY = new MySQLDAOFactory();
	}

	/**
	 * Creates a {@link UserDAO}
	 * @return Returns a {@link UserDAO}
	 */
	public abstract UserDAO createUserDAO();

	/**
	 * Description of the method createBoardDAO.
	 * @return 
	 */
	public abstract BoardDAO createBoardDAO();

	/**
	 * Description of the method createWorkspaceDAO.
	 * @return 
	 */
	public abstract WorkspaceDAO createWorkspaceDAO();

	/**
	 * Description of the method createColumnDAO.
	 * @return 
	 */
	public abstract ColumnDAO createColumnDAO();

	/**
	 * <code>static</code> method. It returns a subtype of {@link DAOFactory} (a concrete factory)
	 * @return Returns the concrete factory for creating {@link DAO} object family
	 */
	public static DAOFactory getDaoFactoryInstance() {
		return DAOFactoryHolder.DAO_FACTORY;
	}
}