package GUI_components;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Random;

import history_model.HikingHistory;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import profile_model.UserProfileTreeSet;
import trail_model.Trail;
import trail_model.TrailTreeMap;
import trail_model.TrailTreeSet;
import utilities.Utilities;

public class SystemController {

	Stage stage;
	Scene scene1;
	Scene scene2;
	Scene scene3;
	
	PlotViewUserProfile plotViewUserProfile;
	PlotViewTrail plotViewTrail;
	MainView mainView;
	
	long[][] resultsTrail;
	long[][] resultsProfile;
	
//	HikingHistory historyTarget = new HikingHistory("A", 1, 2, "B", 1.0, LocalDateTime.now());
//	UserProfile userTarget = new UserProfile("A", "B", "C", historyTarget);
//	Trail trailTarget = new Trail("A", "B", 1, 2, "C", "D");
	Utilities ut = new Utilities();



	
	SystemController(Stage stage) {
		this.stage = stage;
		this.plotViewUserProfile = new PlotViewUserProfile();
		this.plotViewTrail = new PlotViewTrail();
		this.mainView = new MainView();
		
		this.scene1 = new Scene(this.mainView, 300, 200);
		this.scene2 = new Scene(this.plotViewUserProfile, 600, 700);
		this.scene3 = new Scene(this.plotViewTrail, 600, 700);


		buttonFunctions();
		getDataProfile();
		getDataTrail();
		plotViewProfile();
		plotViewTrail();
		
		stage.setScene(scene1);
		
		
	}
	
	void buttonFunctions() {
		mainView.btnProfile.setOnAction((ActionEvent e) -> {
			stage.setScene(scene2);
		});
		
		mainView.btnTrail.setOnAction((ActionEvent e) -> {
			stage.setScene(scene3);
			
		});
		
		plotViewUserProfile.btnBack.setOnAction((ActionEvent e) -> {
			stage.setScene(scene1);
			
		});
		
		plotViewTrail.btnBack.setOnAction((ActionEvent e) -> {
			stage.setScene(scene1);
			
		});
		
	}
	
	void getDataProfile() {
		resultsProfile = new long[10][2];

		int limit = 10;
		
		for(int i = 0; i < resultsProfile.length; i++) {
			UserProfileTreeMap tm = ut.emitUserProfilesTreeMap(limit);
			Random generator1 = new Random();
			Object[] values1 = tm.getUserProfiles().values().toArray();
			UserProfile randomValue1 = (UserProfile) values1[generator1.nextInt(values1.length)];
			
			UserProfileTreeSet ts = ut.emitUserProfilesTreeSet(limit);
			Random generator2 = new Random();
			Object[] values2 = ts.getUserProfiles().toArray();
			UserProfile randomValue2 = (UserProfile) values2[generator2.nextInt(values2.length)];
			
			long startMap = System.currentTimeMillis();
			profileMapMethods(tm, randomValue1);
			long resultMap = System.currentTimeMillis() - startMap;
			
	
			long startSet = System.currentTimeMillis();
			profileSetMethods(ts, randomValue2);
			long resultSet = System.currentTimeMillis() - startSet;
		
			resultsProfile[i][0] = resultMap;
			resultsProfile[i][1] = resultSet;
			limit = limit * 3;
		
		}
		}
	
	void getDataTrail() {
		resultsTrail = new long[10][2];
		int limit = 10;
		
		for(int i = 0; i < resultsTrail.length; i++) {
			TrailTreeMap tm = ut.emitTrailsTreeMap(limit);
			Random generator1 = new Random();
			Object[] values1 = tm.getTrailMap().values().toArray();
			Trail randomValue1 = (Trail) values1[generator1.nextInt(values1.length)];
			
			TrailTreeSet ts = ut.emitTrailsTreeSet(limit);
			Random generator2 = new Random();
			Object[] values2 = ts.getTrailSet().toArray();
			Trail randomValue2 = (Trail) values2[generator2.nextInt(values2.length)];
			
			long startMap = System.currentTimeMillis();
			trailMapMethods(tm, randomValue1);
			long resultMap = System.currentTimeMillis() - startMap;
			
			long startSet = System.currentTimeMillis();
			trailSetMethods(ts, randomValue2);
			long resultSet = System.currentTimeMillis() - startSet;
		
			resultsTrail[i][0] = resultMap;
			resultsTrail[i][1] = resultSet;
			limit = limit * 3;
		
		}
	}
	
	
	void plotViewProfile(){
		int increment = 10;
		for(int i = 0; i < 10; i++) {
			plotViewUserProfile.resultMap.getData().add(new XYChart.Data(increment, resultsProfile[i][0]));
			plotViewUserProfile.resultSet.getData().add(new XYChart.Data(increment, resultsProfile[i][1]));
			increment = increment * 3;
		}
	}
	
	void plotViewTrail(){
		int increment = 10;
		for(int i = 0; i < 10; i++) {
			plotViewTrail.resultMap.getData().add(new XYChart.Data(increment, resultsTrail[i][0]));
			plotViewTrail.resultSet.getData().add(new XYChart.Data(increment, resultsTrail[i][1]));
			increment = increment * 3;
		}
	}
	
	
	void profileMapMethods(UserProfileTreeMap um, UserProfile target){
		LinkedList<UserProfile> key = um.searchUserProfile(target);
		LinkedList<UserProfile> keyPassword = um.searchByPassword(target.getPassword());
		UserProfile keyUsername = um.searchByUsername(target.getUsername());
		um.deleteProfile(target);
		um.addProfile(target);
		
	
	}
	
	void profileSetMethods(UserProfileTreeSet us, UserProfile target){
		LinkedList<UserProfile> key = us.searchUserProfile(target);
		LinkedList<UserProfile> keyPassword = us.searchByPassword(target);
		UserProfile keyUsername = us.searchByUsername(target);
		us.deleteProfile(target);
		us.addProfile(target);
		
	}
	
	void trailMapMethods(TrailTreeMap tm, Trail trailTarget) {
		Trail keyID = tm.searchByID(trailTarget.getTrailID());
		LinkedList<Trail> keyName = tm.searchByName(trailTarget.getTrailName());
		LinkedList<Trail> keyHead = tm.searchByHeadAddress(trailTarget.getHeadAddress());
		LinkedList<Trail> keyLength = tm.searchByLength(trailTarget.getLength());
		LinkedList<Trail> keyDifficulty = tm.searchByDifficulty(trailTarget.getDifficulty());
		tm.removeTrail(trailTarget);
		tm.addTrail(trailTarget);
		
	
	}
	
	void trailSetMethods(TrailTreeSet ts, Trail trailTarget) {
		LinkedList<Trail> keyID = ts.searchByID(trailTarget.getTrailID());
		LinkedList<Trail> keyName = ts.searchByName(trailTarget.getTrailName());
		LinkedList<Trail> keyHead = ts.searchByHeadAddress(trailTarget.getHeadAddress());
		LinkedList<Trail> keyLength = ts.searchByLength(trailTarget.getLength());
		LinkedList<Trail> keyDifficulty = ts.searchByDifficulty(trailTarget.getDifficulty());
		ts.removeTrail(trailTarget);

		
	}
	
	public void start() {
		stage.show();
	}
}
