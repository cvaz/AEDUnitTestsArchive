package serie2;
import static org.junit.Assert.*;

import org.junit.Test;

import static serie2.ArrayUtils.NElement;
import java.util.Arrays;
public class NElementTest {
	static int[] arrayTest = new int[]{ 4, 3, 2, 1, 0 };

	@Test
	public void NElement_OnOneElementArray(){
		int[] a= {4};
		assertEquals( 4, NElement(a, 0, a.length-1, 1));
		for ( int i= 0; i < arrayTest.length; ++i ) {
			a= Arrays.copyOf( arrayTest, arrayTest.length );
			assertEquals( arrayTest[i], NElement( a, i, i, 1 ) );	
			assertArrayEquals( arrayTest, a );
		}	
	}

	@Test
	public void NElement_firstElementOfSequence(){
		int[] a;
		for ( int i= 1; i < arrayTest.length; ++i) {
			a = Arrays.copyOf( arrayTest, arrayTest.length );
			assertEquals( i-1, NElement(a, 0, a.length-i, 1));	
			assertArrayEquals( arrayTest, a );
		}
	}
	
	@Test
	public void NElement_lastElementOfSequence(){
		int[] a;
		for ( int i= 1; i < arrayTest.length; ++i) {
			a = Arrays.copyOf(arrayTest, arrayTest.length);
			assertEquals( a.length-1, NElement(a, 0, a.length-i, a.length-i+1));	
			assertArrayEquals(arrayTest, a);
		}
		
		for ( int i= 0; i < arrayTest.length; ++i) {
			a = Arrays.copyOf(arrayTest, arrayTest.length);
			assertEquals( a.length-1-i, NElement(a, i, a.length-1, a.length-i));	
			assertArrayEquals(arrayTest, a);
		}
	}
	
	@Test
	public void nElement_OnMiddle(){
		int[] a;
		for ( int i= 1; i < arrayTest.length; ++i) {
			a = Arrays.copyOf(arrayTest, arrayTest.length);
			assertEquals( i-1, NElement(a, 0, a.length-1, i));	
			assertArrayEquals(arrayTest, a);
		}
	}
}
