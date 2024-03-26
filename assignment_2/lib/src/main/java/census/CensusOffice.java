package census;

import java.util.ArrayList;
import java.util.List;

public class CensusOffice implements Observable{
	
	private int officeNum;
	private List<Observer> observers = new ArrayList<>();
	private City mostRecentCity;
	
	public CensusOffice(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException("office number must greater that 0 [" + number + "]");
		}
		this.officeNum = number;
	}

	@Override
	public boolean addObserver(Observer ob) {
		if (!observers.contains(ob)) {
			observers.add(ob);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeObserver(Observer ob) {
		return observers.remove(ob);
	}

	@Override
	public boolean hasObservers() {
		if(observers.isEmpty()) {
			return false;
		}
		return true;
	}

	public int getNumber() {
		return officeNum;
	}
	
	public City getReported() {
		return mostRecentCity;
	}
	
	protected void report(City latest) {
		mostRecentCity = latest;
		for (Observer ob : observers) {
			ob.update(this);
			
		}
	}
}
