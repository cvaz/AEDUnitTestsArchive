package serie2;

import org.junit.Test;

import static serie2.Iterables.intersection;
import java.util.*;

public class IntersectionTest extends IterablesTest {
	static Iterable<Integer> se = Collections.<Integer>emptyList();
	
	@Test 
	public void intersection_withTwoEmptySequences(){
		assertIterableEmpty( intersection( se, se ) );	
	}

	@Test 
	public void intersection_withOneEmptySequence(){
		assertIterableEmpty( intersection( se, singleton( 1 ) ) );	
		assertIterableEmpty( intersection( singleton( 3 ), se ) );	
	}

	@Test 
	public void intersection_OneElementSequences(){
		Collection<Integer> s1= singleton( 1 ), s2 = singleton( 3 );
		assertIterableEmpty( intersection( s1, s2 ) );	
		assertIterableEmpty( intersection( s2, s1 ) );
		assertIterableEquals( s2, intersection( s2, s2 ) );
	}

	@Test 
	public void intersection_empty(){
		Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 5, 7 ) ),
		                  s2= unmodifiable( Arrays.asList( 8, 10, 12 ) ),
		                  s3= unmodifiable( Arrays.asList( 2, 4, 6 ) );
		assertIterableEmpty( intersection( s1 , s2 ) );	
		assertIterableEmpty( intersection( s2 , s1 ) );
		assertIterableEmpty( intersection( s1 , s3 ) );	
		assertIterableEmpty( intersection( s3 , s1 ) );
	}

	@Test 
	public void intersection_sameElementsSequence(){
		List<Integer> s;
		for ( int n= 2; n <=5; ++n ) {
			s = new ArrayList<Integer>();
			for ( int i= 1; i <= n; ++ i) 
				s.add( i );
			s = unmodifiable( s );
			assertIterableEquals( s,  intersection( s, s ) );
		}
	}
	
	@Test 
	public void intersection_onFirstElement(){
		Iterable<Integer> s1= unmodifiable( Arrays.asList( 2, 3, 5, 7 ) ),
                          s2= unmodifiable( Arrays.asList( 2, 10, 12 ) ),
                          s3 = singleton( 2 );

		assertIterableEquals( s3, intersection( s1, s2 ) );
		assertIterableEquals( s3, intersection( s2, s1 ) );		
	}

	@Test 
	public void intersection_onLastElement(){
		Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 5, 7, 14 ) ),
                          s2= unmodifiable( Arrays.asList( 10, 12, 14 ) ),
                          s3 = singleton( 14 );

		assertIterableEquals( s3, intersection( s1, s2 ) );
		assertIterableEquals( s3, intersection( s2, s1 ) );
	}

	@Test 
	public void intersection_onFirstAndLastElement(){
		Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 15, 17, 24 ) ),
                          s2= unmodifiable( Arrays.asList( 1, 12, 18, 24 ) );

		assertIterableEquals( Arrays.asList(1, 24), intersection( s1, s2 ) );
	}

	@Test 
	public void intersection_onSubSequence(){
		List<Integer> s1 = unmodifiable( Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 ) ),
                      s2 = unmodifiable( Arrays.asList( 2, 4, 6, 8 ) ),
                      s3 = s1.subList( 0, 4 ),
                      s4 = s1.subList( 5, s1.size() );
	
		assertIterableEquals( s2, intersection(s1, s2) );
		assertIterableEquals( s2, intersection(s2, s1) );

		assertIterableEquals( s3, intersection(s1, s3) );
		assertIterableEquals( s3, intersection(s3, s1) );

		assertIterableEquals( s4, intersection(s1, s4) );
		assertIterableEquals( s4, intersection(s4, s1) );
	}

}
