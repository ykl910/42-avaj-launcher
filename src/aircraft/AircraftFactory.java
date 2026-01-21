package aircraft;

import flyables.Helicopter;
import flyables.Balloon;
import flyables.JetPlane;
import flyables.Flyable;
import utils.Coordinates;

public class AircraftFactory {
	
	private static AircraftFactory instance;
	private AircraftFactory() {};
	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}
	private long id = 0;
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinate) {
		id++;
		if (p_type.equals("Helicopter")) {
			return new Helicopter(id, p_name, p_coordinate);
		}	
		if (p_type.equals("JetPlane")) {
			return new JetPlane(id, p_name, p_coordinate);
		}
		if (p_type.equals("Balloon")) {
			return new Balloon(id, p_name, p_coordinate);
		}
		throw new IllegalArgumentException("Unknown type");
	}
}