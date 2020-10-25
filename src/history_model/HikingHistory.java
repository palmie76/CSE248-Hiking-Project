package history_model;
import java.time.LocalDateTime;

public class HikingHistory implements Comparable<HikingHistory> {
	String trailName;
	int distance;
	int duration;
	String picturesTaken;
	double averagePace;
	LocalDateTime dateAndTime;

	public HikingHistory(String trailName, int distance, int duration, String picturesTaken, double averagePace,
			LocalDateTime dateAndTime) {
		this.trailName = trailName;
		this.distance = distance;
		this.duration = duration;
		this.picturesTaken = picturesTaken;
		this.averagePace = averagePace;
		this.dateAndTime = dateAndTime;
		
	}

	public String getTrailName() {
		return trailName;
	}

	public void setTrailName(String trailName) {
		this.trailName = trailName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPicturesTaken() {
		return picturesTaken;
	}

	public void setPicturesTaken(String picturesTaken) {
		this.picturesTaken = picturesTaken;
	}

	public double getAveragePace() {
		return averagePace;
	}

	public void setAveragePace(double averagePace) {
		this.averagePace = averagePace;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	@Override
	public int compareTo(HikingHistory history) {
		return this.dateAndTime.compareTo(history.getDateAndTime());

	}

}
