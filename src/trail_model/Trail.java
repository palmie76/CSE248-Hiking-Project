package trail_model;

public class Trail implements Comparable<Trail>{
	String trailName;
	String headAddress;
	int length;
	int elevationGain;
	String difficulty;
	String type;
	TrailGraph trailGraph;
	int trailID;
	private static int TRAIL_ID = 0;
	
	public Trail(String trailName, String headAddress, int length, int elevationGain, String difficulty, String type/*, TrailGraph trailGraph*/){
		this.trailName = trailName;
		this.headAddress = headAddress;
		this.length = length;
		this.elevationGain = elevationGain;
		this.difficulty = difficulty;
		this.type = type;
		//this.trailGraph = trailGraph;
		
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

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
//		return(this.trailName.compareTo(trail.getTrailName());
	}

	@Override
	public String toString() {
		return "Trail trailName=" + trailName + ", trailID=" + trailID + "\n";
	}
	
	
	
	

}
