package gui.controller;

import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class DeleteWorkspaceController {

	@FXML
	public TextField workspaceName;
	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	private WorkspaceFacade workspaceFacade;


	@FXML
	private Label messageLabel;

	/**
	 * Method which permite an user to validate his first name modification
	 * @param event
	 */
	@FXML
	public void validateOnAction(ActionEvent event) throws IOException{
		if(!workspaceName.getText().isBlank()) {
			workspaceFacade.createWorkspace(workspaceName.getText());
			Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
			Scene tableViewScene = new Scene(tableViewParent);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		}else{
			messageLabel.setText("Changement non effectué");
		}
	}

	/**
	 * Method which permite an user to cancel his first name modification
	 * @param event
	 */
	@FXML
	public void cancelOnAction(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * The constructor.
	 */
	public DeleteWorkspaceController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
		workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
	}




}
