package gui.controller;

import business_logic.UserFacade;
import business_logic.workspace.Workspace;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class WorkspaceController {

	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	private MenuButton workspaces;

	HashSet<Workspace> wsl = userFacade.getWorkspaces();
	ArrayList<Workspace> myWorkspaces = new ArrayList<>(wsl);
	int workspaceSize = myWorkspaces.size();


	for(int i=0; i < workspaceSize; i++){
		workspaces.getItems().add(new MenuItem(myWorkspaces.get(i).getName()));
	}


	/**
	 * Description of
	 */
	@FXML
	private ImageView profileImage;

	/**
	 * Description of the close button
	 */
	@FXML
	private Button closeButton;

	/**
	 * Method which permite to close the window when you click on the close button
	 */
	public void closeButtonOnAction(){
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void boxImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

	}


	@FXML
	public void profileImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/profile.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}


	@FXML
	public void logoutBtn(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * The constructor.
	 */
	public WorkspaceController() {
		super();
	}

	/**
	 * Description of the method deleteWorkspace.
	 * @return 
	 */
	public Boolean deleteWorkspace() {
		Boolean deleteWorkspace = Boolean.FALSE;
		return deleteWorkspace;
	}

	/**
	 * Description of the method createWorkspace.
	 * @param name 
	 * @return 
	 */
	public Boolean createWorkspace(String name) {
		Boolean createWorkspace = Boolean.FALSE;
		return createWorkspace;
	}

	/**
	 * Description of the method getUserWorkspaces.
	 */
	public void getUserWorkspaces() {
	}

	/**
	 * Description of the method retrieveWorkspace.
	 * @param workspace 
	 */
	public void retrieveWorkspace(Workspace workspace) {
	}



}
