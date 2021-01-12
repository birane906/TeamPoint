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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description of EditFirstNameController.
 * 
 * @author 
 */
public class EditFirstNameController {

	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	@FXML
	private TextField newFirstNameTextField;


	@FXML
	private Label messageLabel;


	@FXML
	public void validateOnAction(ActionEvent event) throws IOException{

		String regex = "^[a-zA-Z]+$";
		String text = newFirstNameTextField.getText();
		Pattern pt = Pattern.compile(regex);
		Matcher m = pt.matcher(text);
		boolean IsGood = m.matches();

		if(IsGood == true) {
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
	public EditFirstNameController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
	}




}
