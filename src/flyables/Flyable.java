package flyables;

import tower.WeatherTower;

public interface Flyable {

	void updateConditions();
	void registerTower(WeatherTower p_tower);
	String getName();
	String getType();
	String getId();

} 