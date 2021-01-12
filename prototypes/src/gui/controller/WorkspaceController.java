package gui.controller;

import business_logic.BoardFacade;
import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import business_logic.board.Cell;
import business_logic.board.*;
import business_logic.board.types.*;
import business_logic.workspace.Workspace;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

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
	public TableView<Item> boardTableView = new TableView<>();

	@FXML
    public Label addItemCollectionLabel;

	@FXML
	public ImageView addItemCollectionImage;

	@FXML
	public ImageView addColumnImage;

	@FXML
	public Label addColumnLabel;

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


	public void addItemCollectionClicked(MouseEvent mouseEvent) throws Exception{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/createItemCollection.fxml"));
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

	public void addColumnClicked(MouseEvent mouseEvent) throws Exception{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/createColumn.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	public void addItemClicked(MouseEvent mouseEvent) throws Exception{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/createItem.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
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
		boardTableView.setEditable(true);
		boardTableView.getSelectionModel().setCellSelectionEnabled(true);
		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent click) {
				if (click.getClickCount() == 2) {
					TablePosition pos = boardTableView.getSelectionModel().getSelectedCells().get(0);
					int row = pos.getRow();
					int col = pos.getColumn();
					TableColumn column = pos.getTableColumn();
					BoardFacade boardFacade = BoardFacade.getBoardFacadeInstance();
					if (col > 0) {
						String typeName = boardFacade.getCurrentBoard().getColumns().get(col - 1).getColumnType().getNameType();
						Parent tableViewParent = null;
						FXMLLoader loader = null;
						switch (typeName) {
							case "DateType":
								loader = new FXMLLoader(getClass().getResource("../view/addDate.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "NumberType":
								loader = new FXMLLoader(getClass().getResource("../view/addNumber.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "TextType":
								loader = new FXMLLoader(getClass().getResource("../view/addText.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "PersonType":
								loader = new FXMLLoader(getClass().getResource("../view/addPerson.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "TimelineType":
								loader = new FXMLLoader(getClass().getResource("../view/addTimeline.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "StatusType":
								loader = new FXMLLoader(getClass().getResource("../view/addStatus.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								break;
							case "DependencyType":
								String taskString = boardTableView.getColumns().get(0).getCellData(row).toString();
								List<Cell> cells = boardFacade.getCurrentBoard().getColumns().get(col - 1).getCells();
								Cell c = null;
								for (Cell cell : cells) {
									if (cell.getItem().getLabel().equals(taskString)) {
										c = cell;
										break;
									}
								}
								loader = new FXMLLoader(getClass().getResource("../view/addDependency.fxml"));
								try {
									tableViewParent = loader.load();
								} catch (IOException e) {
									e.printStackTrace();
								}
								addDependencyController controller = loader.getController();
								controller.setCell(c);
								break;

						}
						Scene tableViewScene = new Scene(tableViewParent);
						Stage window = (Stage) ((Node)click.getSource()).getScene().getWindow();
						window.setScene(tableViewScene);
						window.show();
					}
				}
			}
		});
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

									});

									itemCollectionMenuButton.getItems().add(mic);

								}

								//SET COLUMNS

								TableColumn<Item, String> task = new TableColumn<>("Tâche");
								task.setCellValueFactory(new PropertyValueFactory<>("label"));
								task.setOnEditCommit(
										new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
											@Override
											public void handle(TableColumn.CellEditEvent<Item, String> itemStringCellEditEvent) {
												((Item) itemStringCellEditEvent.getTableView().getItems().get(
														itemStringCellEditEvent.getTablePosition().getRow())
												).setLabel(itemStringCellEditEvent.getNewValue());
											}


										}
								);
								boardTableView.getColumns().add(task);

								for (Column<? extends Type> c : currentBoard.getColumns()) {
									TableColumn<Item, String> tableColumn = new TableColumn<>(c.getName());
									tableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
										@Override
										public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> itemData) {
											Item item = itemData.getValue();
											for (Cell<? extends Type> cell : item.getCells()) {
												if (cell.getColumn().getColumn_id() == c.getColumn_id() && cell.getValue() != null) {
													return new ReadOnlyStringWrapper(cell.getValue().toString());
												}
											}
											return null;
										}
									});
									boardTableView.getColumns().add(tableColumn);
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
