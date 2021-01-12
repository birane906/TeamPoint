package gui.controller;

import business_logic.*;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class CreateItemController implements Initializable {


	@FXML
	public TextField statusTypeTextField;
	public TextField dependencyTypeTextField;
	public TextField textTypeTextField;
	public TextField timelineTypeTextField;
	public DatePicker dateTypeDT;
	public TextField personTypeTextField;
	public TextField numberTypeTextField;
	public TextField itemLabel;
	public MenuButton itemCollectionMenuButton;


	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	private WorkspaceFacade workspaceFacade;

	private BoardFacade boardFacade;

	private ColumnFacade columnFacade;

	private CellFacade cellFacade;

	private ItemCollection currentItemCollection;





	@FXML
	private Label messageLabel;

	/**
	 * Method which permite an user to validate his first name modification
	 * @param event
	 */
	@FXML
	public void validateOnAction(ActionEvent event) throws IOException{
		Column dateTypeColumn = null;
		Column textTypeColumn = null;
		Column dependencyTypeColumn= null;
		Column timelineTypeColumn= null;
		Column personTypeColumn= null;
		Column numberTypeColumn= null;
		Column statusTypeColumn= null;

		if(!statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank() || !statusTypeTextField.getText().isBlank()) {

			for(Column c: boardFacade.currentBoard.getColumns() ){
				switch (c.getColumnType().getNameType()){
					case "DateType":
						dateTypeColumn = c;
						break;
					case "NumberType":
						numberTypeColumn = c;
						break;
					case "TextType":
						textTypeColumn = c;
						break;
					case "PersonType":
						personTypeColumn = c;
						break;
					case "TimelineType":
						timelineTypeColumn = c;
						break;
					case "StatusType":
						statusTypeColumn = c;
						break;
					case "DependencyType":
						dependencyTypeColumn = c;
						break;
				}
			}



			boardFacade.addItem(itemLabel.getText(), this.currentItemCollection);


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
	public CreateItemController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
		workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
		boardFacade = BoardFacade.getBoardFacadeInstance();
		columnFacade = ColumnFacade.getColumnFacadeInstance();
		cellFacade = CellFacade.getCellFacadeFacadeInstance();
		columnFacade = ColumnFacade.getColumnFacadeInstance();
	}


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		List<ItemCollection> myCurrentItemCollection = boardFacade.getCurrentBoard().getItemCollections();

		for(ItemCollection i: myCurrentItemCollection){
			MenuItem m = new MenuItem(i.getName());
			m.setOnAction(e ->{
				this.currentItemCollection = i;
				itemCollectionMenuButton.setText(m.getText());
			});
			itemCollectionMenuButton.getItems().add(m);

		}
	}
}


