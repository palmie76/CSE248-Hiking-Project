package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import profile_model.Admin;
import profile_model.User;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import trail_model.TrailTreeMap;

public class LogInController implements Initializable {
	//private TrailTreeMap tm;
    private UserProfileTreeMap up;
	private User user;
	
	@FXML
	TextField tfUsername;	
	@FXML
	TextField tfPassword;
	@FXML
	Button btnCreateUserProfile;
	@FXML
	Button btnCreateAdminProfile;
	@FXML
	Button btnExit;
	
	public void logInButton(ActionEvent e) throws IOException {
		String username = tfUsername.getText();
		String password = tfPassword.getText();
		
		user = up.getUserProfiles().get(username);	
		Main.setUser(user);
		if(up.contains(user)) {
			if(user.getPassword().equals(password)) {
				if(user instanceof Admin) {
					Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
					Scene scene = new Scene(root);
					Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
					
					window.setScene(scene);
					window.show();
				}
				
				else if (user instanceof UserProfile) {
					Parent root = FXMLLoader.load(getClass().getResource("UserProfileMainView.fxml")); 
					Scene scene = new Scene(root);
					Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
					
					window.setScene(scene);
					window.show();
				}
		}
	}
	
	}
	
	public void createAdminAccount(ActionEvent e) throws IOException {
		//load new view, allow creation of Admin 
		Parent root = FXMLLoader.load(getClass().getResource("CreateAdminView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
		
	}
	@FXML
	public void exitProgram(ActionEvent e) {
		Platform.exit();
		
	}
	
	public void createUserProfileAccount(ActionEvent e) throws IOException {
		//load Create User
		Parent root = FXMLLoader.load(getClass().getResource("CreateUserProfileView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		up = Main.returnUserMap();
		
	}
	

}
