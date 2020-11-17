package JavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import profile_model.User;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailTreeMap;
import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;

public class AdminMainController implements Initializable {
	private UserProfileTreeMap up;
	private TrailTreeMap tm;
	private LinkedList<Button> buttonsTrail;
	private LinkedList<Button> buttonsUsers;
	private Trail[] array;
	private User[] arrayUsers;
	private UserProfile[] arrayUserProfiles;
	private static Trail trail;
	private static UserProfile user;
	
	@FXML
	GridPane gridPaneUsers;
	@FXML
	Button btnBack;
	@FXML
	Button btnCreateTrail;
	@FXML
	TextArea text;
	@FXML
	GridPane gridPane;
	
	@FXML
	TextField tfSearchTrail;
	@FXML
	ChoiceBox<String> cbSearchTrail;
	@FXML
	Button btnSearchTrail;
	@FXML
	Button btnSearchUsers;
	@FXML
	TextField tfSearchUsers;
	
	private static LinkedList<Trail> resultsTrail;
	private static User resultsUsers;
	
	ObservableList<String> options = FXCollections.observableArrayList("Name", "Head Address", "Length", "Elevation Gain", "Difficulty", "Type");
	
	public void setChoices() {
		cbSearchTrail.getItems().setAll(options);	
		cbSearchTrail.getSelectionModel().selectFirst();
	}
	
	public void searchUser(ActionEvent e) throws IOException {
		String search = tfSearchUsers.getText();
		resultsUsers = up.searchByUsername(search);
		
		Parent root = FXMLLoader.load(getClass().getResource("UserSearchAdminView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public static User getResultsUser() {
		return resultsUsers;
	}
	
	public void searchTrail(ActionEvent e) throws IOException {
		String search = tfSearchTrail.getText();
		
		if(search.isEmpty()) {
			Alert a = new Alert(AlertType.WARNING);
			a.show();
		} else {
		switch (cbSearchTrail.getValue()) {
		case "Name":
			resultsTrail = tm.searchByName(search);
			break;
		case "Head Address":
			resultsTrail = tm.searchByHeadAddress(search);
			break;
		case "Length":
			resultsTrail = tm.searchByLength(Integer.parseInt(search));
			break;	
		case "Elevation Gain":
			resultsTrail = tm.searchByElevationGain(Integer.parseInt(search));
		case "Difficulty":
			for(Difficulty d : TrailEnums.Difficulty.values()) {
				if(d.toString().toLowerCase().equals(search.toLowerCase())) {
					resultsTrail = tm.searchByDifficulty(d);
					break;
				}else {
					System.out.println("Does not match difficulty");
				}
			}
			break;
		case "Type":
			for(Type t : TrailEnums.Type.values()) {
				if(t.toString().toLowerCase().equals(search.toLowerCase())) {
					resultsTrail = tm.searchByType(t);
					break;
				} else {
					System.out.println("Does not match type");
				}
			}	
			break;
		}
		}
		
		Parent root = FXMLLoader.load(getClass().getResource("TrailSearchAdminView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public static LinkedList<Trail> getTrailResults(){
		return resultsTrail;
	}
	
	public void goBack(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogInView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	public void createTrail(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("CreateTrailView.fxml")); 
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	public void buttonAction(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EditTrailView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();	
	}
	
	public void buttonActionUser(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EditUserView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();	
	}
	
	//populate Users
	public void populateGridPaneUsers() {
		LinkedList<UserProfile> helper = new LinkedList<UserProfile>();
		arrayUsers = new User[up.getUserProfiles().size()];
		up.getUserProfiles().values().toArray(arrayUsers);
		buttonsUsers = new LinkedList<Button>();
		
		for(User u : arrayUsers) {
			if(u instanceof UserProfile) {
				helper.add((UserProfile) u);
			}
		}
		
		arrayUserProfiles = helper.toArray(new UserProfile[helper.size()]);
		
		
		for(int i = 0; i < arrayUserProfiles.length; i++) {
		//	if(arrayUserProfiles[i] instanceof UserProfile) {
			int index = i;
			Button btn = new Button("Select");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					try {
						user = (UserProfile) arrayUserProfiles[index];
						buttonActionUser(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			buttonsUsers.add(btn);
			
			Text ta = new Text("Username: " + arrayUserProfiles[i].getUsername());
			gridPaneUsers.add(ta, 0, i);
			gridPaneUsers.add(buttonsUsers.get(i), 1, i);
			
			
			
		}
		}
	//	}


	
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
						EditTrailController.setTrail(trail);
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
		
		for(int i = 0; i < array.length; i++) {
			Text ta = new Text(array[i].toString());
			gridPane.add(ta, 0, i);
			gridPane.add(buttonsTrail.get(i), 2, i);
		}
		
	}
	
	public static Trail returnTrail() {
		return trail;
	}
	
	public static UserProfile returnUser() {
		return user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		up = Main.returnUserMap();
		tm = Main.returnTrailMap();
		setChoices();
		populateGridPane();
		populateGridPaneUsers();
	

	}


}
