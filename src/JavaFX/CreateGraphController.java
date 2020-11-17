package JavaFX;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailGraph;
import trail_model.TrailPath;
import trail_model.TrailStop;
import trail_model.TrailTreeMap;
import trail_model.TrailEnums.Type;


public class CreateGraphController implements Initializable {
	private static TrailTreeMap tm;
	private static Trail trail;
	
	@FXML
	Button btnBack;
	@FXML
	Button btnCreateStop;
	@FXML
	Button btnCreatePath;
	@FXML
	TextField tfAltitude;
	@FXML
	TextField tfDistance;
	@FXML
	ChoiceBox<TrailStop> cbStop1;
	@FXML
	ChoiceBox<TrailStop> cbStop2;
	

	ObservableList<TrailStop> stops;
	
	@FXML
	void createTrail(ActionEvent e) {
		TrailStop stop1 = cbStop1.getValue();
		TrailStop stop2 = cbStop2.getValue();
		int distance = Integer.parseInt(tfDistance.getText());
		TrailPath trailPath = new TrailPath(stop1, stop2, distance);
		trail.getTrailGraph().addEdge(trailPath);
		
		cbStop1.setValue(null);
		cbStop2.setValue(null);
		tfDistance.clear();
		
	}
	
	@FXML
	void createStop(ActionEvent e) {
		TrailStop stop = new TrailStop(Integer.parseInt(tfAltitude.getText()));
		trail.getTrailGraph().addStop(stop);
		stops = FXCollections.observableArrayList(trail.getTrailGraph().getTrailStops());
		
		setChoices();
		tfAltitude.clear();
		
	}
	
	void setChoices() {
		cbStop1.getItems().setAll(stops);
		cbStop2.getItems().setAll(stops);
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tm = Main.returnTrailMap();
		trail = EditTrailController.returnTrail();
		
		
	}
	
	

}
