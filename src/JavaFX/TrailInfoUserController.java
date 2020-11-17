package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trail_model.Trail;
import trail_model.TrailStop;
import trail_model.TrailTreeMap;

public class TrailInfoUserController implements Initializable {
	
	private static Trail trail;
	ObservableList<TrailStop> stops;
	
	@FXML
	Button btnDistance;
	@FXML
	Button btnBack;
	@FXML
	TextArea textArea;
	@FXML
	ChoiceBox<TrailStop> cbStop1;
	@FXML
	ChoiceBox<TrailStop> cbStop2;
	@FXML
	TextField tfDistance;
	
	public void fillTextArea() {
		textArea.setText("Trail Information" + "\n" + "Name: " + trail.getTrailName() + "\n" + "Head Address: " + 
	trail.getHeadAddress() + "\n" + "Length: " + trail.getLength() + "\n" + 
				"Elevation Gain: " + trail.getElevationGain() + "\n" + "Difficulty: " + 
	trail.getDifficulty() +"\n"+ "Type: " + trail.getType());
	
	}
	
	@FXML
	public void calculateDistance(ActionEvent e) {
		int result = trail.getTrailGraph().calculateDistance(cbStop1.getValue(), cbStop2.getValue());
		tfDistance.setText(String.valueOf(result));
	}
	
	void setChoices() {
		stops = FXCollections.observableArrayList(trail.getTrailGraph().getTrailStops());
		cbStop1.getItems().setAll(stops);
		cbStop2.getItems().setAll(stops);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		trail = UserProfileMainController.returnTrail();
		fillTextArea();
		setChoices();
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserProfileMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}

}
