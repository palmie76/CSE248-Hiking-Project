package trail_model;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import profile_model.UserProfile;

public class TrailTreeMap {
	TreeMap<Integer, Trail> trailMap;
	//LinkedList<Trail> helper;

	public TrailTreeMap() {
		trailMap = new TreeMap<Integer, Trail>();
		//helper = new LinkedList<>();
	}

	public void addTrail(Trail trail) {
		trailMap.put(trail.getTrailID(), trail);
		//helper.add(trail);
	}
	
	public void addAllTrails(Collection<Trail> trailCollection) {
		for(Trail t : trailCollection) {
			trailMap.put(t.getTrailID(), t);
		}
	}

	public void removeTrail(Trail trail) {
		trailMap.remove(trail.getTrailID());
		//helper.remove(trail);
	}
	
	
	
	@Override
	public String toString() {
		return "TrailTreeMap: " + trailMap.values().toString() + "\n";
	}

	public LinkedList<Trail> searchByID(int ID){
		return trailMap.values().stream().filter(p -> p.getTrailID() == ID).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getTrailID() == ID).findFirst().get();
		
//		if(trailMap.containsKey(ID)) {
//			return trailMap.get(ID);
//		}
//		return null;
		
	}
	
	public LinkedList<Trail> searchByName(String name){
		return trailMap.values().stream().filter(p -> p.getTrailName().equals(name)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getTrailName().equals(name)).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getTrailName().equals(name)) {
//				return set.getValue();
//			}
//		}
//		return null;
	}
	
	public LinkedList<Trail> searchByHeadAddress(String address){
		return trailMap.values().stream().filter(p -> p.getHeadAddress().equals(address)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getHeadAddress().equals(address)).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getHeadAddress().equals(address)) {
//				return set.getValue();
//			}
//		}
//		return null;
	}
	
	public LinkedList<Trail> searchByLength(int length){
		return trailMap.values().stream().filter(p -> p.getLength() == length).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getLength() == length).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getLength() == length) {
//				return set.getValue();
//			}
//		}
//		return null;
	}
	
	public LinkedList<Trail> searchByElevationGain(int elevationGain){
		return trailMap.values().stream().filter(p -> p.getElevationGain() == elevationGain).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getElevationGain() == elevationGain).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getElevationGain() == elevationGain) {
//				return set.getValue();
//			}
//		}
//		return null;
	}
	
	public LinkedList<Trail> searchByDifficulty(String difficulty){
		return trailMap.values().stream().filter(p -> p.getDifficulty().equals(difficulty)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailMap.values().stream().filter(p -> p.getDifficulty().equals(difficulty)).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getDifficulty().equals(difficulty)) {
//				return set.getValue();
//			}
//		}
//		return null;
	}
	
	public LinkedList<Trail> searchByType(String type){
		return trailMap.values().stream().filter(p -> p.getType().equals(type)).collect(Collectors.toCollection(LinkedList::new));

		
		//return trailMap.values().stream().filter(p -> p.getType().equals(type)).findFirst().get();
		
//		for(Map.Entry<Integer, Trail> set: trailMap.entrySet()) {
//			if(set.getValue().getType().equals(type)) {
//				return set.getValue();
//			}
//		}
//		return null;
		
	}

	public TreeMap<Integer, Trail> getTrailMap() {
		return trailMap;
	}

	public void setTrailMap(TreeMap<Integer, Trail> trailMap) {
		this.trailMap = trailMap;
	}
	
	
}
