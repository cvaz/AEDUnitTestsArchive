package serie1;
import java.util.NoSuchElementException;
import org.junit.Assert;
import static serie1.Arrays.findKthSmallest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FindKthSmallestTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test 
	public void findKthSmallestTest_onArraysWithNoElements(){
		int[] array1={};
		int[] array2={};
		exception.expect(NoSuchElementException.class);
	    findKthSmallest(array1,array2,0);	
	}

	@Test
	public void findKthSmalletTest_onArraysEvenOdd(){
		int array1[] = new int[10];
		int array2[] = new int[10];
		for(int i=0; i<10;i++){
			array1[i]=2*i;
			array2[i]=2*i+1;	
		}
		for(int i=0;i<20;i++){
			Assert.assertEquals(i, findKthSmallest(array1,array2,i));	
		}
	}
	
	@Test
	public void findKthSmallestTest_onArraysWithDuplicates(){
		int array1[] = new int[10];
		int array2[] = new int[10];
		for(int i=0; i<10;i++){
			array1[i]=2*i;
			array2[i]=2*i;	
		}
		for(int i=0;i<20;i++){
			Assert.assertEquals(i-i%2, findKthSmallest(array1,array2,i));	
		}
	}
	
	
	
}
