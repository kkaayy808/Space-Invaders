package census;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CensusTest {

	private CensusOffice censusOffice;
    private TestObserver observer;

    @BeforeEach
    public void setUp() {
        censusOffice = new CensusOffice(1);
        observer = new TestObserver();
    }
    
    private static class TestObserver implements Observer {
        private int updateCount;

        @Override
        public void update(Observable ob) {
            updateCount++;
        }

        public int getUpdateCount() {
            return updateCount;
        }
    }

    @Test
    public void testAddObserver() {
        assertTrue(censusOffice.addObserver(observer));
        assertTrue(censusOffice.hasObservers());
    }

    @Test
    public void testAddDuplicateObserver() {
        censusOffice.addObserver(observer);
        assertFalse(censusOffice.addObserver(observer));
    }

    @Test
    public void testRemoveObserver() {
        censusOffice.addObserver(observer);
        assertTrue(censusOffice.removeObserver(observer));
        assertFalse(censusOffice.hasObservers());
    }

    @Test
    public void testRemoveNonExistingObserver() {
        assertFalse(censusOffice.removeObserver(observer));
    }

    @Test
    public void testReport() {
        censusOffice.addObserver(observer);
        City city = new City("New York", "NY", 1000000);
        censusOffice.report(city);
        assertEquals(city, censusOffice.getReported());
        assertEquals(1, observer.getUpdateCount());
    }

    @Test
    public void testReportNoObservers() {
        City city = new City("Los Angeles", "CA", 1500000);
        censusOffice.report(city);
        assertEquals(city, censusOffice.getReported());
    }

    @Test
    public void testGetNumber() {
        assertEquals(1, censusOffice.getNumber());
    }
	
	@Test
    public void testConstructorNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new CensusOffice(-1));
    }
	
	@Test
	void testGetNum() {
		CensusOffice office1 = new CensusOffice(1);
		assertEquals(office1.getNumber(), 1);
	}
	
	@Test
    void testNameGetter() {
        City city = new City("New York", "NY", 8000000);
        String cityName = city.getName();
        assertEquals("New York", cityName);
    }
    
    @Test
    void testStateGetter() {
        City city = new City("New York", "NY", 8000000);
        String state = city.getState();
        assertEquals("NY", state);
    }
    
    @Test
    void testPopulationGetter() {
        City city = new City("New York", "NY", 8000000);
        int population = city.getPopulation();
        assertEquals(8000000, population);
    }
    
    @Test
    public void testGetLastCityWhenNoUpdate() {
    	LastCity lastCity = new LastCity();
        assertNull(lastCity.getLastCity());
    }
    
    @Test
    public void testGetLastCityAfterSingleUpdate() {
        LastCity lastCity = new LastCity();
        CensusOffice office = new CensusOffice(1);
        City city = new City("City1", "State1", 1000);
        office.report(city);
        lastCity.update(office);
        assertEquals(city, lastCity.getLastCity());
    }

    @Test
    public void testGetLastCityAfterMultipleUpdates() {
        LastCity lastCity = new LastCity();
        CensusOffice office1 = new CensusOffice(1);
        CensusOffice office2 = new CensusOffice(2);
        City city1 = new City("City1", "State1", 1000);
        City city2 = new City("City2", "State2", 2000);
        office1.report(city1);
        office2.report(city2);
        lastCity.update(office1);
        lastCity.update(office2);
        assertEquals(city2, lastCity.getLastCity());
    }
    
    @Test
    public void testGetTopFiveCitiesAfterUpdates() {
        TopFiveCities topFiveCities = new TopFiveCities();
        CensusOffice office1 = new CensusOffice(1);
        CensusOffice office2 = new CensusOffice(2);
        CensusOffice office3 = new CensusOffice(3);
        CensusOffice office4 = new CensusOffice(4);
        CensusOffice office5 = new CensusOffice(5);
        City city1 = new City("City1", "State1", 1000);
        City city2 = new City("City2", "State2", 2000);
        City city3 = new City("City3", "State3", 3000);
        City city4 = new City("City4", "State4", 4000);
        City city5 = new City("City5", "State5", 5000);
        office1.report(city1);
        office2.report(city2);
        office3.report(city3);
        office4.report(city4);
        office5.report(city5);
        topFiveCities.update(office1);
        topFiveCities.update(office2);
        topFiveCities.update(office3);
        topFiveCities.update(office4);
        topFiveCities.update(office5);
        List<City> expectedTopFive = Arrays.asList(city5, city4, city3, city2, city1);
        assertEquals(expectedTopFive, topFiveCities.getTopFive());
    }
}
