package GUI_components;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SystemController controller = new SystemController(primaryStage);
		primaryStage.setTitle("Data");
		controller.start();

	}
	
	public static void main(String[] args) {
		Application.launch();

	}

}
