package serie1;

import org.junit.Test;

import serie1.Arrays;
import static org.junit.Assert.*;

public class CountEqualsTest {
	
	@Test
	public void countEquals_OnBothEmptyArrays(){
		int[] v1=new int[0];
		int[] v2=new int[0];
		int count=Arrays.countEquals(v1, 0, -1, v2, 0, -1);
		assertEquals(0,count);	
	}
	
	@Test
	public void countEquals_OnAnArraysWithOneEqualElementInTheMiddle(){
		int[] v1=new int[]{1,3,4,5,7,10,12};
		int[] v2=new int[]{0,2,6,7,11,13};
		int count=Arrays.countEquals(v1, 0, 6, v2, 0, 5);
		assertEquals(1,count);	
	}
	
	@Test
	public void countEquals_OnAnArraysWithOneEqualElementInTheFront(){
		int[] v1=new int[]{1,3,4,5,7,10,12};
		int[] v2=new int[]{1,2,6,8,11,13};
		int count=Arrays.countEquals(v1, 0, 6, v2, 0, 5);
		assertEquals(1,count);	
	}
	
	@Test
	public void countEquals_OnAnArraysWithOneEqualElementInTheEnd(){
		int[] v1=new int[]{1,3,4,5,7,10,12};
		int[] v2=new int[]{0,2,6,8,11,12,14,17};
		int count=Arrays.countEquals(v1, 0, 6, v2, 0, 7);
		assertEquals(1,count);	
	}
	
	@Test
	public void countEquals_OnAnArraysWithSomeEqualElements(){
		int[] v1=new int[]{1,3,4,5,7,10,12,14,20,22,30,41};
		int[] v2=new int[]{0,3,6,8,11,12,14,20,24,33,41,50,60};
		int count=Arrays.countEquals(v1, 0, v1.length-1, v2, 0, v2.length-1);
		assertEquals(5,count);	
	}
	
	

}
