package gui.controller;

import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import business_logic.board.Board;
import business_logic.board.ItemCollection;
import business_logic.workspace.Workspace;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class DeleteWorkspaceController implements Initializable{

	@FXML
	public TextField workspaceName;

	@FXML
	public ListView<Workspace> workspaceListView;
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


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		HashSet<Workspace> workspaces = userFacade.getWorkspaces();
		ObservableList<Workspace> myWorkspaces = FXCollections.observableArrayList(workspaces);
		workspaceListView.setItems(myWorkspaces);
		workspaceListView.setCellFactory(lv -> new SimpleCell());

		workspaceListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Workspace currentWorkspace = (Workspace) workspaceListView.getSelectionModel().getSelectedItem();
				workspaceFacade.deleteWorkspace(currentWorkspace);
			}
		});
	}
}


class SimpleCell extends ListCell<Workspace> {
	@Override
	protected void updateItem(Workspace item, boolean empty) {
		super.updateItem(item, empty);
		setText(null);
		if (!empty && item != null) {
			final String text = String.format("%s", item.getName());
			setText(text);
		}
	}
}
