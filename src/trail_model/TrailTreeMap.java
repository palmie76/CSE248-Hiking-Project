package trail_model;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import profile_model.UserProfile;
import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;

public class TrailTreeMap {
	/**
	 * 
	 * Stores Trails in a TreeMap by <ID, Trail>
	 * 
	 */
	TreeMap<Integer, Trail> trailMap;

/** 
 * constructor which creates new, empty TreeMap
 */
	public TrailTreeMap() {
		trailMap = new TreeMap<Integer, Trail>();

	}
	
	
/**
 * 
 * adds Trail to TreeMap by ID, Trail
 * @param trail Trail object to be added
 */
	public void addTrail(Trail trail) {
		trailMap.put(trail.getTrailID(), trail);

	}
	
	/** 
	 * 
	 * adds a collection of Trail objects to the TreeMap
	 * @param trailCollection collections of Trail objects to be added
	 */
	public void addAllTrails(Collection<Trail> trailCollection) {
		for(Trail t : trailCollection) {
			trailMap.put(t.getTrailID(), t);
		}
	}
	/**
	 * 
	 * removes Trail from TreeMap
	 * @param trail
	 */
	public void removeTrail(Trail trail) {
		trailMap.remove(trail.getTrailID());

	}
	
	
	
	@Override
	public String toString() {
		return "TrailTreeMap: " + trailMap.values().toString() + "\n";
	}
	
	/**
	 * search for a specific Trail object by Trail ID 
	 * @param ID of Trail to be searched for
	 * @return Trail which satisfies search.  As TreeMap is sorted by TrailID and TreeMap cannot contain duplicates, should only return one Trail object if found
	 */
	public Trail searchByID(int ID){
		return trailMap.values().stream().filter(p -> p.getTrailID() == ID).findAny().get();
	
		
	}
	
	public LinkedList<Trail> searchByName(String name){
		return trailMap.values().stream().filter(p -> p.getTrailName().equals(name)).collect(Collectors.toCollection(LinkedList::new));

	}
	
	public LinkedList<Trail> searchByHeadAddress(String address){
		return trailMap.values().stream().filter(p -> p.getHeadAddress().equals(address)).collect(Collectors.toCollection(LinkedList::new));
		
	}
	
	public LinkedList<Trail> searchByLength(int length){
		return trailMap.values().stream().filter(p -> p.getLength() == length).collect(Collectors.toCollection(LinkedList::new));
		
	}
	
	public LinkedList<Trail> searchByElevationGain(int elevationGain){
		return trailMap.values().stream().filter(p -> p.getElevationGain() == elevationGain).collect(Collectors.toCollection(LinkedList::new));
	
	}
	
	public LinkedList<Trail> searchByDifficulty(Difficulty difficulty){
		return trailMap.values().stream().filter(p -> p.getDifficulty().equals(difficulty)).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public LinkedList<Trail> searchByType(Type type){
		return trailMap.values().stream().filter(p -> p.getType().equals(type)).collect(Collectors.toCollection(LinkedList::new));
		
	}

	public TreeMap<Integer, Trail> getTrailMap() {
		return trailMap;
	}

	public void setTrailMap(TreeMap<Integer, Trail> trailMap) {
		this.trailMap = trailMap;
	}
	
	
}
