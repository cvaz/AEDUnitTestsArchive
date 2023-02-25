package serie1;

import static org.junit.Assert.*;
import static serie1.ArrayUtils.removeOdd;
import java.util.Arrays;
import org.junit.Test;

public class RemoveOddTest {
	private void filled(int[] a, int l, int r, int v) {
		while ( l <= r ) 
			assertEquals(v, a[l++]);	
	}
	@Test
	public void removeOdd_OnEmptyArray(){
		int[] a = new int[3];
		for( int i= 0; i < a.length; ++i) a[i]= i;
		int[] b = Arrays.copyOf(a, a.length);
		for (int i=0; i <= a.length; ++ i) {
		   assertEquals( 0, removeOdd(a, i, i-1));	
		   assertArrayEquals(b, a);
		}
	}

	@Test
	public void removeOdd_OnOneElementArray(){
		int[] a= new int[1];
		// Even element
		assertEquals( 1, removeOdd(a, 0, a.length-1));	
		assertEquals( 0, a[0] );
		// Odd element
		a[0]= 1;
		assertEquals( 0, removeOdd(a, 0, a.length-1));	
	}

	@Test
	public void removeOdd_allEven(){
		int [] dim = { 2, 3, 4, 10, 11};
		int[] a, b;
		for (int d = 0; d < dim.length; ++ d) {
			a = new int[ dim[d] ];
			for ( int i= 0; i <= a.length/2; ++i) {
				Arrays.fill(a, 0, a.length, 1);
				Arrays.fill(a, i, a.length-i, i*2);
				b= Arrays.copyOf(a, a.length);
				assertEquals(  a.length-2*i, removeOdd(a, i, a.length-i-1));	
				assertArrayEquals(b, a);
			}
		}
	}
	
	@Test
	public void removeOdd_allOdd(){
		int[] a;
		for (int d = 2; d <=6; ++ d) {
			a = new int[ d ];
			for ( int i= 0; i <= a.length/2; ++i) {
				Arrays.fill( a, i , a.length-i, i*2+3);
				assertEquals( 0, removeOdd(a, i, a.length-1-i), 0);
				filled(a, 0, i-1, 1);
				filled(a, a.length-i, a.length-1, 1);
				a[i] = a[a.length-1-i] = 1;
			}
		}
	}
	
	@Test
	public void removeOdd_OnBeginOfSequence(){
		int [] dim = { 2, 3, 4, 10, 11 };
		int[] a;
		for (int d = 0; d < dim.length; ++ d) {
			a = new int[dim[d]];
			for ( int i= 1; i < a.length; i+=3) {
				Arrays.fill(a, 0, i, 1);
				Arrays.fill(a, i, a.length, i*2);
				assertEquals( a.length-i, removeOdd(a, 0, a.length-1));
				filled(a, 0, a.length-i-1, i*2);
			}
		}
	}

	@Test
	public void removeOdd_OnEndOfSequence(){
		int [] dim = { 2, 3, 4, 10, 11 };
		int[] a;
		for (int d = 0; d < dim.length; ++ d) {
			a = new int[dim[d]];
			for ( int i= 1; i < a.length; i+=3) {
				Arrays.fill(a, 0, i, i*2);
				Arrays.fill(a, i, a.length, 1);
				assertEquals( i, removeOdd(a, 0, a.length-1));
				filled(a, 0, i-1, i*2);
			}
		}
	}

	@Test
	public void removeOdd_OfAlternateSequence(){
		int [] dim = { 1, 2, 3, 10, 11};
		int[] a, b;
		for (int d = 0; d < dim.length; ++ d) {
			b = new int[dim[d]];
			a = new int[b.length*2-1];
			for( int i= 0; i < a.length; ++i) a[i]= i;
			for( int i= 0; i < b.length; ++i) b[i]= i*2;
			assertEquals( b.length, removeOdd(a, 0, a.length-1));
			assertArrayEquals(b, Arrays.copyOf(a, b.length));
		}
		for (int d = 2; d < dim.length; ++ d) {
			b = new int[dim[d]];
			a = new int[b.length*2];
			for( int i= 0; i < a.length; ++i) a[i]= i+1;
			for( int i= 0; i < b.length; ++i) b[i]= (i+1)*2;
			assertEquals( b.length, removeOdd(a, 0, a.length-1));
			assertArrayEquals(b, Arrays.copyOf(a, b.length));
		}
	}


/*	
	@Test
	public void countEqualTo_OnEndOfSequence(){
		for ( int i= 1; i <= 3; ++i) 
			assertEquals( countEqualTo(v1, 0, v1.length-i, 4), 3-i);	
		for ( int i= 1; i <= 4; ++i) 
			assertEquals( countEqualTo(v2, 0, v2.length-i, 4), 4-i);	
	}
	
	@Test
	public void countEqualTo_OnMiddle(){
		for ( int i= 0; i < 2; ++i) 
			assertEquals( countEqualTo(v1, i, v1.length-1, 1), 2);	
		for ( int i= 0; i < 2; ++i) 
			assertEquals( countEqualTo(v2, i, v2.length-1, 1), 3);	
	}
	
	@Test
	public void countEqualTo_LessThanFirst(){
		for ( int i= 0; i < 2; ++i) {
			assertEquals( countEqualTo(v1, i, v1.length-1, -1), 0);	
			assertEquals( countEqualTo(v1, 2, v1.length-1-i, 0), 0);	
		}
	}

	@Test
	public void countEqualTo_GreaterThanLast(){
		for ( int i= 0; i < 2; ++i) {
			assertEquals( countEqualTo(v1, i, v1.length-1, 5), 0);	
			assertEquals( countEqualTo(v1, i, v1.length-3, 4), 0);	
		}
	}

	@Test
	public void countEqualTo_NotExist(){
		for ( int i= 0; i <= v1.length; ++i) 
			assertEquals( countEqualTo(v1, i, v1.length-1, 3), 0);	
	}

	@Test
	public void countEqualTo_allEquals(){
		int[] a = new int[10];
		for ( int i= 0; i < a.length; ++i) 
			assertEquals( countEqualTo(a, 0, i, 0), i+1);	
	}
*/
	
}
