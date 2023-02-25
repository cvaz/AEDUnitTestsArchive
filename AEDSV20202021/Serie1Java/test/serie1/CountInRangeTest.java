package serie1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static serie1.Arrays.countInRange;


import java.util.Arrays;
import java.util.Random;



public class CountInRangeTest {
	
	@Test
	public void countInRange_onAnEmptyArray_returns0(){
		int[] v = new int[0];
		int res = countInRange(v, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(0,res);
	}
	
	@Test
	public void countInRange_withFullRange_returnsArrayLength (){	
		final int len = 100;
		int[] v = new int[len];
		Random r = new Random();
		for(int i = 0 ; i<len ; ++i) v[i] = r.nextInt(); 
		Arrays.sort(v);		
		int res = countInRange(v, 0, v.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(v.length,res);
	}
	
	@Test
	public void countInRange_withRepeatedValues_returnsCorrectedValue (){	
		int[] v = new int[]{0,0,0,1,1,1,1,1,1,1,2,2,2,2};				
		int res = countInRange(v, 0, v.length-1, 1, 1);
		assertEquals(7,res);
	}
	
	@Test
	public void countInRange_withNoValuesInLimits (){	
		int[] v = new int[]{0,0,0,1,1,1,1,1,1,1,5,5,5,6,6,6};				
		int res = countInRange(v, 0, v.length-1, 2, 3);
		assertEquals(0,res);
	}
	
}
