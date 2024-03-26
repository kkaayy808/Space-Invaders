package census;

public record City(String name, String state, int population) {
	
	public String getName() {
		return name;
	}
	
	public String getState() {
		return state;
	}
	
	public int getPopulation() {
		return population;
	}
}
