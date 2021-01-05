package business_logic;


import business_logic.user.User;
import business_logic.workspace.Workspace;
import dao.DAOFactory;
import dao.UserDAO;
import dao.WorkspaceDAO;

import java.util.Date;
import java.util.HashSet;

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
	private User currentUser =null;


	/**
	 * private constructor
	 */
	private UserFacade() {
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
	 * Asks for UserDAO to update a {@link User} giving an new {@link User}.
	 * @param newUser A new {@link User} with same id as current user
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	private boolean updateUserProfile(User newUser) {
		if (newUser == null || currentUser == null || newUser.getUser_id() != currentUser.getUser_id()) {
			return false;
		}
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		UserDAO userDAO = daoFactory.createUserDAO();

		newUser = userDAO.updateUserProfile(currentUser, newUser);
		if (newUser != null) {
			currentUser = newUser;
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Update the birthday of the current user
	 * @param birthday The new {@link Date} of the birthday of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updateBirthday(Date birthday) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setBirthday(birthday);
		return updateUserProfile(newUser);
	}

	/**
	 * Update the description of the current user
	 * @param description The new description of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updateDescription(String description) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setProfileDescription(description);
		return updateUserProfile(newUser);
	}

	/**
	 * Update the email of the current user
	 * @param email The new email of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updateEmail(String email) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setEmail(email);
		return updateUserProfile(newUser);
	}

	/**
	 * Update the name of the current user
	 * @param name The new name of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updateName(String name) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setName(name);
		return updateUserProfile(newUser);
	}

	/**
	 * Update the number of the current user
	 * @param number The new number of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updateNumber(String number) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setPhoneNumber(number);
		return updateUserProfile(newUser);
	}

	/**
	 * Update the password of the current user
	 * @param password The new password of the {@link User}
	 * @return <code>true</code> if the update succeed, <code>false</code> otherwise.
	 */
	public boolean updatePassword(String password) {
		User newUser;
		try {
			newUser = (User) currentUser.clone();
		} catch (CloneNotSupportedException e) {
			return false;
		}
		newUser.setPassword(password);
		return updateUserProfile(newUser);
	}

	/**
	 * Description of the method getCurrentUserEmail.
	 * @return 
	 */
	public String getCurrentUserEmail() {
		String getCurrentUserEmail = "";
		return getCurrentUserEmail;
	}

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
		DAOFactory daoFactory = DAOFactory.getDaoFactoryInstance();
		WorkspaceDAO workspaceDAO = daoFactory.createWorkspaceDAO();
		System.out.println(currentUser);
		try {

			return workspaceDAO.getUserWorkspaces(currentUser);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		UserFacade userFacade = new UserFacade();

		System.out.println(userFacade.login("galoisnicolas@gmail.com", "toto"));
		
		System.out.println(userFacade.signUp("salu", "saas", "mail", "de"));
		System.out.println(userFacade.delete("mail"));
		
	}
}
