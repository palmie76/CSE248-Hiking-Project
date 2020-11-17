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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;
import trail_model.TrailTreeMap;

public class EditTrailController implements Initializable {
	private static Trail trail;
	private static TrailTreeMap tm;
	ObservableList<Type> type = FXCollections.observableArrayList(TrailEnums.Type.values());
	ObservableList<Difficulty> difficulty = FXCollections.observableArrayList(TrailEnums.Difficulty.values());
	
	
	@FXML
	TextField tfName;
	@FXML
	TextField tfAddress;
	@FXML
	TextField tfElevation;
	@FXML
	TextField tfLength;
	@FXML
	ChoiceBox<Difficulty> cbDifficulty;
	@FXML
	ChoiceBox<Type> cbType;
	@FXML
	Button btnEdit;
	@FXML
	Button btnDelete;
	@FXML
	Button btnBack;
	@FXML
	Button btnEditGraph;
	
	public void loadTrailInfo() {
		tfName.setText(trail.getTrailName());
		tfAddress.setText(trail.getHeadAddress());
		tfElevation.setText(String.valueOf(trail.getElevationGain()));
		tfLength.setText(String.valueOf(trail.getLength()));
		cbDifficulty.setValue(trail.getDifficulty());
		cbType.setValue(trail.getType());
		
	}
	
	public void clearInfo() {
		tfName.clear();
		tfAddress.clear();
		tfElevation.clear();
		tfLength.clear();
		cbDifficulty.setValue(null);
		cbType.setValue(null);
	}
	
	public void editTrail(ActionEvent e) {
		trail.setTrailName(tfName.getText());
		trail.setHeadAddress(tfAddress.getText());
		trail.setElevationGain(Integer.parseInt(tfElevation.getText()));
		trail.setLength(Integer.parseInt(tfLength.getText()));
		trail.setDifficulty((Difficulty)cbDifficulty.getValue());
		trail.setType((Type)cbType.getValue());
		
		clearInfo();
	}
	
	@FXML
	public void setChoices() {
		cbType.getItems().setAll(type);
		cbDifficulty.getItems().setAll(difficulty);
	}
	
	@FXML
	public void deleteTrail(ActionEvent e) throws IOException {
		tm.removeTrail(trail);
		
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminMainView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public void createGraph(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreateGraphView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public static Trail returnTrail() {
		return trail;
	}
	
	public static void setTrail(Trail t) {
		trail = t;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//	trail = AdminMainController.returnTrail();
		tm = Main.returnTrailMap();
		setChoices();
		loadTrailInfo();
		
	}

}
