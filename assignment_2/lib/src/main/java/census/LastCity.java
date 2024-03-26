package census;

import java.util.ArrayList;
import java.util.List;

public class LastCity implements Observer{
	
	private List<City> cityList = new ArrayList<>();
	
	private String name;
	private String state;
	private int population;
	
	private CensusOffice lastObserved;

	@Override
	public void update(Observable ob) {
		if (ob instanceof CensusOffice office) {
			this.name = office.getReported().getName();
			this.state = office.getReported().getState();
			this.population = office.getReported().getPopulation();
			
			City currCity = new City(name, state, population);
			
			cityList.add(currCity);
			
			lastObserved = (CensusOffice) ob;
		}
		
	}
	
	public City getLastCity() {
		return cityList.getLast();
	}

	public CensusOffice getLastOffice() {
		return lastObserved;
	}
}
