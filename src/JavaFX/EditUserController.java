package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;

public class EditUserController implements Initializable {
	private UserProfile user;
	private UserProfileTreeMap up;
	
	@FXML
	TextField tfUsername;
	@FXML
	TextField tfPassword;
	@FXML
	TextField tfPhoto;
	@FXML
	Button btnEdit;
	@FXML
	Button btnDelete;
	@FXML
	Button btnBack;
	
	public void loadInformation() {
		tfUsername.setText(user.getUsername());
		tfPassword.setText(user.getPassword());
		tfPhoto.setText(user.getProfilePicture());
	}
	
	public void updateInformation() {
		UserProfile target = user;
		up.deleteProfile(user);

		target.setUsername(tfUsername.getText());
		target.setPassword(tfPassword.getText());
		target.setProfilePicture(tfPhoto.getText());
		
		up.addProfile(target);
		
		//up.addProfile(target);
	//	up.getUserProfiles().replace(user.getUsername(), user, target);
	//	up.getUserProfiles().put(tfUsername.getText(), target);
		
		//Main.setUserProfileTreeMap(up);
		
		
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public void deleteUser(ActionEvent e) {
		up.deleteProfile(user);
		
		tfUsername.clear();
		tfPassword.clear();
		tfPhoto.clear();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		user = AdminMainController.returnUser();
		up = Main.returnUserMap();
		loadInformation();
		
	}

}
