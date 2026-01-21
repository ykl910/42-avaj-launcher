package flyables;

import utils.Coordinates;
import tower.WeatherTower;
import aircraft.Aircraft;

public class Helicopter extends Aircraft implements Flyable  {

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				System.out.println("Helicopter#" + name + "(" + id + "): " + "It's getting hot here!");
				coordinates.updateLatitude(10);
				coordinates.updateHeight(2);
				break;
			case "RAIN":
				System.out.println("Helicopter#" + name + "(" + id + "): " + "I'm so wet!");
				coordinates.updateLatitude(5);
				break;
			case "FOG":
				System.out.println("Helicopter#" + name + "(" + id + "): " + "Foggyyyyyyyy!");
				coordinates.updateLatitude(1);
				break;
			case "SNOW":
				System.out.println("Helicopter#" + name + "(" + id + "): " + "Let's build a snowman!");
				coordinates.updateHeight(-12);
				break;
		}

		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
		}
	}
	@Override
	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		p_tower.register(this);
	};
}