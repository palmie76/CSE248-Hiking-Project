package trail_model;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;

import trail_model.TrailEnums.Difficulty;

public class TrailTreeSet {
	TreeSet<Trail> trailSet;
//	LinkedList<Trail> helper;


	public TrailTreeSet(){
		trailSet = new TreeSet<Trail>();
		//helper = new LinkedList<>();
	}
	

	public void addTrail(Trail trail){
		trailSet.add(trail);
		//helper.add(trail);
	}
	
	public void addAllTrails(Collection<Trail> trailCollection) {
		trailSet.addAll(trailCollection);
		
	}
	
	public void removeTrail(Trail trail){
		trailSet.remove(trail);
		//helper.remove(trail);
	}
	
	
	
	@Override
	public String toString() {
		return "TrailTreeSet: " + trailSet.toString() + "\n";
	}


	public LinkedList<Trail> searchByID(int ID){
		return trailSet.stream().filter(p -> p.getTrailID() == ID).collect(Collectors.toCollection(LinkedList::new));
	
		//return trailSet.stream().filter(p -> p.getTrailID() == ID).findAny().get();
		
//		for(Trail t: trailSet) {
//			if(t.getTrailID() == ID) {
//				return t;
//			}
//		}
//		
//		return null;
//		
	}
	
	public LinkedList<Trail> searchByName(String name){
		return trailSet.stream().filter(p -> p.getTrailName().equals(name)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailSet.stream().filter(p -> p.getTrailName().equals(name)).findFirst().get();
		
//		for(Trail t: trailSet) {
//			if(t.getTrailName().equals(name)) {
//				return t;
//			}
//		}
//		
//		return null;
	}
	
	public LinkedList<Trail> searchByHeadAddress(String address){
		return trailSet.stream().filter(p -> p.getHeadAddress().equals(address)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailSet.stream().filter(p -> p.getHeadAddress().equals(address)).findFirst().get();
		
//		for(Trail t: trailSet) {
//			if(t.getHeadAddress().equals(address)) {
//				return t;
//			}
//		}
//		
//		return null;
	}
	
	public LinkedList<Trail> searchByLength(int length){
		return trailSet.stream().filter(p -> p.getLength() == length).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailSet.stream().filter(p -> p.getLength() == length).findFirst().get();

//		for(Trail t: trailSet) {
//			if(t.getLength() == length) {
//				return t;
//			}
//		}
//		
//		return null;
		
	}
	
	public LinkedList<Trail> searchByElevationGain(int elevationGain){
		return trailSet.stream().filter(p -> p.getElevationGain() == elevationGain).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailSet.stream().filter(p -> p.getElevationGain() == elevationGain).findFirst().get();
		
//		for(Trail t: trailSet) {
//			if(t.getElevationGain() == elevationGain) {
//				return t;
//			}
//		}
//		
//		return null;
		
	}
	
	public LinkedList<Trail> searchByDifficulty(Difficulty difficulty){
		return trailSet.stream().filter(p -> p.getDifficulty().equals(difficulty)).collect(Collectors.toCollection(LinkedList::new));
		
	//	return trailSet.stream().filter(p -> p.getDifficulty().equals(difficulty)).findFirst().get();
		
//		for(Trail t: trailSet) {
//			if(t.getDifficulty().equals(difficulty)) {
//				return t;
//			}
//		}
//		
//		return null;
	}
	
	
	
	public TreeSet<Trail> getTrailSet() {
		return trailSet;
	}


	public void setTrailSet(TreeSet<Trail> trailSet) {
		this.trailSet = trailSet;
	}


	public LinkedList<Trail> searchByType(String type){
		return trailSet.stream().filter(p -> p.getType().equals(type)).collect(Collectors.toCollection(LinkedList::new));
		
		//return trailSet.stream().filter(p -> p.getType().equals(type)).findFirst().get();
		
//		for(Trail t: trailSet) {
//			if(t.getType().equals(type)) {
//				return t;
//			}
//		}
//		
//		return null;
	}
	
//	Trail search(String type, String data) {
//		
//	}
}




