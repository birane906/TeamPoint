package gui.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Description of LoginView.
 * @author
 *
 */
public class SubscriptionView extends Application{

	/**
	 * Description of the method start.
	 */
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("subscription.fxml"));
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(new Scene(root, 594, 425));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
