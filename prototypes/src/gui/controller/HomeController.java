package gui.controller;


import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business_logic.UserFacade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Description of HomeController.
 *
 *
 */
public class HomeController{
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
     * The constructor.
     */
    public HomeController() {
        userFacade = UserFacade.getUserFacadeInstance();
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
