package gui.controller;

import business_logic.*;
import business_logic.board.Cell;
import business_logic.board.Item;
import business_logic.board.ItemCollection;
import business_logic.board.types.DependencyType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class addDependencyController {
    public TextField dependency;
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
    private Cell cellEdit;

    /**
     * Method which permite an user to validate his first name modification
     * @param event
     */
    @FXML
    public void validateOnAction(ActionEvent event) throws IOException {
        String field = dependency.getText();
        if (!field.isBlank()) {
            Item myItem = null;
            for (ItemCollection itemCollection : boardFacade.getCurrentBoard().getItemCollections()) {
                for (Item item : itemCollection.getItems()) {
                    if (item.getLabel().equals(field)) {
                        myItem = item;
                        break;
                    }
                }
                if (myItem != null) { break; }
            }
            if (myItem != null) {
                if (cellFacade.editCell(cellEdit, new DependencyType(myItem))) {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.show();
                }
            }
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
    public addDependencyController() {
        super();
        userFacade = UserFacade.getUserFacadeInstance();
        workspaceFacade = WorkspaceFacade.getWorkspaceFacadeInstance();
        boardFacade = BoardFacade.getBoardFacadeInstance();
        columnFacade = ColumnFacade.getColumnFacadeInstance();
        cellFacade = CellFacade.getCellFacadeFacadeInstance();
        columnFacade = ColumnFacade.getColumnFacadeInstance();
    }

    public void setCell(Cell cell) {
        this.cellEdit = cell;
    }
}
