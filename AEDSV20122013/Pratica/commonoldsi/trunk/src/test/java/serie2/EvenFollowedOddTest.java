package serie2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;
import static serie2.Iterables.evenFollowedOdd;
import static org.junit.Assert.*;

public class EvenFollowedOddTest {

	@Test
	public void  evenFollowedOdd_empty_iterable(){
		Iterable<Integer> it = evenFollowedOdd( Collections.<Integer>emptyList());
		assertFalse( it.iterator().hasNext());
	}

	@Test  (expected=NoSuchElementException.class)
	public void  evenFollowedOdd_cause_no_such_exception_get_next_in_empty_iterable(){
		evenFollowedOdd(Collections.<Integer>emptyList()).iterator().next();
	}

	@Test
	public void  evenFollowedOdd_one_even(){
		Iterable<Integer> col = Collections.singletonList( 2 );
		Iterator<Integer> it = evenFollowedOdd(col).iterator();
		assertTrue( it.hasNext());
		assertEquals(2, it.next().intValue());
		assertFalse( it.hasNext());
		
		// Get next without hasNext 
		it = evenFollowedOdd(col).iterator();
		assertEquals(2, it.next().intValue());
		assertFalse( it.hasNext());
	}
		
	@Test  (expected=NoSuchElementException.class)
	public void  evenFollowedOdd_cause_no_such_exception_get_next_in_the_end(){
		Iterator<Integer> it = evenFollowedOdd(Collections.singletonList( 2 )).iterator();
		it.next();
		assertFalse( it.hasNext() );
		it.next();
	}

	@Test  (expected=UnsupportedOperationException.class)
	public void  evenFollowedOdd_cause_unsupported_operation_exception(){
		Iterator<Integer> it = evenFollowedOdd(Collections.singletonList( 2 )).iterator();
		assertEquals(2, it.next().intValue());
		it.remove();
	}
	
	private void testResult( ArrayList<Integer> al, int startValue, int endValue, 
			                 Iterator<Integer> it, boolean expectedHasNext) {
		assertTrue( it.hasNext());
		for ( int expectedValue= startValue; expectedValue < endValue; expectedValue+=2 ) 
			assertEquals( expectedValue, it.next().intValue() );
		assertEquals( expectedHasNext, it.hasNext() );		
	}

	
	@Test
	public void  evenFollowedOdd_all_even_and_even_number_of_elements(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for ( int i= 0; i < 8; i+=2 )
			al.add( i );
		Iterable<Integer> it= evenFollowedOdd(al);
		testResult(al, 0, al.size()*2, it.iterator(), false);
		testResult(al, 0, al.size()*2, it.iterator(), false);
	}
	
	@Test
	public void  evenFollowedOdd_all_even_and_odd_number_of_elements(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for ( int i= 0; i < 6; i+=2 )
			al.add( i );
		testResult(al, 0, al.size()*2, evenFollowedOdd(al).iterator(), false);
	}


	@Test
	public void  evenFollowedOdd_one_odd(){
		Iterator<Integer> it = evenFollowedOdd(Collections.singletonList( 1 )).iterator();
		assertTrue( it.hasNext());
		assertEquals(1, it.next().intValue());
		assertFalse( it.hasNext());
	}
	
	@Test
	public void  evenFollowedOdd_all_odd_and_odd_number_of_elements(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for ( int i= 1; i < 6; i+=2 )
			al.add( i );
		testResult(al, 1, al.size()*2, evenFollowedOdd(al).iterator(), false);
	}
	
	@Test
	public void  evenFollowedOdd_all_odd_and_even_number_of_elements(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for ( int i= 1; i < 8; i+=2 )
			al.add( i );
		testResult(al, 1, al.size()*2, evenFollowedOdd(al).iterator(), false);
	}

	@Test
	public void  evenFollowedOdd_intercalate_with_first_even(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		Iterator<Integer> it ;
		for ( int i= 0; i < 8; ++i )
			al.add( i );
		it= evenFollowedOdd(al).iterator();
		testResult(al, 0, al.size(), it, true);
		testResult(al, 1, al.size(), it, false);
	}

	@Test
	public void  evenFollowedOdd_intercalate_with_first_odd(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		Iterator<Integer> it ;
		for ( int i= 1; i < 8; ++i )
			al.add( i );
		it= evenFollowedOdd(al).iterator();
		testResult(al, 2, al.size()+1, it, true);
		testResult(al, 1, al.size()+1, it, false);
	}

	@Test
	public void  evenFollowedOdd_first_even(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		Iterator<Integer> it ;
		for ( int i= 0; i < 8; i+=2 ) 
			al.add(i);
		for ( int i= 1; i < 8; i+=2 ) 
			al.add( i );
		it= evenFollowedOdd(al).iterator();
		testResult(al, 0, al.size(), it, true);
		testResult(al, 1, al.size(), it, false);
	}

	@Test
	public void  evenFollowedOdd_first_odd(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		Iterator<Integer> it ;
		for ( int i= 1; i < 8; i+=2 ) 
			al.add( i );
		for ( int i= 0; i < 8; i+=2 ) 
			al.add(i);
		it= evenFollowedOdd(al).iterator();
		testResult(al, 0, al.size(), it, true);
		testResult(al, 1, al.size(), it, false);
	}
}
