package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import history_model.HikingHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profile_model.UserProfile;

public class AddHistoryController implements Initializable {
	UserProfile user;
	
	@FXML
	TextField tfName;
	@FXML
	TextField tfDistance;
	@FXML
	TextField tfDuration;
	@FXML
	TextField tfPictures;
	@FXML
	TextField tfPace;
	@FXML
	DatePicker datePicker;
	@FXML
	Button btnOk;
	@FXML
	Button btnBack;
	
	public void createHistory() {
		String name = tfName.getText();
		int distance = Integer.parseInt(tfDistance.getText());
		int duration = Integer.parseInt(tfDuration.getText());
		String picture = tfPictures.getText();
		int pace = Integer.parseInt(tfPace.getText());
		LocalDateTime date = datePicker.getValue().atTime(LocalTime.now());

		
		HikingHistory history = new HikingHistory(name, distance, duration, picture, pace, date);
		user.addHistory(history);
		
		tfName.clear();
		tfDistance.clear();
		tfPictures.clear();
		tfPace.clear();
		tfDuration.clear();
		datePicker.setValue(null);
	
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserProfileMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		user = (UserProfile) Main.returnUser();
		
	}

}
