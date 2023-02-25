package serie1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.*;
import org.junit.rules.ExpectedException;
import static serie1.ArrayUtils.removeFromMaxHeap;

public class RemoveFromMaxHeapTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test 
	public void removeFromMaxHeap_onEmptyHeap(){
		exception.expect(IllegalArgumentException.class);
	    removeFromMaxHeap(new int[0],0,0 );	
	}
	
	@Test 
	public void removeFromMaxHeap_withIllegalArguments(){
		exception.expect(IllegalArgumentException.class);
		for(int i =0;i<10;i++)
			removeFromMaxHeap(new int[i],i,i );	
	}
	
	@Test 
	public void removeFromMaxHeap_onHeapWithOneElement() {
		int[] maxHeap = { 1 };
	    assertEquals(1,removeFromMaxHeap( maxHeap, 1,0 ));	
	}
	
	@Test 
	public void removeFromMaxHeap_onHeapWithTwoElements() {
		int[] maxHeap = { 2, 1 };
		for(int i=0;i<2;i++)
			assertEquals(2-i,removeFromMaxHeap( maxHeap, 2-i,0 ));	
	}

	@Test 
	public void removeFromMaxHeap_onHeap1() {
		int[] maxHeapBeforeRemoval = {8, 7, 6, 5, 4, 3, 2 };
		int[] result = {7, 5, 6, 2, 4, 3};
		 assertEquals(8,removeFromMaxHeap( maxHeapBeforeRemoval, 7,0 ));	
		 int[] maxHeapAfterRemoval=Arrays.copyOfRange(maxHeapBeforeRemoval, 0, 6);
		 assertArrayEquals(maxHeapAfterRemoval,result);
		 
	}
	
	@Test 
	public void removeFromMaxHeap_onHeap2() {
		int[] maxHeapBeforeRemoval = {16, 15, 18, 10, 9, 12, 14, 3, 4, 5, 2 };
		int[] result = {16, 10, 18, 5, 9, 12, 14, 3, 4};
		 assertEquals(15,removeFromMaxHeap( maxHeapBeforeRemoval, 10, 1 ));	
		 int[] maxHeapAfterRemoval=Arrays.copyOfRange(maxHeapBeforeRemoval, 0, 9);
		 assertArrayEquals(maxHeapAfterRemoval,result);
		 
	}
	
	@Test 
	public void removeFromMaxHeap_onHeap3() {
		int[] maxHeapBeforeRemoval = {16, 15, 18, 10, 9, 12, 14, 3, 4, 5, 2 };
		int[] result = {16, 15, 14, 10, 9, 12, 2, 3, 4, 5 };
		 assertEquals(18,removeFromMaxHeap( maxHeapBeforeRemoval, 11, 2 ));
		 int[] maxHeapAfterRemoval=Arrays.copyOfRange(maxHeapBeforeRemoval, 0, 10);
		 assertArrayEquals(maxHeapAfterRemoval,result);
		 
	}
	
	

}
