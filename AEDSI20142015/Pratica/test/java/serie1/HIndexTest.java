package serie1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HIndexTest {
	
	@Test
	public void hIndex_OnEmptyArray(){
		int[] v1=new int[0];
		int hIndex=Arrays.hIndex(v1);
		assertEquals(-1,hIndex);	
	}
	
	@Test
	public void hIndex_SingleElementArray(){
		int[] v1={3};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(1,hIndex);	
	}
	@Test
	public void hIndex_WithSmallerElementsOrdered(){
		int[] v1={7,8,10,15,17};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(5,hIndex);			
	}
	
	@Test
	public void hIndex_WithSmallerElementsUnOrdered(){
		int[] v1={10,8,7,17,5};
		int hIndex=Arrays.hIndex(v1);	
		assertEquals(5,hIndex);			
	}

	@Test
	public void hIndex_WithGreaterElementsAndWithEquals(){
		int[] v1={8,17,15,10,8};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(5,hIndex);			
	}
	
	@Test
	public void hIndex_WithGreaterElements(){
		int[] v1={2,8,6,5,7};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(4,hIndex);			
	}
	
	@Test
	public void hIndex_WithSmallerElementsAndWithEquals(){
		int[] v1={1,2,2,3,3};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(2,hIndex);			
	}
	

	@Test
	public void hIndex_On_An_Array(){
		int[] v1={3,7,2,10,6,9,1,8};
		int hIndex=Arrays.hIndex(v1);
		assertEquals(5,hIndex);	
	}
	

}
