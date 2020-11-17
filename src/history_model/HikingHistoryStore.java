package history_model;
import java.util.LinkedList;

public class HikingHistoryStore {
	private LinkedList<HikingHistory> hikingList;
	
	/**
	 * 
	 * constructs a HikingHistoryStore which contains HikingHistory objects in a LinkedList
	 */
	public HikingHistoryStore(){
		hikingList = new LinkedList<HikingHistory>();
	}
	
	public void addHike(HikingHistory hike){
		hikingList.add(hike);
	}
	
	public void deleteHike(HikingHistory hike) {
		hikingList.remove(hike);
	}
	
	public LinkedList<HikingHistory> getHikingList(){
		return this.hikingList;
	}

}
