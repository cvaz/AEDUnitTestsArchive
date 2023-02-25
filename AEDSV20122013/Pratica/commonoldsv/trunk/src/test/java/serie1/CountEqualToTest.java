package serie1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static serie1.ArrayUtils.countEqualTo;

public class CountEqualToTest {
	static int[] v1 = new int[]{0,0,1,1,4,4};
	static int[] v2 = new int[]{0,0,0,1,1,1,4,4,4};
	@Test
	public void countEqualTo_OnEmptyArray(){
		assertEquals( 0, countEqualTo(v1, 0, -1, 0) );	
		assertEquals( 0, countEqualTo(v1, 1, 0, 0));	
		assertEquals( 0, countEqualTo(v1, v1.length, v1.length-1, 4));
	}

	@Test
	public void countEqualTo_OnOneElementArray(){
		int[] a= new int[1];
		assertEquals( 1, countEqualTo(a, 0, a.length-1, 0));	
		assertEquals( 0, countEqualTo(a, 0, a.length-1, -1));	
		assertEquals( 0, countEqualTo(a, 0, a.length-1, 1));	
	}

	@Test
	public void countEqualTo_onBeginOfSequence(){
		for ( int i= 0; i < 3; ++i) 
			assertEquals( 2-i, countEqualTo(v1, i, v1.length-1, 0));	
		for ( int i= 0; i < 4; ++i) 
			assertEquals( 3-i, countEqualTo(v2, i, v2.length-1, 0));	
	}
	
	@Test
	public void countEqualTo_OnEndOfSequence(){
		for ( int i= 1; i <= 3; ++i) 
			assertEquals( 3-i,  countEqualTo(v1, 0, v1.length-i, 4));	
		for ( int i= 1; i <= 4; ++i) 
			assertEquals( 4-i, countEqualTo(v2, 0, v2.length-i, 4));	
	}
	
	@Test
	public void countEqualTo_OnMiddle(){
		for ( int i= 0; i < 2; ++i) 
			assertEquals( 2, countEqualTo(v1, i, v1.length-1, 1));	
		for ( int i= 0; i < 2; ++i) 
			assertEquals( 3, countEqualTo(v2, i, v2.length-1, 1));	
	}
	
	@Test
	public void countEqualTo_LessThanFirst(){
		for ( int i= 0; i < 2; ++i) {
			assertEquals( 0, countEqualTo(v1, i, v1.length-1, -1));	
			assertEquals( 0, countEqualTo(v1, 2, v1.length-1-i, 0));	
		}
	}

	@Test
	public void countEqualTo_GreaterThanLast(){
		for ( int i= 0; i < 2; ++i) {
			assertEquals( 0, countEqualTo(v1, i, v1.length-1, 5));	
			assertEquals( 0, countEqualTo(v1, i, v1.length-3, 4));	
		}
	}

	@Test
	public void countEqualTo_AllDiferent(){
		for ( int i= 0; i <= v1.length; ++i) 
			assertEquals( 0, countEqualTo(v1, i, v1.length-1, 3));	
	}

	@Test
	public void countEqualTo_allEquals() {
		int[] a = new int[10];
		for ( int i= 0; i < a.length; ++i) 
			assertEquals( i+1, countEqualTo(a, 0, i, 0));	
	}
}
