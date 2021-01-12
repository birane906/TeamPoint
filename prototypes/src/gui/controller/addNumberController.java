package gui.controller;

import business_logic.*;
import business_logic.board.ItemCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class addNumberController {
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
    public void validateOnAction(ActionEvent event) throws IOException {

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
    public addNumberController() {
        super();
        userFacade = UserFacade.getUserFacadeInstance();
        workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
        boardFacade = BoardFacade.getBoardFacadeInstance();
        columnFacade = ColumnFacade.getColumnFacadeInstance();
        cellFacade = CellFacade.getCellFacadeFacadeInstance();
        columnFacade = ColumnFacade.getColumnFacadeInstance();
    }
}
