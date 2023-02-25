package serie2;
import junit.framework.Assert;
import org.junit.Test;
import static serie2.HeapUtils.hasEquals;

public class HasEqualsTest {
	
	@Test
	public void hasEquals_inHeapWithNoElements(){
		Assert.assertEquals(false,hasEquals(new int[0],0));
	}
	@Test
	public void hasEquals_inHeapWithOneElement(){
		Assert.assertEquals(false,hasEquals(new int[]{10},1));
	}
	
	@Test
	public void hasEquals_inSortedDecreasingArray(){
		int[] heap1={10,9,8,7,6,5,4,3,2,1,0};
	    for(int i=0;i<=11;i++){
			Assert.assertEquals(false,hasEquals(heap1,i));
	  }
	}
	
	@Test
	public void hasEquals_WithADuplicateInDifferentLevel(){
		int[] heap2={14,12,7,10,4,3,5,6,4,8,7};
		Assert.assertEquals(true,hasEquals(heap2,11));
	}
	
	@Test
	public void hasEquals_WithADuplicateInSameLevel(){
	 int[] heap3={20,16,18,13,15,10,9,8,6,8,7};
	 Assert.assertEquals(true,hasEquals(heap3,11));
	}
}
