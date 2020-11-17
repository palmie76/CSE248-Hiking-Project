package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import profile_model.User;
import profile_model.UserProfile;
import trail_model.Trail;

public class TrailResultsUserController implements Initializable {
	public static LinkedList<Trail> results;
	public static LinkedList<Button> buttons;
	public static UserProfile user;
	
	@FXML
	Text trailsText;
	@FXML
	Button btnBack;
	@FXML
	GridPane gridPane;
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserProfileMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void loadResults() {
		results = UserProfileMainController.getList();
		for(Trail t : results) {
		trailsText.setText(trailsText.getText() + t.toString() + "\n");
		}
	}
	
//	public void populateGridPane() {
//		for(int i = 0; i < results.size(); i++) {
//			Text ta = new Text(results.get(i).toString());
//			gridPane.add(ta, 0, i);
//		}
//		
//		for(int i = 0; i < results.size(); i++) {
//			Text id = new Text(Integer.toString(results.get(i).getTrailID()));
//			gridPane.add(id, 1, i);
//		}
//		
//		for(int i = 0; i < buttons.size(); i++) {
//			gridPane.add(buttons.get(i), 2, 0);
//		}
//		
//	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		results = UserProfileMainController.getList();
		buttons = UserProfileMainController.getButtons();
		user = (UserProfile) Main.returnUser();
		loadResults();
		//populateGridPane();
	}
	

}


