package serie2;

import org.junit.Test;

import static serie2.Iterables.getValues;
import static org.junit.Assert.*;

import java.util.*;

public class GetValuesTest {
	private static Predicate<Integer> noElementPredicate = new Predicate<Integer>(){
		public boolean evaluate(Integer elem) {
			return false;
		}
	};
	private static Predicate<Integer> allElementsPredicate = new Predicate<Integer>(){
		public boolean evaluate(Integer elem) {
			return true;
		}
	};
	private static Predicate<Integer> evenPredicate = new Predicate<Integer>(){
		public boolean evaluate(Integer elem) {
			return (elem & 1) == 0;
		}
	};
	private static Predicate<Integer> oddPredicate = new Predicate<Integer>(){
		public boolean evaluate(Integer elem) {
			return (elem & 1) == 1;
		}
	};

	@Test
	public void  getValues_empty_iterable(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		Iterable<Integer> it = getValues( al, allElementsPredicate);
		assertFalse( it.iterator().hasNext());
	}
	
	@Test  (expected=NoSuchElementException.class)
	public void  getValues_cause_no_such_exception_get_next_in_empty_iterable(){
		getValues( new ArrayList<Iterable<Integer>>(), allElementsPredicate).iterator().next();
	}

	@Test
	public void  getValues_empty_iterables(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		al.add(new ArrayList<Integer>());
		assertFalse(getValues( al, allElementsPredicate).iterator().hasNext());
		
		for (int i= 0; i < 3; ++i) 
			al.add( new ArrayList<Integer>() );
		assertFalse(getValues( al, allElementsPredicate).iterator().hasNext());
	}
	
	@Test
	public void  getValues_always_false_predicate_and_on_element_iterables(){
		//Only one iterable with one element
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		al.add( Collections.singleton(0) );
		assertFalse( getValues( al, noElementPredicate).iterator().hasNext() );
		//Four iterable whith one element
		for (int i= 1; i < 4; ++i) 
			al.add( Collections.singleton(i) );
		assertFalse( getValues( al, noElementPredicate).iterator().hasNext() );
	}
	
	@Test
	public void  getValues_always_false_predicate(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//Four iterable whith two element
		for (int i= 0; i < 4; i+=2) 
			al.add( Arrays.asList(i, i+1) );
		assertFalse( getValues( al, noElementPredicate).iterator().hasNext() );
	}

	@Test
	public void  getValues_always_true_predicate_and_on_element_iterables(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//One iterable whith one element
		al.add( Collections.singleton(0) );
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		assertTrue( it.hasNext() );
		assertEquals(0, it.next().intValue() );
		assertFalse( it.hasNext() );
		
		// Get next without hasNext 
		it =getValues( al, allElementsPredicate).iterator();
		assertEquals(0, it.next().intValue() );
		assertFalse( it.hasNext() );
		
		//Four iterable whith one element
		for (int i= 1; i < 4; ++i) 
			al.add( Collections.singleton(i) );
		it =getValues( al, allElementsPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 0; i < al.size(); ++i) 
			assertEquals(i, it.next().intValue() );
		System.out.println();
		assertFalse( it.hasNext() );
	}	
	
	@Test  (expected=NoSuchElementException.class)
	public void  getValues_cause_no_such_exception_get_next_in_the_end(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//One iterable whith one element
		al.add( Collections.singleton(0) );
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		it.next();
		assertFalse( it.hasNext() );
		it.next();
	}

	@Test  (expected=UnsupportedOperationException.class)
	public void  getValues_cause_unsupported_operation_exception(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//One iterable whith one element
		al.add( Collections.singleton(0) );
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		it.next();
		it.remove();
	}

	@Test
	public void  getValues_always_true_predicate(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		ArrayList<Integer> ali=null;
		//Four iterable whith four element
		for (int i= 0; i < 3; ++i) {
			ali = new ArrayList<Integer>();
			for (int j= 0; j < 4; ++j )
				ali.add( i*4+j);
			al.add(ali);
		}
		
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 0; i < ali.size()*al.size(); ++i) 
			assertEquals(i, it.next().intValue() );
		assertFalse( it.hasNext() );
	}
	
	@Test
	public void  getValues_always_true_predicate_intercalated_empty_no_empty(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//Four iterable whith four element
		for (int i= 0; i < 4*4; i+=4)  {
			al.add(new ArrayList<Integer>());
			al.add( Arrays.asList(i, i+1, i+2, i+3) );
		}
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 0; i < 4*al.size()/2; ++i) 
			assertEquals(i, it.next().intValue() );
		assertFalse( it.hasNext() );
	}
	
	@Test
	public void  getValues_always_true_predicate_intercalated_no_empty_empty(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//Four iterable whith four element
		//Four iterable whith four element
		for (int i= 0; i < 4*4; i+=4)  {
			al.add( Arrays.asList(i, i+1, i+2, i+3) );
			al.add(new ArrayList<Integer>());
		}
		Iterator<Integer> it =getValues( al, allElementsPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 0; i < 4*al.size()/2; ++i) 
			assertEquals(i, it.next().intValue() );
		assertFalse( it.hasNext() );
	}

	@Test
	public void  getValues_always_odd_predicate(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//Four iterable whith four element
		for (int i= 0; i < 4*4; i+=4)  {
			al.add( Arrays.asList(i, i+1, i+2, i+3) );
			al.add(new ArrayList<Integer>());
		}
		Iterator<Integer> it =getValues( al, oddPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 1; i < 4*al.size()/2; i+=2) 
			assertEquals(i, it.next().intValue() );
		assertFalse( it.hasNext() );
	}


	@Test
	public void  getValues_always_even_predicate(){
		ArrayList<Iterable<Integer>> al = new ArrayList<Iterable<Integer>>();
		//Four iterable whith four element
		for (int i= 0; i < 5*3; i+=3)  {
			al.add(new ArrayList<Integer>());
			al.add( Arrays.asList(i, i+1, i+2) );
			al.add(new ArrayList<Integer>());
		}
		Iterator<Integer> it =getValues( al, evenPredicate).iterator();
		assertTrue( it.hasNext() );
		for ( int i= 0; i < 3* al.size()/3; i+=2)
			assertEquals(i, it.next().intValue() );
		assertFalse( it.hasNext() );
	}
}
