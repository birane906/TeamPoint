package gui.controller;

import business_logic.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * Description of LoginController.
 * 
 *
 */
public class SubscriptionController implements Initializable{
	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;


	/**
	 * Description of the close button
	 */
	@FXML
	private Button closeButton;

	/**
	 * Description of our application logo
	 */
	@FXML
	private ImageView logoImage;

	/**
	 * Description of the label in the case of a good subscription
	 */
	@FXML
	private Label userRegisteredLabel;

	/**
	 * Description of the first name text field
	 */
	@FXML
	private TextField firstNameTextField;

	/**
	 * Description of the name text field
	 */
	@FXML
	private TextField nameTextField;

	/**
	 * Description of the email text field
	 */
	@FXML
	private TextField emailTextField;

	/**
	 * Description of the password text field
	 */
	@FXML
	private PasswordField passwordField;

	/**
	 * Description of the number phone text field
	 */
	@FXML
	private TextField numberTextField;

	/**
	 * Description of the birthday date picker
	 */
	@FXML
	private DatePicker birthday;

	/**
	 * Description of the label in the case of a wrong email
	 */
	@FXML
	private Label emailInvalidLabel;

	/**
	 * Description of the label in the case of a wrong number phone
	 */
	@FXML
	private Label numberInvalidLabel;

	/**
	 * Description of the label in the case of a wrong name or first name
	 */
	@FXML
	private Label nameFirstNameInvalidLabel;

	/**
	 * Description of the label in the case of a wrong password
	 */
	@FXML
	private Label passwordInvalidLabel;

	/**
	 * The constructor.
	 */
	public SubscriptionController() {
		userFacade = UserFacade.getUserFacadeInstance();
	}


	/**
	 * Method which permite to close the window when you click on the close button
	 */
	public void closeButtonOnAction(){
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	/**
	 * Method which permite to subscribe into TeamPoint when the user clicks on the subscribe button and provides the right
	 * email and password
	 */
	@FXML
	public void subscriptionButtonOnAction(ActionEvent event){

		String regexFirstName ="";
		String firstName = emailTextField.getText();
		Pattern ptEmail = Pattern.compile(regexEmail);
		Matcher mEmail = ptEmail.matcher(email);
		boolean emailIsGood = mEmail.matches();

		String regexEmail ="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		String email = emailTextField.getText();
		Pattern ptEmail = Pattern.compile(regexEmail);
		Matcher mEmail = ptEmail.matcher(email);
		boolean emailIsGood = mEmail.matches();

		String regexPassword ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
		String password = emailTextField.getText();
		Pattern ptPassword = Pattern.compile(regexPassword;
		Matcher mPassword = ptPassword.matcher(password);
		boolean passwordIsGood = mPassword.matches();


		userRegisteredLabel.setText("Votre compte a bien été crééé !");
	}

	public void registerUser(){

	}

	/**
	 * Method which initialize the login window
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File brandingFile = new File("../teampoint_logo/TeamPointLogo2.png");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		logoImage.setImage(brandingImage);
	}
}
