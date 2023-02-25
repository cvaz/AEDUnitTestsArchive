package serie1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import static serie1.ArrayUtils.removeIndexes;

public class RemoveIndexesTest {
	private static final int[] original={0, 1, 2, 3, 4, 5, 6, 7, 8 };
	private static final int[] emptySequence={};
            
	@Test
	public void test_removeIndexes_in_empty_subsequence(){
		Assert.assertEquals(0,removeIndexes(emptySequence, 0, emptySequence.length-1,
				                            emptySequence, 0, emptySequence.length-1));

		Assert.assertEquals(0,removeIndexes(emptySequence, 0, emptySequence.length-1,
                                            original, 0, original.length-1));
	}
	
	@Test
	public void test_removeIndexes_with_empty_indexes(){
		int[] arrayTest;
		for ( int length= 1; length <= 3; ++length) {
			arrayTest=  Arrays.copyOf( original, length );
			Assert.assertEquals(arrayTest.length,
					removeIndexes(arrayTest, 0, arrayTest.length-1,
                                              emptySequence,0,emptySequence.length-1));
			Assert.assertArrayEquals( Arrays.copyOf(original, length), arrayTest );
		}
	}
	
	@Test
	public void test_removeIndexes_intercalated(){
		int[][] indexes= { { 0, 2, 4, 6, 8 }, { 1, 3, 5, 7 } },
		      expecteds ={ { 1, 3, 5, 7 }, { 0, 2, 4, 6, 8 }};
		int[] arrayTest;
		for (int i=0; i < indexes.length; ++i ){
			arrayTest= Arrays.copyOf( original, original.length );
			Assert.assertEquals(expecteds[i].length,
					removeIndexes(arrayTest, 0, arrayTest.length-1,
					            		      indexes[i],0,indexes[i].length-1));
		    Assert.assertArrayEquals(expecteds[i], 
		    		                 Arrays.copyOf(arrayTest, expecteds[i].length));
		}
	}
	
	@Test
	public void test_removeIndexes_at_the_end_of_the_sequence(){
		int[] arrayTest= Arrays.copyOf(original, original.length);
		for ( int index = 0; index < original.length; ++index) {
			arrayTest = Arrays.copyOf(original, original.length);
			Assert.assertEquals(index,removeIndexes(arrayTest, 0, arrayTest.length-1,
		                                            original, index, original.length-1));
			Assert.assertArrayEquals(original, arrayTest);
		}
	}
	
	@Test
	public void test_removeIndexes_at_begin_of_the_sequence(){
		int[] arrayTest;
		for ( int index = 0; index < original.length; ++index) {
			arrayTest = Arrays.copyOf(original, original.length);
			Assert.assertEquals(original.length-(index+1),
					removeIndexes(arrayTest, 0, arrayTest.length-1,
					            		      original, 0, index));
			Assert.assertArrayEquals(Arrays.copyOfRange(original, index+1, original.length), 
		    		                 Arrays.copyOf(arrayTest, original.length-(index+1)));
		}
	}
	
	@Test
	public void test_removeIndexes_with_lower_indexes(){
		int[] arrayTest=Arrays.copyOf(original, original.length);
		int index = 5;
		// All less - not remove
		Assert.assertEquals(arrayTest.length-5,
				ArrayUtils.removeIndexes(arrayTest, index, arrayTest.length-1,
				            		      original, 0, index-1));
		Assert.assertArrayEquals( original, arrayTest );
		
		// Remove one - last index
		for (index = 0; index < original.length; ++index ) {
			arrayTest=Arrays.copyOf( original, original.length );
			Assert.assertEquals(arrayTest.length-index-1,
					removeIndexes(arrayTest, index, arrayTest.length-1,
					                          original, 0, index));
			Assert.assertArrayEquals( Arrays.copyOf(original, index),
	                                  Arrays.copyOf(arrayTest, index));
			Assert.assertArrayEquals( Arrays.copyOfRange(original, index+1, original.length),
	                                  Arrays.copyOfRange(arrayTest, index, arrayTest.length-1));
		}
	}
	
	@Test
	public void test_removeIndexes_with_higher_indexes(){
		int[] arrayTest = Arrays.copyOf(original, original.length);
		//All greater
		arrayTest = Arrays.copyOf(original, original.length); 
		Assert.assertEquals(5,ArrayUtils.removeIndexes(arrayTest, 0, 4,
				                            original, 5, original.length-1));
		Assert.assertArrayEquals( original, arrayTest );

		// Remove one - first index
		for (int index = 0; index < original.length; ++index ) {
			arrayTest = Arrays.copyOf(original, original.length); 
			Assert.assertEquals(index,
					removeIndexes(arrayTest, 0, index,
		                                      original, index, original.length-1));
			Assert.assertArrayEquals( original, arrayTest );
		}
	}
}
