package gui.controller;


import business_logic.UserFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Description of HomeController.
 *
 *
 */
public class ProfileController implements Initializable {
    @FXML
    public Label editNameLabel;

    @FXML
    public Label editFirstNameLabel;

    @FXML
    public Label editEmailLabel;

    @FXML
    public Label editDescriptionLabel;

    @FXML
    public Label editBirthdayLabel;

    @FXML
    public Label editNumberLabel;
    /**
     * Description of the property userFacade.
     */
    private UserFacade userFacade;


    /**
     * Method which permite an user to go back to the workspace
     * @param event
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
     * Method which permite an user to go back to the workspace
     * @param event
     */
    @FXML
    public void editNumberOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editNumber.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite an user to display a new form to edit his name
     * @param event
     */
    @FXML
    public void editNameOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editName.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite an user to display a new form to edit his first name
     * @param event
     */
    @FXML
    public void editFirstNameOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editFirstName.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite an user to display a new form to edit his email
     * @param event
     */
    @FXML
    public void editEmailOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editEmail.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Method which permite an user to display a new form to edit his birthday
     * @param event
     */
    @FXML
    public void editBirthdayOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editBirthday.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Method which permite an user to display a new form to edit his password
     * @param event
     */
    @FXML
    public void editPasswordOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editPassword.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    /**
     * Method which permite an user to display a new form to edit his description
     * @param event
     */
    @FXML
    public void editDescriptionOnAction(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("../view/editDescription.fxml"));
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
     * Method which initialize the login window
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editDescriptionLabel.setText(userFacade.getCurrentUser().getProfileDescription());
        editEmailLabel.setText(userFacade.getCurrentUser().getEmail());
        editFirstNameLabel.setText(userFacade.getCurrentUser().getFirstName());
        editNameLabel.setText(userFacade.getCurrentUser().getName());
        editNumberLabel.setText(userFacade.getCurrentUser().getPhoneNumber());

    }
}
