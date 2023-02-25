package serie2;
import java.util.ArrayList;
import java.util.Collections;
import junit.framework.Assert;
import org.junit.Test;
import static serie2.HeapUtils.minimum;

public class MinimumTest {
	private static final int[] heap1={10,9,8,7,6,5,4,3,2,1,0};
	private static final int[] heap2={14,12,7,10,4,3,5,6,4,8,7};
	
	@Test
	public void minimum_inHeapWithOneElement(){
		Assert.assertEquals(10,minimum(heap1, 1));
	}
	
	@Test
	public void minimum_WithSortedArray(){
		for(int i=1;i<=heap1.length;i++){
			Assert.assertEquals(heap1[i-1],minimum(heap1,i ));
		}
	}
	
	@Test
	public void minimum_WithSomeHeap(){
		for(int i=6;i<=heap2.length;i++)
		Assert.assertEquals(3,minimum(heap2, i));
	}
	
	@Test
	public void minimum_WithRandomHeap(){
		for(int i=1; i< 20; i++){
			int[] heap= TestHeapUtils.randomHeap(i, 2*i);
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int j=0;j<i;j++){
			    list.add(heap[j]);
			}
			Assert.assertEquals(Collections.min(list).intValue(),minimum(heap,i));
		}
	}
	
}
