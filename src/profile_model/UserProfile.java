package profile_model;

import history_model.HikingHistory;

public class UserProfile implements Comparable<UserProfile>{
	String username;
	String password;
	String profilePicture;
	HikingHistory hikingHistory;
	
	public UserProfile(String username, String password, String profilePicture, HikingHistory hikingHistory){
		this.username = username;
		this.password = password;
		this.profilePicture = profilePicture;
		this.hikingHistory = hikingHistory;
		
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

	public HikingHistory getHikingHistory() {
		return hikingHistory;
	}

	public void setHikingHistory(HikingHistory hikingHistory) {
		this.hikingHistory = hikingHistory;
	}

	@Override
	public int compareTo(UserProfile user) {
		return this.username.compareTo(user.getUsername());
	
	}

	@Override
	public String toString() {
		return "UserProfile username=" + username + ", password=" + password + ", profilePicture=" + profilePicture
				+ ", hikingHistory=" + hikingHistory + "\n";
	}
	
	
	

}
