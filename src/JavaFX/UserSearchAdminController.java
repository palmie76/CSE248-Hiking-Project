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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import profile_model.Admin;
import profile_model.User;
import profile_model.UserProfile;

public class UserSearchAdminController implements Initializable {
	private User user;
	@FXML
	Text results;
	@FXML
	Button btnBack;
	
	public void loadResults() {
		String typeOfUser;
		if(user instanceof Admin) {
			typeOfUser = "Admin";
		} else {
			typeOfUser = "User Profile";
		}
		results.setText("Results: " + "\n" + "Username: " + user.getUsername() + "\n" + "Password: " + user.getPassword() + "\n" + "Type of User: " + typeOfUser);
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		user = AdminMainController.getResultsUser();
		loadResults();
		
	}
	
	@FXML
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
}
