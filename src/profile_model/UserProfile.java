package profile_model;

import history_model.HikingHistory;
import history_model.HikingHistoryStore;

public class UserProfile extends User implements Comparable<UserProfile>{
//	private String username;
//	private String password;
	private String profilePicture;
	private HikingHistoryStore hikingHistoryStore;
	
	/**
	 * creates UserProfile object which will have restricted access of GUI portion of program
	 * creates new, empty HikingHistoryStore which can be filled by by the user in GUI portion
	 * @param username
	 * @param password
	 * @param profilePicture
	 */
	public UserProfile(String username, String password, String profilePicture){
		super(username, password);
		this.profilePicture = profilePicture;
		hikingHistoryStore = new HikingHistoryStore();
		
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public HikingHistoryStore getHikingHistory() {
		return hikingHistoryStore;
	}

	public void setHikingHistory(HikingHistoryStore hikingHistoryStore) {
		this.hikingHistoryStore = hikingHistoryStore;
	}

	@Override
	public int compareTo(UserProfile user) {
		return this.username.compareTo(user.getUsername());
	
	}

	@Override
	public String toString() {
		return "Username: " + username + ", Photos: " + profilePicture + "\n";
	}


	public void addHistory(HikingHistory history) {
		hikingHistoryStore.addHike(history);
		
	}
	
	
	

}
