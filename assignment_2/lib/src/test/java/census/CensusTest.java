package census;

import static org.junit.jupiter.api.Assertions.*;

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
}
