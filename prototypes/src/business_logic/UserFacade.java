/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;


import business_logic.user.User;
import dao.DAOFactory;
import dao.UserDAO;

/**
 * {@link UserFacade} is a Singleton class. Simplify the use of 
 * buisness logic subsystem for the GUI layer. Facade pattern. 
 * Contains the buisness methods.
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class UserFacade {

	/**
	 * <code>currentUser</code> class member {@link User} instance.
	 * Is null until login method is called
	 */
	@SuppressWarnings("unused")
	private User currentUser;

	/**
	 * <code>private</code> constructor
	 */
	private UserFacade() {
		this.currentUser = null;
	}

	/***
	 * The {@link UserFacadeHolder} <code>static</code> nested class
	 * guarantees the uniqueness of {@link UserFacade} instance
	 */
	private static class UserFacadeHolder {
		/**
		 * The unique instance of {@link UserFacade}
		 */
		private static final UserFacade USER_FACADE = new UserFacade();
	}

	/***
	 * <code>static</code> method. Gives the unique instance of 
	 * {@link UserFacade}
	 * @return Returns the {@link UserFacade} 
	 */
	public static UserFacade getUserFacadeInstance() {
		return UserFacadeHolder.USER_FACADE;
	}

	/**
	 * Asks for UserDAO to return a user based on email and password,
	 * sets the currentUser to the returned {@link User}
	 * @param email 
	 * @param password 
	 * @return true if user found, false if user not found or incorrect 
	 */
	public boolean login(String email, String password) {
		if (email == null || password == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserDAO userDAO = daoFactory.createUserDAO();
		try {
			this.currentUser = userDAO.getUser(email, password);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//TODO docs
	public boolean signUp(String name, String firstname,
		String email, String password){
		if (email == null || password == null || name == null 
			|| firstname == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserDAO userDAO = daoFactory.createUserDAO();
		return userDAO.signUp(name, firstname, email, password);
	}

	public boolean delete(String email) {
		if (email == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserDAO userDAO = daoFactory.createUserDAO(); 
		return userDAO.delete(email);

	}
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade();
		
		System.out.println(userFacade.login("galoisnicolas@gmail.com", "toto"));
		
		System.out.println(userFacade.signUp("salu", "saas", "sasa", "de"));
		System.out.println(userFacade.delete("sasa"));
		
	}
}
