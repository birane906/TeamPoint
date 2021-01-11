package gui.controller;

import business_logic.BoardFacade;
import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import business_logic.board.Board;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.Cell;
import business_logic.board.types.*;
import business_logic.workspace.Workspace;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
	public TableView boardTableView = new TableView();

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
				m.setOnAction(e -> {
					WorkspaceFacade workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
					if(workspaceFacade.retrieveWorkspace(w)){
						ArrayList<Board>boards = workspaceFacade.getCurrentWorkspace().getBoards();
						ObservableList<Board> myBoards = FXCollections.observableArrayList(boards);
						listBoard.setItems(myBoards);
						listBoard.setCellFactory(lv -> new SimpleListCell());

						listBoard.setOnMouseClicked(event -> {
							Board currentBoard = listBoard.getSelectionModel().getSelectedItem();
							boardLabel.setText(currentBoard.getName());
							boardTableView.getColumns().clear();
							boardTableView.getItems().clear();

							BoardFacade boardFacade = BoardFacade.getBoardFacadeInstance();
							if(boardFacade.retrieveBoard(currentBoard)) {
								List<ItemCollection> currentItemCollections = currentBoard.getItemCollections();
								ObservableList<ItemCollection> mycurrentIC = FXCollections.observableArrayList(currentItemCollections);

								itemCollectionMenuButton.getItems().clear();
								for (ItemCollection ic : mycurrentIC) {
									MenuItem mic = new MenuItem(ic.getName());
									mic.setOnAction(e1 -> {

										List<Item> items = ic.getItems();

										ObservableList<Item> itemsObs = FXCollections.observableArrayList(items);
										boardTableView.setItems(itemsObs);
/*
										for (Column<? extends Type> c: currentBoard.getColumns()) {
											switch (c.getColumnType().getNameType()) {
												case "DateType":

													List<Cell<DateType>> cells = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cells.add((Cell<DateType>) cell);
													}

													System.out.println(cells);

													ObservableList<Cell<DateType>> cellsDate = FXCollections.observableArrayList(cells);
													boardTableView.setItems(cellsDate);
													break;

												case "DependencyType":
													int y =5;
													List<Cell<DependencyType>> cellsDep = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsDep.add((Cell<DependencyType>) cell);
													}

													ObservableList<Cell<DependencyType>> cellsDepe = FXCollections.observableArrayList(cellsDep);
													boardTableView.setItems(cellsDepe);
													break;

												case "NumberType":
													int u = 78;
													List<Cell<NumberType>> cellsNum = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsNum.add((Cell<NumberType>) cell);
													}

													ObservableList<Cell<NumberType>> cellsNume = FXCollections.observableArrayList(cellsNum);
													boardTableView.setItems(cellsNume);
													break;

												case "PersonType":
													int v = 79;
													List<Cell<PersonType>> cellsPerso = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsPerso.add((Cell<PersonType>) cell);
													}

													ObservableList<Cell<PersonType>> cellsPers = FXCollections.observableArrayList(cellsPerso);
													boardTableView.setItems(cellsPers);
													break;

												case "StatusType":
													int aa = 798;
													List<Cell<StatusType>> cellsStat = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsStat.add((Cell<StatusType>) cell);
													}

													ObservableList<Cell<StatusType>> cellsStatus = FXCollections.observableArrayList(cellsStat);
													boardTableView.setItems(cellsStatus);
													break;

												case "TimelineType":
													int de = 1;
													List<Cell<TimelineType>> cellsTL = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsTL.add((Cell<TimelineType>) cell);
													}

													ObservableList<Cell<TimelineType>> cellsTLine = FXCollections.observableArrayList(cellsTL);
													boardTableView.setItems(cellsTLine);
													break;

												case "TextType":
													int des = -1;
													List<Cell<TextType>> cellsTex = new ArrayList<>();

													for (Cell<? extends Type> cell: c.getCells()) {
														cellsTex.add((Cell<TextType>) cell);
													}

													ObservableList<Cell<TextType>> cellsText = FXCollections.observableArrayList(cellsTex);
													boardTableView.setItems(cellsText);
													break;
											}
										}

 */
									});

									itemCollectionMenuButton.getItems().add(mic);

								}

								//SET COLUMNS

								TableColumn<Item, String> task = new TableColumn<>("Tâche");
								task.setCellValueFactory(new PropertyValueFactory<>("label"));
								boardTableView.getColumns().add(task);

								for (Column c : currentBoard.getColumns()) {
									switch (c.getColumnType().getNameType()) {
										case "DateType":
											TableColumn<Cell<DateType>, String> dateType = new TableColumn<>("DateType");
											task.setCellValueFactory(c -> new SimpleStringProperty(c.getValue()));
											boardTableView.getColumns().add(dateType);

											break;

										case "DependencyType":
											TableColumn<Cell<DependencyType>, String> dependency = new TableColumn<>("DependencyType");
			//								task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(dependency);
											break;
										case "NumberType":
											TableColumn<Cell<NumberType>, String> number = new TableColumn<>("NumberType");
			//								task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(number);
											break;
										case "PersonType":
											TableColumn<Cell<PersonType>, String> person = new TableColumn<>("PersonType");
			//								task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(person);
											break;
										case "StatusType":
											TableColumn<Cell<StatusType>, String> status = new TableColumn<>("StatusType");
		//									task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(status);
											break;
										case "TimelineType":
											TableColumn<Cell<TimelineType>, String> timelineType = new TableColumn<>("TimelineType");
		//									task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(timelineType);
											break;
										case "TextType":
											TableColumn<Cell<TextType>, String> text = new TableColumn<>("TextType");
		//									task.setCellValueFactory(new PropertyValueFactory<>("value"));

											boardTableView.getColumns().add(text);
										default:
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
