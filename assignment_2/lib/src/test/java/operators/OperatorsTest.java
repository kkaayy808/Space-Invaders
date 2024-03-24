package operators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class OperatorsTest {
	
	@Test
    public void testConstructorNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Factorial(new TermImpl(-5)));
    }

    @Test
    public void testGetValue() {
        // Factorial of 0 is 1
        assertEquals(1, new Factorial(new TermImpl(0)).getValue());
        // Factorial of 1 is 1
        assertEquals(1, new Factorial(new TermImpl(1)).getValue());
        // Factorial of 5 is 120
        assertEquals(120, new Factorial(new TermImpl(5)).getValue());
    }

    private static class TermImpl implements Term {
        private int value;

        public TermImpl(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
    
    @Test
    public void testNumberGetValue() {
        assertEquals(0, new Number(0).getValue());
    }
    
    @Test
    public void testTimesGetValue() {
        assertEquals(0, new Times(new Number(0), new Number(0)).getValue());
    }
    
    @Test
    public void testPlusGetValue() {
        assertEquals(0, new Plus(new Number(0), new Number(0)).getValue());
    }
    
    @Test
    public void testBinaryOperatorConstructorLeftTermNull() {
        assertThrows(IllegalArgumentException.class, () -> new Times(null, new Number(5)));
    }

    @Test
    public void testBinaryOperatorConstructorRightTermNull() {
        assertThrows(IllegalArgumentException.class, () -> new Times(new Number(5), null));
    }
    
    @Test
    public void testUnaryOperatorConstructorTermNull() {
        assertThrows(IllegalArgumentException.class, () -> new Factorial(null));
    }
	
}

