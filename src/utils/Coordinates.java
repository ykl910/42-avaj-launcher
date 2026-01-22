package utils;

import utils.InvalidCoorException;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		if (p_longitude < -180 || p_longitude > 180)
			throw new InvalidCoorException("Invalid longtitude: " + p_longitude);
		if (p_latitude < -90 || p_latitude > 90)
			throw new InvalidCoorException("Invalid latitude: " + p_latitude);
		if (p_height < 0 || p_height > 100)
			throw new InvalidCoorException("Invalid height: " + p_height);
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