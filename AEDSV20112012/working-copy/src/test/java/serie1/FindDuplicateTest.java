package serie1;

import org.junit.Test;

import serie1.ArrayUtils;
import static org.junit.Assert.*;


public class FindDuplicateTest {

	@Test
	public void findDuplicates_OnEmptyArray(){
		int[] v=new int[]{0,2,1,3,3,4};
		int index=ArrayUtils.findDuplicate(v, 0, -1);
		assertEquals(index,-1);	
	}
	
	@Test
	public void findDuplicates_OnArrayWithDuplicateSequence(){
		int[] v=new int[]{0,2,1,3,3,4};
		int index=ArrayUtils.findDuplicate(v, 0, 5);
		
		assertEquals(v[index],3);	
	}
	
	@Test
	public void findDuplicates_OnArrayWithOtherDuplicateSequence(){
		int[] v=new int[]{0,3,3,2,1,4};
		int index=ArrayUtils.findDuplicate(v, 0, 5);
		assertEquals(v[index],3);	
	}
	
	@Test
	public void findDuplicates_OnArrayWithDuplicate(){
		int[] v=new int[]{0,2,1,3,6,8,7,5,3,4};
		int index=ArrayUtils.findDuplicate(v, 0, 9);
		assertEquals(v[index],3);	
	}
	
	@Test
	public void findDuplicates_OnArrayWithOtherDuplicate(){
		int[] v=new int[]{5,6,8,9,12,13,7,1,15,3,0,14,10,11,4,2,8};
		int index=ArrayUtils.findDuplicate(v, 0, 16);
		assertEquals(v[index],8);	
	}
}
