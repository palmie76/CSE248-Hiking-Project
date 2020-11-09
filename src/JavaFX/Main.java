package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("LogInView.fxml")); //identifies GUI component and imports FXML loader
		Scene scene = new Scene(root, 300, 200);
	//	scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
