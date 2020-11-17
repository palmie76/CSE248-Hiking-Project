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
import trail_model.Trail;

public class TrailSearchAdminController implements Initializable {
	private LinkedList<Trail> results;
	
	@FXML
	Text resultsText;
	@FXML 
	Button btnBack;
	
	public void loadResults(){
		results = AdminMainController.getTrailResults();
		for(Trail t : results) {
			resultsText.setText(resultsText.getText() + t.toString() + " Elevation: " + t.getHeadAddress() + " Length: " + t.getLength() + " Difficulty: " + t.getDifficulty() + " Type: " + t.getType() + "\n\n");
			 
		}
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadResults();
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	

}
