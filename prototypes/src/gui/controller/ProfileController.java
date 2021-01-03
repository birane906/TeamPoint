package gui.controller;


import business_logic.UserFacade;
import javafx.event.ActionEvent;
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
     * Description of the close button
     */
    @FXML
    private Button closeButton;



    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void backButtonOnAction(ActionEvent event) throws IOException{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }

    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editNumberOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editNameOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editFirstNameOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editEmailOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editBirthdayOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editPasswordOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite to connect into TeamPoint when the user clicks on the login button and provides the right
     * email and password
     */
    @FXML
    public void editDescriptionOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/workspace.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }




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
