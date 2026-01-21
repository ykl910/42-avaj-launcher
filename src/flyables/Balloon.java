package flyables;

import utils.Coordinates;
import tower.WeatherTower;
import aircraft.Aircraft;

public class Balloon extends Aircraft implements Flyable {

	public Balloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
	}
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		switch (weather) {
			case "SUN":
				System.out.println("Balloon#" + name + "(" + id + "): " + "It's getting hot here!");
				coordinates.updateLatitude(2);
				coordinates.updateHeight(4);
				break;
			case "RAIN":
				System.out.println("Balloon#" + name + "(" + id + "): " + "I'm so wet!");
				coordinates.updateHeight(-5);
				break;
			case "FOG":
				System.out.println("Balloon#" + name + "(" + id + "): " + "Foggyyyyyyyy!");
				coordinates.updateHeight(-3);
				break;
			case "SNOW":
				System.out.println("Balloon#" + name + "(" + id + "): " + "Let's build a snowman!");
				coordinates.updateHeight(-15);
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