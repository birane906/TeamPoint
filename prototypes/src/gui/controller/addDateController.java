package gui.controller;

import business_logic.*;
import business_logic.board.Column;
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
 * Description of addDateController.
 * 
 * @author 
 */
public class addDateController {




	/**
	 * Description of the property userFacade.
	 */
	private UserFacade userFacade;

	/**
	 * Description of the property workspaceFacade.
	 */
	private WorkspaceFacade workspaceFacade;

	/**
	 * Description of the property boardFacade.
	 */
	private BoardFacade boardFacade;

	/**
	 * Description of the property columnFacade.
	 */
	private ColumnFacade columnFacade;

	/**
	 * Description of the property cellFacade.
	 */
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
	public addDateController() {
		super();
		userFacade = UserFacade.getUserFacadeInstance();
		workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
		boardFacade = BoardFacade.getBoardFacadeInstance();
		columnFacade = ColumnFacade.getColumnFacadeInstance();
		cellFacade = CellFacade.getCellFacadeFacadeInstance();
		columnFacade = ColumnFacade.getColumnFacadeInstance();
	}

}


