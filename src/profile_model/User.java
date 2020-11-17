package profile_model;

public class User {
	String password;
	String username;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

}
