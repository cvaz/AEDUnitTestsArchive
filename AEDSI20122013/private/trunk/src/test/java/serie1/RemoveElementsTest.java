package serie1;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import static serie1.Arrays.removeElements;

public class RemoveElementsTest {
	private static final int[] original={0, 1, 2, 3, 4, 5, 6, 7, 8};
	private static final int[] emptySequence={};
            
	@Test
	public void test_removeElements_in_empty_subsequence(){
		assertEquals(0,removeElements(emptySequence, 0, emptySequence.length-1,
			emptySequence, 0, emptySequence.length-1));

		assertEquals(0,removeElements(emptySequence, 0, emptySequence.length-1,
			original, 0, original.length-1));
	}
	
	@Test
	public void test_removeElements_with_empty_Elements(){
		int[] arrayTest;
		for ( int length= 1; length <= 3; ++length) {
			arrayTest=  Arrays.copyOf( original, length );
			assertEquals(arrayTest.length, 
				removeElements(arrayTest, 0, arrayTest.length-1,
				emptySequence,0,emptySequence.length-1));
			assertArrayEquals( Arrays.copyOf(original, length), arrayTest );
		}
	}
		
	@Test
	public void test_removeElements_intercalated(){
		int[][] elements = { { 0, 2, 4, 6, 8 }, { 1, 3, 5, 7 } },
		      expecteds ={ { 1, 3, 5, 7 }, { 0, 2, 4, 6, 8 }};
		int[] arrayTest;
		for (int i=0; i < elements.length; ++i ){
			arrayTest= Arrays.copyOf( original, original.length );
			assertEquals(expecteds[i].length,
				removeElements(arrayTest, 0, arrayTest.length-1,
				elements[i],0,elements[i].length-1));
		    assertArrayEquals(expecteds[i], 
		    	Arrays.copyOf(arrayTest, expecteds[i].length));
		}
	}
	
	@Test
	public void test_removeElements_at_the_end_of_the_sequence(){
		int[] arrayTest= Arrays.copyOf(original, original.length);
		for ( int index = 0; index < original.length; ++index) {
			arrayTest = Arrays.copyOf(original, original.length);
			assertEquals(index,removeElements(arrayTest, 0, arrayTest.length-1,
				original, index, original.length-1));
			assertArrayEquals(original, arrayTest);
		}
	}
	
	@Test
	public void test_removeElements_at_begin_of_the_sequence(){
		int[] arrayTest;
		for ( int index = 0; index < original.length; ++index) {
			arrayTest = Arrays.copyOf(original, original.length);
			assertEquals(original.length-(index+1),
				removeElements(arrayTest, 0, arrayTest.length-1,
				original, 0, index));
			assertArrayEquals(Arrays.copyOfRange(original, index+1, original.length), 
		    	Arrays.copyOf(arrayTest, original.length-(index+1)));
		}
	}
	
}
