package trail_model;
import java.util.LinkedList;

public class TrailStop implements Comparable<TrailStop>{
	private int altitude;
	private LinkedList<TrailPath> connections;
	private LinkedList<TrailStop> neighborsList;
	
	private int trailID;
	private static int TRAIL_ID = 0;
	
	
	public TrailStop(int altitude) {
		this.altitude = altitude;
		connections = new LinkedList<TrailPath>();
		neighborsList = new LinkedList<TrailStop>();
		trailID = getNextTrailID();
		
	}
	
	public void addConnection(TrailPath path) {
		connections.add(path);
	
	}
	
	public void addNeighbor(TrailStop stop) {
		neighborsList.add(stop);
	}
	
	public static int getNextTrailID() {
		return TRAIL_ID++;
	}
	
	public int getTrailID() {
		return trailID;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public LinkedList<TrailPath> getConnections() {
		return connections;
	}
	
	public LinkedList<TrailStop> getNeighbors() {
		return neighborsList;
	}

	public void setConnections(LinkedList<TrailPath> connections) {
		this.connections = connections;
	}

	@Override
	public int compareTo(TrailStop s) {
		if(this.trailID > s.getTrailID()) {
			return 1;
		}
		else if(this.trailID < s.getTrailID()) {
			return -1;
		}
		else
			return 0;
	}

	@Override
	public String toString() {
		return "TrailStop Altitude: " + altitude + " " + "Trail ID: " + trailID + "\n";
	}
	
	
	
	


}
