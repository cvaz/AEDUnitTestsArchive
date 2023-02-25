package serie2;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import serie2.HeapUtils;
import static serie2.TestUtil.*;

public class UniquesTest {
	private static final int[] original={10, 5, 5, 5, 3, 5, 2, 4 };
	private static final int[] emptySequence={};
            
	@Test
	public void test_uniques_in_empty_heap(){
		Assert.assertEquals(0,HeapUtils.uniques(emptySequence, 0));
	}
	
	@Test
	public void test_uniques_no_duplicates(){
		int[] arrayTest;
		arrayTest = Arrays.copyOf(original, original.length);
		arrayTest = Arrays.copyOf(arrayTest, HeapUtils.uniques(arrayTest, arrayTest.length));
		Assert.assertTrue(containsAll(arrayTest, arrayTest.length, original, original.length));
		Assert.assertTrue(containsAll(original, original.length, arrayTest, arrayTest.length));
		Assert.assertTrue( noDuplicates(arrayTest) );
	}
		
	@Test
	public void test_uniques_is_max_heap(){	
		int[] arrayTest;
		arrayTest = Arrays.copyOf(original, original.length);
		arrayTest = Arrays.copyOf(arrayTest, HeapUtils.uniques(arrayTest, arrayTest.length));		
		Assert.assertTrue( isMaxHeap(arrayTest, arrayTest.length) );   
	}
	
}
