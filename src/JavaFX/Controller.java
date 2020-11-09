package JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;

public class Controller implements Initializable {
	@FXML
	TextField tfUsername;	
	@FXML
	TextField tfPassword;
	
	UserProfileTreeMap up = new UserProfileTreeMap();
	
	public void logInButton() {
		String username = tfUsername.getText();
		String password = tfPassword.getText();
		
		UserProfile user = up.getUserProfiles().get(username);
		if(user.getPassword().equals(password)) {
			System.out.println("Log in successful");
		}
		
		//System.out.println("Log in button clicked");	
	}
	
	public void createAccount() {
		String username = tfUsername.getText();
		String password = tfPassword.getText();
		
		UserProfile u = new UserProfile(username, password, "AAA");
		up.addProfile(u);
		
		System.out.println("Creation successful");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Loading user data...");
		
	}

}
