package census;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class CensusTest {

	
	@Test
    public void testConstructorNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new CensusOffice(-1));
    }
	
	@Test
	void testGetNum() {
		CensusOffice office1 = new CensusOffice(1);
		assertEquals(office1.getNumber(), 1);
	}
	

}
