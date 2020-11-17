package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import history_model.HikingHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import profile_model.User;
import profile_model.UserProfile;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;
import trail_model.TrailTreeMap;

public class UserProfileMainController implements Initializable {
	private UserProfile user; 
	private TrailTreeMap tm;
	ObservableList<String> options = FXCollections.observableArrayList("Name", "Head Address", "Length", "Elevation Gain", "Difficulty", "Type");
	static LinkedList<Trail> results;
	static LinkedList<Button> buttons;
	
	private LinkedList<Button> buttonsTrail;
	private Trail[] array;
	private static Trail trail;
	
	@FXML
	GridPane gridPane;
	@FXML
	Button btnAddHistory;
	@FXML
	Button btnBack;
	@FXML
	Button btnSearch;
	@FXML
	TextArea userText;
	@FXML
	TextArea hikingHistory;
	@FXML
	TextArea trailText;
	@FXML
	TextField tfSearch;
	@FXML
	ChoiceBox<String> cbSearch;
	
	public void setChoices() {
		cbSearch.getItems().setAll(options);
		cbSearch.getSelectionModel().selectFirst();
	}
	
	public void populateUser() {
		hikingHistory.appendText("My Hiking History: " + "\n");
		userText.appendText(user.toString());
		
		for(HikingHistory h : user.getHikingHistory().getHikingList()) {
		hikingHistory.appendText(h.toString() + "\n");
		}
		
	}
	
	public void search(ActionEvent e) throws IOException {
		String search = tfSearch.getText();
		buttons = new LinkedList<Button>();
		
		if(search.isEmpty()) {
			Alert a = new Alert(AlertType.WARNING);
			a.show();
		} else {
		switch (cbSearch.getValue()) {
		case "Name":
			results = tm.searchByName(search);
			break;
		case "Head Address":
			results = tm.searchByHeadAddress(search);
			break;
		case "Length":
			results = tm.searchByLength(Integer.parseInt(search));
			break;	
		case "Elevation Gain":
			results = tm.searchByElevationGain(Integer.parseInt(search));
		case "Difficulty":
			for(Difficulty d : TrailEnums.Difficulty.values()) {
				if(d.toString().toLowerCase().equals(search.toLowerCase())) {
					results = tm.searchByDifficulty(d);
					break;
				}else {
					System.out.println("Does not match difficulty");
				}
			}
			break;
		case "Type":
			for(Type t : TrailEnums.Type.values()) {
				if(t.toString().toLowerCase().equals(search.toLowerCase())) {
					results = tm.searchByType(t);
					break;
				} else {
					System.out.println("Does not match type");
				}
			}	
			break;
		}
		}
		
		//create button list
		for(int i = 0; i < results.size(); i++) {
			Button btn = new Button("Add");
			buttons.add(btn);
		}
		
		Parent root = FXMLLoader.load(getClass().getResource("TrailResultsUserView.fxml")); 
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
	
	public void addHistory(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddHistoryView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	//populate Trail Grid
	public void populateGridPane() {
		buttonsTrail = new LinkedList<Button>();
		array = new Trail[tm.getTrailMap().size()];
		tm.getTrailMap().values().toArray(array);

		for(int i = 0; i < array.length; i++) {
			int index = i;
			Button btn = new Button("Select");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						trail = (Trail) array[index];
						System.out.println("Clicked!");
						buttonAction(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			buttonsTrail.add(btn);
		}
		
		for(int i = 0; i < tm.getTrailMap().size(); i++) {
			Text ta = new Text(array[i].toString());
			gridPane.add(ta, 0, i);
			gridPane.add(buttonsTrail.get(i), 1, i);
		}
		
	}
	
	public void buttonAction(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TrailInfoUserView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();	
	}
	
	public static LinkedList<Trail> getList() {
		return results;
	}
	
	public static LinkedList<Button> getButtons(){
		return buttons;
	}
	
	public static Trail returnTrail() {
		return trail;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tm = Main.returnTrailMap();
		user = (UserProfile) Main.returnUser();
		populateGridPane();
		setChoices();
		populateUser();
//		populateTrails();
		
	}

}
