package profile_model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserProfileTreeMap {
	/**
	 * 
	 * Stores UserProfile in a TreeMap by <Username, UserProfile>
	 * 
	 */
	TreeMap<String, UserProfile> userProfiles;
	
	public UserProfileTreeMap(){
		userProfiles = new TreeMap<String, UserProfile>();
		
	}
	public void addProfile(UserProfile user){
		userProfiles.put(user.getUsername(), user);
	}
	/**
	 * adds a collection of UserProfiles to the TreeMap
	 * 
	 * @param profileCollection collection to be added to TreeMap
	 */
	public void addAllProfiles(Collection<UserProfile> profileCollection) {
		for(UserProfile p : profileCollection) {
			userProfiles.put(p.getUsername(), p);
		}
	}
	/**
	 * search TreeMap for specific UserProfile object
	 * 
	 * @param user UserProfile to be searched for
	 * @return LinkedList of all UserProfile objects which satisfy search
	 */
	public LinkedList<UserProfile> searchUserProfile(UserProfile user) {
		return userProfiles.values().stream().filter(p -> p.equals(user)).collect(Collectors.toCollection(LinkedList::new));
		
		
	}
	
	public UserProfile searchByUsername(String username) {
		return userProfiles.values().stream().filter(p -> p.getUsername() == username).findFirst().get();
		
	}
	
	public LinkedList<UserProfile> searchByPassword(String password){
		return userProfiles.values().stream().filter(p -> p.getPassword() == password).collect(Collectors.toCollection(LinkedList::new));
		
	}
	/**
	 * Removes specified UserProfile object to be removed from the TreeMap
	 * 
	 * @param user UserProfile to be removed
	 * @return UserProfile which was removed from TreeMap
	 */
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
