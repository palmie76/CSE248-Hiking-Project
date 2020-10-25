package profile_model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UserProfileTreeSet {
	TreeSet<UserProfile> userProfiles;
	
	public UserProfileTreeSet(){
		userProfiles = new TreeSet<UserProfile>();
		
	}
	
	public void addProfile(UserProfile user){
		userProfiles.add(user);

	}
	
	
	public void addAllProfiles(Collection<UserProfile> profileCollection) {
		userProfiles.addAll(profileCollection);
		}

	
	public LinkedList<UserProfile> searchUserProfile(UserProfile user) {
		return userProfiles.stream().filter(p -> p.equals(user)).collect(Collectors.toCollection(LinkedList::new));
		
	}
	
	public UserProfile searchByUsername(UserProfile user) {
		return userProfiles.stream().filter(p -> p.getUsername() == user.getUsername()).findFirst().get();
		
		
	}
	
	public LinkedList<UserProfile> searchByPassword(UserProfile user){
		return userProfiles.stream().filter(p -> p.getPassword() == user.getPassword()).collect(Collectors.toCollection(LinkedList::new));
		
	}
	
	public boolean deleteProfile(UserProfile user){
		return userProfiles.remove(user);
	}

	@Override
	public String toString() {
		return userProfiles.toString() + "\n";
	}

	public TreeSet<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(TreeSet<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	
	
	
		
		
}
