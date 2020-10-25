package profile_model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserProfileTreeMap {
	TreeMap<String, UserProfile> userProfiles;
	
	public UserProfileTreeMap(){
		userProfiles = new TreeMap<String, UserProfile>();
		
	}
	
	public void addProfile(UserProfile user){
		userProfiles.put(user.getUsername(), user);
	}
	
	public void addAllProfiles(Collection<UserProfile> profileCollection) {
		for(UserProfile p : profileCollection) {
			userProfiles.put(p.getUsername(), p);
		}
	}
	
	public LinkedList<UserProfile> searchUserProfile(UserProfile user) {
		return userProfiles.values().stream().filter(p -> p.equals(user)).collect(Collectors.toCollection(LinkedList::new));
		
		//return userProfiles.values().stream().filter(p -> p.equals(user)).findFirst().get();
		
	}
	
	public UserProfile searchByUsername(UserProfile user) {
		return userProfiles.values().stream().filter(p -> p.getUsername() == user.getUsername()).findFirst().get();
		
	}
	
	public LinkedList<UserProfile> searchByPassword(UserProfile user){
		return userProfiles.values().stream().filter(p -> p.getPassword() == user.getPassword()).collect(Collectors.toCollection(LinkedList::new));
		
	}
	
	public UserProfile deleteProfile(UserProfile user){
		return userProfiles.remove(user.getUsername());
	}

	@Override
	public String toString() {
		return userProfiles.entrySet().toString();
	}

	public TreeMap<String, UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(TreeMap<String, UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	
	
	

}
