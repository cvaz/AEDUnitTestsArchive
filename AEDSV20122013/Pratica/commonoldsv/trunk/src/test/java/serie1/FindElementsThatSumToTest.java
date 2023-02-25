package serie1;


import org.junit.Test;

import serie1.ArrayUtils;
import static org.junit.Assert.*;

public class FindElementsThatSumToTest {

	@Test
	public void findElementsThatSumTo_OnEmptyArray(){
		int[] v=new int[0];
		int[] vf=ArrayUtils.findElementsThatSumTo(v, 0, -1, 2);
		assertEquals(vf.length,0);	
	}
	
	@Test
	public void findElementsThatSumTo_WithAPairOfElements(){
		int[] v=new int[]{1,3,5,6,8,9,10,12};
		int[] vf=ArrayUtils.findElementsThatSumTo(v, 0, 7, 10);
		assertArrayEquals(vf,new int[]{1,9});	
	}

	
	@Test
	public void findElementsThatSumTo_WithOtherPairOfElements(){
		int[] v=new int[]{0,1,3,5,7,8,9,10,12};
		int[] vf=ArrayUtils.findElementsThatSumTo(v, 0, 8, 14);
		assertArrayEquals(vf,new int[]{5,9});	
	}
	
	@Test
	public void findElementsThatSumTo_WithMoreThanOnePairOfElements(){
		int[] v=new int[]{0,1,3,5,6,8,9,10,12};
		int[] vf=ArrayUtils.findElementsThatSumTo(v, 0, 8, 11);
		assertTrue((vf[0]==1 && vf[1]==10) ||(vf[0]==5 && vf[1]==6) ||(vf[0]==3 && vf[1]==8));	
	}
	
	@Test
	public void findElementsThatSumTo_WithNoPairsOfElements(){
		int[] v=new int[]{0,1,3,5,6,8,9,10,12};
		int[] vf=ArrayUtils.findElementsThatSumTo(v, 0, 8, 23);
		assertEquals(vf.length,0);	
	}
	
	
}
