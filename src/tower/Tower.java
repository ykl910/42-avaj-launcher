package tower;

import flyables.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower {

	private List<Flyable> observers = new ArrayList<>();
	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") registered to weather tower.");
	}
	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
		System.out.println(p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ") landing.");
	}
	protected void conditionChanged() {
		for (Flyable f : new ArrayList<>(observers)) {
			f.updateConditions();
		}
	}
}