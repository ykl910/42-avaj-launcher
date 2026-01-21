package utils;

import utils.Coordinates;

public class WeatherProvider {
	
	private String[] weather = {"RAIN", "SUN", "FOG", "SNOW"};
	private static WeatherProvider instance;
	private WeatherProvider() {};
	public static WeatherProvider getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}
	public String getCurrentWeather(Coordinates p_coordinates) {
		int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
		return weather[seed % 4];
	}
}