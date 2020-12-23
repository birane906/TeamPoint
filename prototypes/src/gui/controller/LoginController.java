package gui.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import business_logic.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Description of LoginController.
 * 
 *
 */
public class LoginController implements Initializable{
	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	/**
	 * Description of the label in the case of a wrong authentification
	 */
	@FXML
	private Label wrongAuthentification;

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
	 * The constructor.
	 */
	public LoginController() {
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
	 * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
	 * email and password
	 */
	@FXML
	public void loginButtonOnAction(ActionEvent event){
		if(emailTextField.getText().isBlank() 
			|| passwordField.getText().isBlank()
			|| !userFacade.login(emailTextField.getText(),passwordField.getText())){
			wrongAuth();
		}else{
			//CHANGEMENT DE VUE
			System.out.println("validé");
		}
	}

	/**
	 * an utility function used
	 */
	@FXML
	private void wrongAuth(){
		wrongAuthentification.setText("Email ou mot de passe incorrect");
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
