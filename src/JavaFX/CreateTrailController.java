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

public class CreateTrailController implements Initializable {
	private TrailTreeMap tm;
	ObservableList<Type> type = FXCollections.observableArrayList(TrailEnums.Type.values());
	ObservableList<Difficulty> difficulty = FXCollections.observableArrayList(TrailEnums.Difficulty.values());
	
	@FXML
	Button btnBack;
	@FXML
	Button btnOk;
	@FXML
	TextField tfName;
	@FXML
	TextField tfHeadAddress;
	@FXML
	TextField tfLength;
	@FXML
	TextField tfElevation;
	@FXML
	ChoiceBox<Difficulty> cbDifficulty;
	@FXML
	ChoiceBox<Type> cbType;
	@FXML
	Button btnCreateGraph;
	
	@FXML
	public void setChoices() {
		cbType.getItems().setAll(type);
		cbDifficulty.getItems().setAll(difficulty);
	}

	public void createTrail(ActionEvent e) throws IOException {
		String name = tfName.getText();
		String address = tfHeadAddress.getText();
		int length = Integer.parseInt(tfLength.getText());
		int elevation = Integer.parseInt(tfElevation.getText());
		Difficulty difficulty = (Difficulty) cbDifficulty.getValue();
		Type type = (Type) cbType.getValue();
		
		Trail trail = new Trail(name, address, length, elevation, difficulty, type);
		tm.addTrail(trail);
		
		tfName.clear();
		tfHeadAddress.clear();
		tfLength.clear();
		tfElevation.clear();
		cbDifficulty.setValue(null);
		cbType.setValue(null);

		
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
		setChoices();
		
	}

}
