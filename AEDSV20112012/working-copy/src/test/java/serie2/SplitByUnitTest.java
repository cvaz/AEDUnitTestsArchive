package serie2;
import junit.framework.Assert;

import org.junit.Test;
import static org.junit.Assert.*;
import static serie2.ListUtils.splitByUnit;
public class SplitByUnitTest {

	@Test
	public void  splitByUnit_emptyList(){
		Node<Integer> list = TestListUtil.emptyListWithoutSentinel();
		Node<Node<Integer>> result=splitByUnit(list);
	    for(int i=0;i<10;i++){  
		assertTrue(TestListUtil.isEmptyListWithoutSentinel(result.value) );
		result=result.next;
	    }
	   }
	  
	 @Test
	 public void splitByUnit_oneSingleElementInEachList(){
		 Node<Integer> list=TestListUtil.getNodeList(0,10,1);
		 Node<Node<Integer>> result=splitByUnit(list);
		 for(int i=0;i<10;i++){ 
			Assert.assertEquals(i, result.value.value.intValue()); 
			result=result.next;
		 }
	}
	 
	 @Test
	 public void splitByUnit_MoreThanOneElementInEachList(){
		 Node<Integer> list=TestListUtil.getNodeList(0,50,1);
		 Node<Node<Integer>> result=splitByUnit(list);
		 for(int i=0;i<10;i++){ 
			 Node<Integer> sublist=result.value;
			 while(sublist!=null){ 
				 Assert.assertEquals(i, sublist.value.intValue()%10); 
				 sublist=sublist.next;
			 }
			result=result.next;
		 }
		 }
	
	
	@Test
	public void splitByUnit_OddListsWithoutElements(){
		 Node<Integer> list=TestListUtil.getNodeList(0,50,2);
		 Node<Node<Integer>> result=splitByUnit(list);
		 for(int i=0;i<10;i++){ 
			 Node<Integer> sublist=result.value;
			 while(sublist!=null){ 
				 Assert.assertEquals(i, sublist.value.intValue()%10); 
				 sublist=sublist.next;
			 }
			result=result.next;
		 }
		 }
	
	@Test
	public void splitByUnit_EvenListsWithoutElements(){
		 Node<Integer> list=TestListUtil.getNodeList(1,50,2);
		 Node<Node<Integer>> result=splitByUnit(list);
		 for(int i=0;i<10;i++){ 
			 Node<Integer> sublist=result.value;			 
			 while(sublist!=null){ 	 
				 Assert.assertEquals(i, sublist.value.intValue()%10); 
				 sublist=sublist.next;
			 }
			result=result.next;
		 }
		 }
	

	
	
}
