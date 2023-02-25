package serie2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import serie2.HeapUtils;

public class SameValuesTest {
	private static final int[] original1 = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
	private static final int[] original2 = {16, 10, 14, 4, 9, 7, 1, 3, 2, 8};
	private static final int[] original3 = {16, 10, 14, 4, 9, 12, 1, 3, 2, 8};
	private static final int[] emptySequence={};
         
	
	@Test
	public void test_same_values_in_empty_heaps(){
		Assert.assertTrue(HeapUtils.sameValues(emptySequence, emptySequence, 0));
	}
	
	@Test
	public void test_same_values_in_heaps(){
		int[] array1= Arrays.copyOf(original1, original1.length);
		int[] array2= Arrays.copyOf(original2, original2.length);
		Assert.assertTrue( HeapUtils.sameValues(array1, array2, array1.length) );
		Assert.assertArrayEquals(original1, array1);
		Assert.assertArrayEquals(original2, array2);
		Assert.assertTrue( HeapUtils.sameValues(array2, array1, array1.length) );
		Assert.assertArrayEquals(original1, array1);
		Assert.assertArrayEquals(original2, array2);
	}	
	
	@Test
	public void test_not_same_values_in_heaps(){
		int[] array1= Arrays.copyOf(original1, original1.length);
		int[] array2= Arrays.copyOf(original3, original3.length);
		Assert.assertFalse( HeapUtils.sameValues(array1, array2, array1.length) );
		Assert.assertArrayEquals(original1, array1);
		Assert.assertArrayEquals(original3, array2);
		Assert.assertFalse( HeapUtils.sameValues(array2, array1, array1.length) );
		Assert.assertArrayEquals(original1, array1);
		Assert.assertArrayEquals(original3, array2);
	}
}
