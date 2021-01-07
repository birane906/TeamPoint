package gui.controller;

import business_logic.BoardFacade;
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
 * @author Salim Azharhoussen, Birane Ba, Raphael Bourret, Nicolas Galois
 */
public class WorkspaceController implements Initializable {

	@FXML
	public Line line;

	@FXML
	public Label workspaceName;

	@FXML
	public ImageView addBoardImage;


	@FXML
	public Label addBoardLabel;



	@FXML
	public Line line2;

	@FXML
	public ListView<Board> listBoard;

	@FXML
	public ScrollPane sp;

	@FXML
	public Label boardLabel;

	@FXML
	public Line line3;

	@FXML
	public ScrollPane sp2;

	@FXML
	public MenuButton ChangeViewMenuButton;

	@FXML
	public ListView<ItemCollection> itemCollectionListView;

	@FXML
	public MenuItem createWorkspaceMenuItem;

	@FXML
	public MenuItem deleteWorkspaceMenuItem;

	@FXML
	public MenuButton addDelete;

	@FXML
	public MenuButton itemCollectionMenuButton;

	@FXML
	private MenuButton workspaces;

	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;





	/**
	 * Method which permite an user to manage his profile when he clicks the profile button
	 * @param mouseEvent
	 */
	@FXML
	public void profileImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/profile.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}


	/**
	 * Method which permite an user to log out when he clicks the log out button
	 * @param mouseEvent
	 */
	@FXML
	public void logoutBtn(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * The constructor of WorkspaceController.
	 */
	public WorkspaceController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
	}



	public void addBoardClicked(MouseEvent mouseEvent) throws Exception{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/createBoard.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();

	}


	public void goToCreateW(ActionEvent mouseEvent) throws IOException{

		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/createWorkspace.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) addDelete.getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	public void goToDeleteW(ActionEvent event) throws IOException{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/deleteWorkspace.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) addDelete.getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}




	/**
	 * Method which initialize the login window
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		line.setVisible(false);
		line2.setVisible(false);
		line3.setVisible(false);
		sp.setVisible(false);
		sp2.setVisible(false);
		addBoardImage.setVisible(false);
		addBoardLabel.setVisible(false);
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

							listBoard.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									Board currentBoard = listBoard.getSelectionModel().getSelectedItem();
									boardLabel.setText(currentBoard.getName());

									BoardFacade boardFacade = BoardFacade.getBoardFacadeInstance();
									if(boardFacade.retrieveBoard(currentBoard)) {
										List<ItemCollection> currentItemCollections = currentBoard.getItemCollections();
										ObservableList<ItemCollection> mycurrentIC = FXCollections.observableArrayList(currentItemCollections);

										for (ItemCollection ic : mycurrentIC) {
											MenuItem mic = new MenuItem(ic.getName());
											itemCollectionMenuButton.getItems().add(mic);
										}
									}


								}
							});

							workspaces.setText(m.getText());
							workspaceName.setText(m.getText());
							sp.setVisible(true);
							sp2.setVisible(true);
							line.setVisible(true);
							line2.setVisible(true);
							line3.setVisible(true);
							addBoardImage.setVisible(true);
							addBoardLabel.setVisible(true);


						}

					}
				});
				workspaces.getItems().add(m);
			}
		}



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
