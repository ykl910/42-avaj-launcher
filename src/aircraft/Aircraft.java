package aircraft;

import utils.Coordinates;
import flyables.Flyable;
import tower.WeatherTower;

public abstract class Aircraft implements Flyable {

	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected WeatherTower weatherTower;
	
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
	@Override
	public String getId() {
		return Long.toString(id);
	}
}