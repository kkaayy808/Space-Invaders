package census;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopFiveCities implements Observer{
	
	private List<City> cityList = new ArrayList<>();

	private String name;
	private String state;
	private int population;
	
	@Override
	public void update(Observable ob) {
		if (ob instanceof CensusOffice office) {
			this.name = office.getReported().getName();
			this.state = office.getReported().getState();
			this.population = office.getReported().getPopulation();
			
			City currCity = new City(name, state, population);
			
			cityList.add(currCity);
		}
		
	}
	
	public List<City> getTopFive(){
		
		List<City> topList = new ArrayList<>();;
		
		cityList.sort(Comparator.comparingInt(City::getPopulation));
		
		for(int i = 0; i < 5; i++ ) {
			topList.add(cityList.get(i));
		}
		
		
		return topList;
		
	}

}
