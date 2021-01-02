/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package business_logic.user;

import java.util.Date;
// Start of user code (user defined imports)
import java.util.HashSet;

// End of user code

/**
 * User class .
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class User {

	private int user_id;
	
	/**
	 * The property name which is the user name.
	 */
	private String name;

	/**
	 * The property firstName which is the user first name.
	 */
	private String firstName;

	/**
	 * The property email which is the user email.
	 */
	private String email;
	
	// TODO find solution for password without stocking it in a user
	/**
	 * Property password
	 */
	private String password;

	/**
	 * The property profileDescription which is the profile description of the user.
	 */
	private String profileDescription;

	/**
	 * The property phoneNumber which is the user phone number.
	 */
	private String phoneNumber;

	/**
	 * The property userAttendances which is the set of user attendances.
	 */
	private HashSet<AbstractUserAttendance> userAttendances = new HashSet<AbstractUserAttendance>();

	/**
	 * The property birthday which is the user birthday.
	 */
	public Date birthday;

	//TODO Ajouter dans la base le role du user et donc dans le constructeur
	/**
	 * The constructor
	 */
	/*
	// TODO find solution for password without stocking it in a user
	public User(String name, String firstName, String email, String password, String profileDescription, String phoneNumber) {
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.profileDescription = profileDescription;
		this.phoneNumber = phoneNumber;
	}
	 */
	
	public User(String name, String firstName, String email, String profileDescription, String phoneNumber) {
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.profileDescription = profileDescription;
		this.phoneNumber = phoneNumber;
	}
	
	public User(int id, String name, String firstName, String email, String profileDescription, String phoneNumber) {
		this.user_id = id;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.profileDescription = profileDescription;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Returns profileDescription.
	 * @return profileDescription 
	 */
	public String getProfileDescription() {
		return this.profileDescription;
	}

	/**
	 * Sets a value to attribute profileDescription. 
	 * @param newProfileDescription which is a new profile description for the user
	 */
	public void setProfileDescription(String newProfileDescription) {
		this.profileDescription = newProfileDescription;
	}

	/**
	 * Returns phoneNumber.
	 * @return phoneNumber 
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Sets a value to attribute phoneNumber. 
	 * @param newPhoneNumber which is a new phone number for the user
	 */
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	/**
	 * Returns email.
	 * @return email 
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets a value to attribute email. 
	 * @param newEmail which is a new email for the user
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getPassword() {
		return password;
	}

	/**
	 * Returns userAttendances.
	 * @return userAttendances 
	 */
	public HashSet<AbstractUserAttendance> getUserAttendances() {
		return this.userAttendances;
	}

	/**
	 * Returns name.
	 * @return name 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets a value to attribute name. 
	 * @param newName which is a new name for the user
	 */
	public void setName(String newName) {
		this.name = newName;
	}

	/**
	 * Returns firstName.
	 * @return firstName 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a value to attribute firstName. 
	 * @param newFirstName which is a new first name for the user
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Returns birthday.
	 * @return birthday 
	 */
	public Date getBirthday() {
		return this.birthday;
	}

	/**
	 * Sets a value to attribute birthday. 
	 * @param newBirthday which is a new birthday for the user
	 */
	public void setBirthday(Date newBirthday) {
		this.birthday = newBirthday;
	}

	/**
	 * The toString method for the class
	 * Returns the class in String
	 */
	public String toString() {
		String str = "";

		str += "ID : " + getUser_id();
		str += "/ Name: " + getName();
		str += "/ firstName: " + getFirstName();
		str += "/ Email: " + getEmail();
		str += "/ Profile Description: " + getProfileDescription();
		str += "/ Phone Number: " + getPhoneNumber();
		
		return str;
	}

	public int getUser_id() {
		return user_id;
	}

}
