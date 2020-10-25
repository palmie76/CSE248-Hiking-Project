package trail_model;

public class TrailPath implements Comparable<TrailPath>{
	private TrailStop stop1;
	private TrailStop stop2;
	private int distance;
	
	public TrailPath(TrailStop stop1, TrailStop stop2, int distance){
		this.stop1 = stop1;
		this.stop2 = stop2;
		this.distance = distance;
		

		
	}

	public TrailStop getStop1() {
		return stop1;
	}

	public void setStop1(TrailStop stop1) {
		this.stop1 = stop1;
	}

	public TrailStop getStop2() {
		return this.stop2;
	}

	public void setEnd(TrailStop stop2) {
		this.stop2 = stop2;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TrailPath-- start: " + stop1.getTrailID() + " end: " + stop2.getTrailID() + " distance: " + distance + "\n";
	}

	@Override
	public int compareTo(TrailPath p) {
		if(this.distance > p.getDistance()) {
			return 1;
		}
		else if(this.distance < p.getDistance()) {
			return -1;
		}
		else
			return 0;
	}
	
	
}
