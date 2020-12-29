/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic;


import business_logic.user.User;
import dao.DAOFactory;
import dao.UserDAO;
import business_logic.workspace.Workspace;

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
	 * @param email : the user's email
	 * @param password : the user's password
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

	/**
	 * Asks for UserDAO to create a {@link User}.
	 * @param name : the user's name.
	 * @param firstname : the user's firstname.
 	 * @param email : the user's email.
	 * @param password : the user's password.
	 * @return <code>true</code> if the signup succeed, <code>false</code> otherwise.
	 */
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

	/**
	 * Asks for UserDAO to delete a {@link User} giving an email.
	 * @param email : the user's email.
	 * @return <code>true</code> if the deletion succeed, <code>false</code> otherwise.
	 */
	public boolean delete(String email) {
		if (email == null) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserDAO userDAO = daoFactory.createUserDAO(); 
		return userDAO.delete(email);

	}

	/**
	 * Description of the method getCurrentUserEmail.
	 * @return 
	 */
	public String getCurrentUserEmail() {
		// Start of user code for method getCurrentUserEmail
		String getCurrentUserEmail = "";
		return getCurrentUserEmail;
		// End of user code
	}

	// Start of user code (user defined methods for UserFacade)

	// End of user code
	/**
	 * Returns currentUser.
	 * @return currentUser 
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}

	/**
	 * Sets a value to attribute currentUser. 
	 * @param newCurrentUser 
	 */
	public void setCurrentUser(User newCurrentUser) {
		this.currentUser = newCurrentUser;
	}

	/**
	 * Returns workspaces.
	 * @return workspaces 
	 */
	public HashSet<Workspace> getWorkspaces() {
		return this.workspaces;
	}
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade();
		
		System.out.println(userFacade.login("galoisnicolas@gmail.com", "toto"));
		
		System.out.println(userFacade.signUp("salu", "saas", "mail", "de"));
		System.out.println(userFacade.delete("mail"));
		
	}
}
