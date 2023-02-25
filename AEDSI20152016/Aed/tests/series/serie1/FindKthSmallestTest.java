package series.serie1;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import static series.serie1.Arrays.findKthSmallest;


public class FindKthSmallestTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test 
	public void findKthSmallestTest_onArraysWithNoElements(){
		int[] array1={};
		int[] array2={};
		exception.expect(NoSuchElementException.class);
	    findKthSmallest(array1,array2,1);
	}

	@Test
	public void findKthSmallestTest_onArraysWithJustOneElement(){
		int[] array1={1};
		int[] array2={};
		assertEquals(1, findKthSmallest(array1, array2, 1));
	}

	@Test
	public void findKthSmallestTest_onExampleArrays(){
		int[] array1={2,4,6,7,11,14,21,24,25};
		int[] array2={1,5,16,18};
		assertEquals(1, findKthSmallest(array1 , array2, 1));
		assertEquals(16, findKthSmallest(array1 , array2, 9));

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
			assertEquals(i, findKthSmallest(array1, array2, i+1));
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
			assertEquals(i - i % 2, findKthSmallest(array1, array2, i +1 ));
		}
	}

	
}
