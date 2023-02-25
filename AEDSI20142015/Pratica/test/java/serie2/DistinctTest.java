package serie2;

import static serie2.Iterables.distinct;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DistinctTest extends IterablesTest {
	static final Iterable<Integer> SEmpty = Collections.<Integer>emptyList();
	static final Iterable<Integer> SSingleEven = Collections.singletonList(2);
	static final Iterable<Integer> SSingleOdd = Collections.singletonList(1);
	static final List<Integer> SContinuous = unmodifiable(Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	static final List<Integer> SContinuousDups = unmodifiable(Arrays.asList( 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10));
	static final List<Integer> SEven = unmodifiable(Arrays.asList(2, 4, 6, 8, 10));
	static final List<Integer> SOdd = unmodifiable(Arrays.asList( 1, 3, 5, 7, 9));
	static final List<Integer> SSome = unmodifiable(Arrays.asList(1, 4, 5, 12, 15, 17, 22, 31));
	static final List<Integer> SSomeDups = unmodifiable(Arrays.asList(1, 4, 4, 4, 5, 12, 12, 15, 15, 15, 15, 17, 22, 31, 31));
		
	static final Predicate<Integer> PREDICATE = new Predicate<Integer>() {
		public boolean evaluate(Integer i) {
			if (i == null) return true;
			return i % 2 == 0;
		}
	};
		
	@Test 
	public void distinct_withEmptySequences() {
		assertIterableEmpty(distinct(SEmpty, PREDICATE));
	}
	
	@Test 
	public void distinct_withOneElementSequence(){
		assertIterableEmpty(distinct(SSingleOdd, PREDICATE));
		Iterable<Integer> result = distinct(SSingleEven, PREDICATE);
		assertTrue(result.iterator().hasNext());
		assertIterableEquals(SSingleEven, result);
		Iterator<Integer> it = result.iterator();
		assertTrue(it.hasNext());	
	}
	
	@Test 
	public void distinct_withContinuousSequence(){
		assertIterableEquals(SEven, distinct(SContinuous, PREDICATE));
	}
	
	@Test 
	public void distinct_withContinuousSequenceDups(){
		assertIterableEquals(SEven, distinct(SContinuousDups, PREDICATE));
	}
	
	@Test 
	public void distinct_withEvenSequence(){
		assertIterableEquals(SEven, distinct(SEven, PREDICATE));
	}
	
	@Test 
	public void distinct_withOddSequence(){
		assertIterableEmpty(distinct(SOdd, PREDICATE));
	}
	
	@Test
	public void distinct_withSomeSequence(){
		List<Integer> someSequence = unmodifiable(Arrays.asList(4, 12, 22));
        assertIterableEquals(someSequence, distinct(SSome, PREDICATE));
	}
	
	@Test
	public void distinct_withSomeSequenceDups(){
		List<Integer> someSequence = unmodifiable(Arrays.asList(4, 12, 22));
        assertIterableEquals(someSequence, distinct(SSomeDups, PREDICATE));
	}
		
		
	@Test(expected = NoSuchElementException.class)
	public void distinct_nextInEmptySequence() {
		Iterator<Integer> it =  distinct(SEmpty, PREDICATE).iterator();
		it.next();	
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();
		
	@Test 
	public void distinct_NextWithNoElements(){
		Iterator<Integer> it =  distinct(SSingleEven, PREDICATE).iterator();	
		assertEquals(2, it.next().intValue());
		exception.expect(NoSuchElementException.class);
		exception.expectMessage("distinct:Iterator - no such element");
		it.next();
	}
	
	@Test 
	public void distinct_RemoveElements(){
		Iterator<Integer> it= distinct(SSingleEven, PREDICATE).iterator();
		it.next();
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("distinct:Iterator - remove not supported");
		it.remove();
	}	
}
