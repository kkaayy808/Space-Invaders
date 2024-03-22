package fibonacci;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	@Test
	void testIterator() {
		Fibonacci fib = new Fibonacci();
		Iterator<Long> iterator = fib.iterator();
		assertNotNull(iterator);
	}
	
	@Test 
	public void testFibonacciSequence() {
		Fibonacci fib = new Fibonacci();
		Iterator<Long> iterator = fib.iterator();
		
		assertEquals(1L, (long) iterator.next()); 
        assertEquals(1L, (long) iterator.next()); 
        assertEquals(2L, (long) iterator.next()); 
        assertEquals(3L, (long) iterator.next()); 
        assertEquals(5L, (long) iterator.next()); 
	}
	
	@Test 
	public void testHasNext() {
		Fibonacci fib = new Fibonacci();
		Iterator<Long> iterator = fib.iterator();
		
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();		
	}

}
