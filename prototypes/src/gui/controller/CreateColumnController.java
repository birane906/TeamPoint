package gui.controller;

import business_logic.BoardFacade;
import business_logic.ColumnFacade;
import business_logic.UserFacade;
import business_logic.WorkspaceFacade;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.types.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description of WorkspaceController.
 * 
 * @author 
 */
public class CreateColumnController {

	@FXML
	public TextField columnName;

	@FXML
	public TextField type;


	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	private WorkspaceFacade workspaceFacade;

	private BoardFacade boardFacade;

	private ColumnFacade columnFacade;



	@FXML
	private Label messageLabel;

	/**
	 * Method which permite an user to validate his first name modification
	 * @param event
	 */
	@FXML
	public void validateOnAction(ActionEvent event) throws IOException{
		if(!columnName.getText().isBlank() && !type.getText().isBlank()) {
			//ArrayList<Type> listTypes = columnFacade.retrieveColumnTypes();
			/*for (Type t : listTypes) {
				MenuItem mic = new MenuItem(t.getNameType());
				mic.setOnAction(e1 -> {
					String selected = t.getNameType();
					columnFacade.addColumn(columnName.getText(), boardFacade.getCurrentBoard(),selected);
				});

				typeColumnMenuButton.getItems().add(mic);
			}

			for (int i=0; i < typeColumnMenuButton.getItems().size();i++) {
				typeColumnMenuButton.get

			}

			 */
			columnFacade.addColumn(columnName.getText(), boardFacade.getCurrentBoard(),type.getText());
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
	public CreateColumnController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
		workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
		boardFacade = BoardFacade.getBoardFacadeInstance();
		columnFacade = ColumnFacade.getColumnFacadeInstance();
	}




}


