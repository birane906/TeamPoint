package gui.controller;

import business_logic.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class EditEmailController {

	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	@FXML
	private PasswordField newPasswordField;

	@FXML
	private PasswordField confPasswordField;

	@FXML
	private Button validateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Label messageLabel;


	@FXML
	public void validateOnAction(ActionEvent event) throws IOException{

		String regexPassword ="^(?=.*[A-z])(?=.*[A-Z])(?=.*[0-9])\\S{8,}$";
		String password = newPasswordField.getText();
		Pattern ptPassword = Pattern.compile(regexPassword);
		Matcher mPassword = ptPassword.matcher(password);
		boolean passwordIsGood = mPassword.matches();

		if(newPasswordField.getText() == confPasswordField.getText() && !newPasswordField.getText().isBlank() && passwordIsGood) {

			//TO DO
			// TRAITEMENT BDD
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/profile.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		}else{
			messageLabel.setText("Changement non effectué");
		}
	}

	@FXML
	public void cancelOnAction(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/profile.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * The constructor.
	 */
	public EditEmailController() {
		super();
	}




}
