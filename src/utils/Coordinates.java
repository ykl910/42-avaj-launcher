package utils;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}
	public int getLongitude() {
		return longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public int getHeight() {
		return height;
	}
	public void updateLongitude(int n_long) {
		longitude += n_long;
	}
	public void updateLatitude(int n_lat) {
		latitude += n_lat;
	}
	public void updateHeight(int n_height) {
		height += n_height;
		if (height < 0)
			height = 0;
		if (height > 100)
			height = 100;
	}
}