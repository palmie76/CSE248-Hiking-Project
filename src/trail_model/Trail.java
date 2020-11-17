package trail_model;

import trail_model.TrailEnums.Difficulty;
import trail_model.TrailEnums.Type;

public class Trail implements Comparable<Trail>{
	private String trailName;
	private String headAddress;
	private int length;
	private int elevationGain;
	private Difficulty difficulty;
	private Type type;
	private TrailGraph trailGraph;
	private int trailID;
	private static int TRAIL_ID = 0;
	
	/**
	 * 
	 * constructs new Trail object representing the given parameters and assigns a unique ID
	 * @param trailName 
	 * @param headAddress 
	 * @param length
	 * @param elevationGain
	 * @param difficulty
	 * @param type
	 */
	public Trail(String trailName, String headAddress, int length, int elevationGain, TrailEnums.Difficulty difficulty, TrailEnums.Type type){
		this.trailName = trailName;
		this.headAddress = headAddress;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficulty = difficulty;
		this.type = type;
		trailGraph = new TrailGraph();
		
		trailID = getNextTrailID();
		
	}
	
	public static int getNextTrailID() {
		return TRAIL_ID++;
	}
	
	public int getTrailID() {
		return trailID;
	}

	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public String getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getElevationGain() {
		return elevationGain;
	}

	public void setElevationGain(int elevationGain) {
		this.elevationGain = elevationGain;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TrailGraph getTrailGraph() {
		return trailGraph;
	}

	public void setTrailGraph(TrailGraph trailGraph) {
		this.trailGraph = trailGraph;
	}

	@Override
	public int compareTo(Trail trail) {
		if(this.trailID > trail.getTrailID()) {
			return 1;
		}
		else if(this.trailID < trail.getTrailID()) {
			return -1;
		}
		else
			return 0;

	}

	@Override
	public String toString() {
		return "Trail Name: " + trailName + ", ID: " + trailID + "\n";
	}
	
	
	
	

}
