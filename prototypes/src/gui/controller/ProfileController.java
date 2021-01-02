package gui.controller;


import business_logic.UserFacade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Description of HomeController.
 *
 *
 */
public class ProfileController {
    /**
     * Description of the property userFacade.
     */
    private UserFacade userFacade;


    /**
     * Description of
     */
    @FXML
    private ImageView profileImage;

    /**
     * Description of the close button
     */
    @FXML
    private Button closeButton;


    /**
     * The constructor.
     */
    public ProfileController() {
        userFacade = UserFacade.getUserFacadeInstance();
    }


    /**
     * Method which permite to close the window when you click on the close button
     */
    public void closeButtonOnAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void profileImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/profile.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
