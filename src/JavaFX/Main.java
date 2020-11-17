package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import profile_model.Admin;
import profile_model.User;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailPath;
import trail_model.TrailStop;
import trail_model.TrailTreeMap;

public class Main extends Application{
	private static UserProfileTreeMap up;
	private static TrailTreeMap tm;
	private static User user;


	public static void main(String[] args) {
		launch(args);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		up = new UserProfileTreeMap();
		tm = new TrailTreeMap();
		
		//*** dummy data********
		Admin a = new Admin("abc", "123");
		UserProfile u = new UserProfile("123", "abc", "b");
		UserProfile u2 = new UserProfile("y", "abc", "b");
		UserProfile u3 = new UserProfile("x", "abc", "b");
		UserProfile u4 = new UserProfile("z", "abc", "b");
		up.addProfile(a);
		up.addProfile(u);
		up.addProfile(u2);
		up.addProfile(u3);
		up.addProfile(u4);
		Trail t = new Trail("a", "b", 1, 2, TrailEnums.Difficulty.EASY, TrailEnums.Type.LOOP);
		Trail t2 = new Trail("a", "z", 2, 1, TrailEnums.Difficulty.EASY, TrailEnums.Type.OUT_AND_BACK);
		Trail t3 = new Trail("a", "z", 2, 1, TrailEnums.Difficulty.EASY, TrailEnums.Type.OUT_AND_BACK);
		Trail t4 = new Trail("a", "z", 2, 1, TrailEnums.Difficulty.EASY, TrailEnums.Type.OUT_AND_BACK);
		TrailStop s1 = new TrailStop(5);
		TrailStop s2 = new TrailStop(6);
		t.getTrailGraph().addStop(s1);
		t.getTrailGraph().addStop(s2);
		t.getTrailGraph().addEdge(new TrailPath(s1, s2, 10));
		tm.addTrail(t);
		tm.addTrail(t2);
		tm.addTrail(t3);
		tm.addTrail(t4);
		//*************************
		
		Parent root = FXMLLoader.load(getClass().getResource("LogInView.fxml")); 
		Scene scene = new Scene(root, 400, 200);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	public static UserProfileTreeMap returnUserMap() {
		return up;
	}
	
	public static void setUserProfileTreeMap(UserProfileTreeMap newUserProfileTreeMap) {
		up = newUserProfileTreeMap;
	}
	
	public static TrailTreeMap returnTrailMap() {
		return tm;
	}
	
	public static User returnUser() {
		return user;
	}
	
	public static void setUser(User u) {
		user = u;
	}

}
