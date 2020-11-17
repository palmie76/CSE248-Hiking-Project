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
	TreeMap<String, User> userProfiles;
	
	public UserProfileTreeMap(){
		userProfiles = new TreeMap<String, User>();
		
	}
	/**
	 * returns true if TreeMap contains the specified user 
	 * @param user
	 * @return
	 */
	public boolean contains(User user) {
		return userProfiles.containsValue(user);
		
	}
	public void addProfile(User user){
		userProfiles.put(user.getUsername(), user);
	}
	/**
	 * adds a collection of UserProfiles to the TreeMap
	 * 
	 * @param profileCollection collection to be added to TreeMap
	 */
	public void addAllProfiles(Collection<User> profileCollection) {
		for(User p : profileCollection) {
			userProfiles.put(p.getUsername(), p);
		}
	}
	/**
	 * search TreeMap for specific UserProfile object
	 * 
	 * @param user UserProfile to be searched for
	 * @return LinkedList of all UserProfile objects which satisfy search
	 */
	public Collection<User> searchUserProfile(UserProfile user) {
		return userProfiles.values().stream().filter(p -> p.equals(user)).collect(Collectors.toCollection(LinkedList::new));
		
		
	}
	
	/**
	 * 
	 * search TreeMap for a UserProfile object by username
	 * @param username
	 * @return
	 */
	public User searchByUsername(String username) {
		return userProfiles.values().stream().filter(p -> p.getUsername().equals(username)).findFirst().get();
		
	}
	/**
	 * search TreeMap for a UserProfile object by password
	 * @param password
	 * @return
	 */
	public Collection<User> searchByPassword(String password){
		return userProfiles.values().stream().filter(p -> p.getPassword() == password).collect(Collectors.toCollection(LinkedList::new));
		
	}
	/**
	 * removes specified UserProfile object to be removed from the TreeMap
	 * 
	 * @param user UserProfile to be removed
	 * @return UserProfile which was removed from TreeMap
	 */
	public User deleteProfile(User user){
		return userProfiles.remove(user.getUsername());
	}
	/**
	 * removes UserProfile by username
	 * @param username
	 */
	public void deleteByUsername(String username) {
		if(userProfiles.containsKey(username)) {
			userProfiles.remove(username);
		}
	}

	@Override
	public String toString() {
		return userProfiles.entrySet().toString();
	}

	public TreeMap<String, User> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(TreeMap<String, User> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	
	
	

}
