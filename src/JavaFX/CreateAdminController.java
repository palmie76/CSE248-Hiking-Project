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
import profile_model.Admin;
import profile_model.UserProfileTreeMap;

public class CreateAdminController implements Initializable {
	private UserProfileTreeMap up;

	@FXML
	Button btnOK;
	@FXML
	Button btnBack;
	@FXML
	TextField tfUsername;
	@FXML
	TextField tfPassword;
	
	public void createAdminAccount(ActionEvent e) throws IOException {
		String username = tfUsername.getText();
		String password = tfPassword.getText();

	//	if(!username.contentEquals(null)) {
		Admin u = new Admin(username, password);
		up.addProfile(u);

		
		Parent root = FXMLLoader.load(getClass().getResource("LogInView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogInView.fxml")); 
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
