package utilities;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Random;

import history_model.HikingHistory;
import history_model.HikingHistoryStore;
import profile_model.UserProfile;
import profile_model.UserProfileTreeMap;
import profile_model.UserProfileTreeSet;
import trail_model.Trail;
import trail_model.TrailEnums;
import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;
import trail_model.TrailTreeMap;
import trail_model.TrailTreeSet;

public class Utilities {
	private String canditateChars;
	 
	public Utilities(){
		canditateChars = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");

		
	}
	
	public UserProfileTreeMap emitUserProfilesTreeMap(int num){
		UserProfileTreeMap userProfileTreeMap = new UserProfileTreeMap();
		for(int i = 0; i < num; i++){
			userProfileTreeMap.addProfile(createUserProfile());
			
		}
		return userProfileTreeMap;
		
	}
	
	public UserProfileTreeSet emitUserProfilesTreeSet(int num){
		UserProfileTreeSet userProfileTreeSet = new UserProfileTreeSet();
		for(int i = 0; i < num; i++){
			userProfileTreeSet.addProfile(createUserProfile());
			
		}
		return userProfileTreeSet;
		
	}
	
	public HikingHistoryStore emitHikingHistories(int num){
		HikingHistoryStore hikingHistoryBag = new HikingHistoryStore();
		for(int i = 0; i < num; i++){
			hikingHistoryBag.addHike(createHikingHistory());
			
		}
		return hikingHistoryBag;
		
	}
	
	public TrailTreeMap emitTrailsTreeMap(int num){
		TrailTreeMap trailTreeMap = new TrailTreeMap();
		for(int i = 0; i < num; i++){
			trailTreeMap.addTrail(createTrail());
		}
		return trailTreeMap;
	}
	
	public TrailTreeSet emitTrailsTreeSet(int num){
		TrailTreeSet trailTreeSet = new TrailTreeSet();
		for(int i = 0; i < num; i++){
			trailTreeSet.addTrail(createTrail());
			
		}
		return trailTreeSet;
	}
	
	//create random classes
	public HikingHistory createHikingHistory(){
		return new HikingHistory(emitRandomString(), emitRandomInt(), emitRandomInt(), emitRandomString(), emitRandomDouble(), LocalDateTime.now());
	

	}
	
	public HikingHistoryStore createHikingHistoryStore(){
		HikingHistoryStore hhs = new HikingHistoryStore();
		HikingHistory hh = new HikingHistory(emitRandomString(), emitRandomInt(), emitRandomInt(), emitRandomString(), emitRandomDouble(), LocalDateTime.now());
		hhs.addHike(hh);
		return hhs;
	}
	
	public UserProfile createUserProfile(){
		UserProfile up = new UserProfile(Double.toString(emitRandomDouble()), emitRandomString(), emitRandomString());
		up.setHikingHistory(createHikingHistoryStore());
		return up;
			
	}
	
	public Trail createTrail(){
		return new Trail(emitRandomString(), emitRandomString(), emitRandomInt(), emitRandomInt(), emitRandomDifficulty(), emitRandomType());
		
		
	}
	
	//create random data
	public String emitRandomString() {
		Random random = new Random();
		return Character.toString(canditateChars.charAt(random.nextInt(canditateChars.length())));
	}
	
	public int emitRandomInt() {
		return (int)(Math.random() * 100);
	}
	
	public double emitRandomDouble() {
		return Math.random() * 100;
	
	}
	
	public Type emitRandomType() {
		Random random = new Random();
		int x = random.nextInt(TrailEnums.Type.values().length);
        return TrailEnums.Type.values()[x];
	}
	
	public Difficulty emitRandomDifficulty() {
		Random random = new Random();
		int x = random.nextInt(TrailEnums.Difficulty.values().length);
        return TrailEnums.Difficulty.values()[x];
	}

}
