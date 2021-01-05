package gui.controller;

import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import business_logic.board.Board;
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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class WorkspaceController implements Initializable {

	@FXML
	public Line line;

	@FXML
	public Label workspaceName;

	@FXML
	public ImageView addBoardImage;

	@FXML
	public ImageView inviteMemberImage;

	@FXML
	public Label addBoardLabel;

	@FXML
	public Label inviteMemberLabel;

	@FXML
	public Line line2;

	@FXML
	public Label board1;

	@FXML
	public ListView<Board> listBoard;

	@FXML
	public ScrollPane sp;

	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;
	@FXML
	private MenuButton workspaces;


	/**
	 * Description of
	 */
	@FXML
	private ImageView profileImage;


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
		userFacade = UserFacade.getUserFacadeInstance();
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

	/**
	 * Method which initialize the login window
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		line.setVisible(false);
		line2.setVisible(false);
		sp.setVisible(false);
		addBoardImage.setVisible(false);
		addBoardLabel.setVisible(false);
		inviteMemberImage.setVisible(false);
		inviteMemberLabel.setVisible(false);
		Set<Workspace> wsl = userFacade.getWorkspaces();

		if(wsl != null) {
			for (Workspace w : wsl) {
				MenuItem m = new MenuItem(w.getName());
				m.setOnAction(new EventHandler<ActionEvent>() {
					@Override public void handle(ActionEvent e) {
						WorkspaceFacade workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
						if(workspaceFacade.retrieveWorkspace(w)){
							ArrayList<Board>boards = workspaceFacade.getCurrentWorkspace().getBoards();
							ObservableList<Board> myBoards = FXCollections.observableArrayList(boards);
							listBoard.setItems(myBoards);
							listBoard.setCellFactory(lv -> new SimpleListCell());


							workspaces.setText(m.getText());
							workspaceName.setText(m.getText());
							sp.setVisible(true);
							line.setVisible(true);
							line2.setVisible(true);
							addBoardImage.setVisible(true);
							addBoardLabel.setVisible(true);
							inviteMemberImage.setVisible(true);
							inviteMemberLabel.setVisible(true);
						}

					}
				});
				workspaces.getItems().add(m);
			}
		}



	}


	public void addBoardClicked(MouseEvent mouseEvent) throws Exception{

	}

	public void inviteMemberClicked(MouseEvent mouseEvent) throws Exception{

	}
}

class SimpleListCell extends ListCell<Board> {

	@Override
	protected void updateItem(Board item, boolean empty) {
		super.updateItem(item, empty);
		setText(null);
		if (!empty && item != null) {
			final String text = String.format("%s", item.getName());
			setText(text);
		}
	}
}
