package history_model;
import java.util.LinkedList;

public class HikingHistoryStore {
	LinkedList<HikingHistory> hikingList;
	
	public HikingHistoryStore(){
		hikingList = new LinkedList<HikingHistory>();
	}
	
	public void addHike(HikingHistory hike){
		hikingList.add(hike);
	}
	
	public void deleteHike(HikingHistory hike) {
		hikingList.remove(hike);
	}

}
