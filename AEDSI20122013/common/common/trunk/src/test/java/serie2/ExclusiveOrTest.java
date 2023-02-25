package serie2;
import org.junit.Test;
import static serie2.Iterables.exclusiveOr;
import java.util.*;
	
	public class ExclusiveOrTest extends IterablesTest {
		static Iterable<Integer> se = Collections.<Integer>emptyList();
		
		@Test 
		public void exclusiveOr_withTwoEmptySequences(){
			assertIterableEmpty( exclusiveOr( se, se ) );	
		}

		@Test 
		public void exclusiveOr_withOneEmptySequence(){
			Collection<Integer> s = singleton( 1 );
			Iterable<Integer> iter1= exclusiveOr( se, s) ;	
			Iterable<Integer> iter2 = exclusiveOr( s, se ) ;	
			 assertIterableEquals(iter1,s);
			 assertIterableEquals(iter2,s);
		}
		
		@Test 
		public void exclusiveOr_OneEqualsElementSequences(){
			Collection<Integer> s1= singleton( 1 ), s2 = singleton( 1 );
			assertIterableEmpty(exclusiveOr( s2, s1 ) );	
			assertIterableEmpty(exclusiveOr( s2, s1 )  );
			assertIterableEquals( se, exclusiveOr( s2, s1 )  );
		}
		

		@Test 
		public void exclusiveOr_OneDifferentElementSequences(){
			Collection<Integer> s1= singleton( 1 ), s2 = singleton( 3 );
			 List<Integer> s3 = Arrays.asList(1,3);
			assertIterableEquals(exclusiveOr( s2, s1 ) , exclusiveOr( s1, s2 ) );	
			assertIterableEquals( s3, exclusiveOr( s2, s1 ) );
		}

		
		@Test 
		public void exclusiveOr_empty(){
			Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 5, 7 ) ),
			                  s2= unmodifiable( Arrays.asList( 1, 3, 5,7 ) );               
			assertIterableEmpty( exclusiveOr( s1 , s2 ) );	
			assertIterableEmpty( exclusiveOr( s2 , s1 ) );
		}
		
		@Test 
		public void exclusiveOr_All(){
			Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 5, 7 ) ),
			                  s2= unmodifiable( Arrays.asList( 8, 10, 12 ) ),
			                  s3= unmodifiable( Arrays.asList( 2, 4, 6 ) ),
							  s4=unmodifiable(Arrays.asList(1,2,3,4,5,6,7,8,10,12));	
			assertIterableEquals( s4, exclusiveOr(s1, exclusiveOr(s2,s3)));	
			assertIterableEquals( s4, exclusiveOr(s1, exclusiveOr(s3,s2)));	
			assertIterableEquals( s4, exclusiveOr(s2, exclusiveOr(s1,s3)));	
			assertIterableEquals( s4, exclusiveOr(s2, exclusiveOr(s3,s1)));	
			assertIterableEquals( s4, exclusiveOr(s3, exclusiveOr(s1,s2)));	
			assertIterableEquals( s4, exclusiveOr(s3, exclusiveOr(s2,s1)));	
		}

		@Test 
		public void exclusiveOr_sameElementsSequence(){
			List<Integer> s;
			for ( int n= 2; n <=5; ++n ) {
				s = new ArrayList<Integer>();
				for ( int i= 1; i <= n; ++ i) 
					s.add( i );
				s = unmodifiable( s );
				assertIterableEquals( se,  exclusiveOr( s, s ) );
			}
		}
	
		@Test 
		public void exclusiveOr_onlyLastElements(){
			Iterable<Integer> s1= unmodifiable( Arrays.asList( 2, 5, 7 ) ),
	                          s2= unmodifiable( Arrays.asList( 2, 5, 12 ) ),
	                          s3 =unmodifiable(Arrays.asList(7,12));

			assertIterableEquals( s3, exclusiveOr( s1, s2 ) );
			assertIterableEquals( s3, exclusiveOr( s2, s1 ) );		
		}
		
		@Test 
		public void exclusiveOr_exceptLastElement(){
			Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 5, 7, 14 ) ),
	                          s2= unmodifiable( Arrays.asList( 10, 12, 14 ) ),
	                          s3 = unmodifiable(Arrays.asList(1,3,5,7,10,12));

			assertIterableEquals( s3, exclusiveOr( s1, s2 ) );
			assertIterableEquals( s3, exclusiveOr( s2, s1 ) );
		}

		@Test 
		public void exclusiveOr_exceptFirstAndLastElement(){
			Iterable<Integer> s1= unmodifiable( Arrays.asList( 1, 3, 15, 17, 24 ) ),
	                          s2= unmodifiable( Arrays.asList( 1, 12, 18, 24 ) );

			assertIterableEquals( Arrays.asList(3,12,15,17,18), exclusiveOr( s1, s2 ) );
		}



}
