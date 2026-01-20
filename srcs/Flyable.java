public interface Flyable {

	protected WeatherTower weatherTower;
	public abstract void updateConditions();
	registerTower(WeatherTower* p_tower) {
		this.weatherTower = p_tower;
	};

} 