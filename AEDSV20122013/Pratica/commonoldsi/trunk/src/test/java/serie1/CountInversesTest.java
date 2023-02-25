package serie1;
import org.junit.Test;

import serie1.ArrayUtils;
import static org.junit.Assert.*;
public class CountInversesTest {
	
	@Test
	public void countInverses_OnAnEmptyArray(){
		String[] v=new String[0];
		int count=ArrayUtils.countInverses(v, 0, -1);
		assertEquals(count,0);	
	}
	
	@Test
	public void countInverses_OnAnArrayWith1Element(){
		String[]v=new String[]{"aed"};
		int count=ArrayUtils.countInverses(v, 0, 0);
		assertEquals(count,0);	
	}
	
	@Test
	public void countInverses_OnAnArrayWithSomeElements(){
		String[]v=new String[]{"aed","cad","dea","git","otpx","ptx","xpto","z"};
		int count=ArrayUtils.countInverses(v, 0, v.length-1);
		assertEquals(count,2);	
	}

	
}
