package serie1;

import org.junit.Test;

import serie1.ArrayUtils;
import static org.junit.Assert.*;

public class LocalMinimumTest {
	@Test
	public void localMinimum_OnArrayWithOneElement(){
		int[] v=new int[]{1};
		int locmin=ArrayUtils.localMinimum(v, 0, 0);
		assertEquals(locmin,1);	
	}

	@Test
	public void  localMinimum_OnIncreasingArray(){
		int[] v=new int[]{0,1,3,5,6,8,9,10,12};
		int locmin=ArrayUtils.localMinimum(v, 0, 8);
		assertEquals(locmin,0);	
	}
	
	@Test
	public void localMinimum_OnDecreasingArray(){
		int[] v=new int[]{10,9,8,7,6,5,4,3,2,1,0};
		int locmin=ArrayUtils.localMinimum(v, 0, 10);
		assertEquals(locmin,0);	
	}
	
	
	@Test
	public void localMinimum_onArrayWithAMinimum(){
		int[] v=new int[]{1,6,8,10,8,6,2,7,10};
		int locmin=ArrayUtils.localMinimum(v, 0, 8);
	    assertTrue(locmin==1 || locmin==2);	
	}
	
	
}
