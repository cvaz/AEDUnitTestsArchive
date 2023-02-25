package serie2;

import static org.junit.Assert.*;
import static serie2.ListUtils.getOrderedSequence;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

public class GetOrderedSequenceTest {

	static final Comparator<Integer> CMP_REVERSE_ORDER= new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1);
		}
	};	

	static final Comparator<Integer> CMP_NATURAL_ORDER= new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	};	
	
	@Test
	public void  splitByUnit_emptyList(){
		Node<Node<Integer>> list = TestListUtil.<Node<Integer>>emptyListWithSentinel();
		Node<Integer> result=getOrderedSequence(list,CMP_NATURAL_ORDER); 
		assertTrue(TestListUtil.isEmptyListWithSentinel(result) );
	   }
	
	@Test
	public void splitByUnit_WithOneElementInEachList(){
		ArrayList<ArrayList<Integer>> listOfLists=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<10;i++){
			ArrayList<Integer> subList=new ArrayList<Integer>();
			subList.add(i);
			listOfLists.add(subList);
		}
		Node<Node<Integer>> list=TestListUtil.getListOfLists(listOfLists);
		Node<Integer> result=getOrderedSequence(list,CMP_NATURAL_ORDER);
		assertTrue(TestListUtil.isSorted(result, CMP_NATURAL_ORDER));
		result=result.next;
		for(int i=0;i<10;i++){
			assertEquals(result.value,listOfLists.get(i).get(0));
			result=result.next;
		}
	}
	
	@Test
	public void splitByUnit_WithOddEvenLists(){
		ArrayList<ArrayList<Integer>> listOfLists=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<2;i++){
			ArrayList<Integer> subList=new ArrayList<Integer>();
			for(int j=i;j<30;j+=2){
				subList.add(j);
			}
			listOfLists.add(subList);
		}
		Node<Node<Integer>> list=TestListUtil.getListOfLists(listOfLists);
		Node<Integer> result=getOrderedSequence(list,CMP_NATURAL_ORDER);
		assertTrue(TestListUtil.isSorted(result, CMP_NATURAL_ORDER));
		result=result.next;
		for(int i=0;i<30;i++){
			int index=i%2;
			assertEquals(result.value,listOfLists.get(index).get(i/2));
			result=result.next;
		}
	}
	
	@Test
	public void splitByUnit_WithOddEvenListsReverse(){
		ArrayList<ArrayList<Integer>> listOfLists=new ArrayList<ArrayList<Integer>>();
		for(int i=1;i>=0;i--){
			ArrayList<Integer> subList=new ArrayList<Integer>();
			for(int j=30+i;j>i;j-=2){
				subList.add(j);
			}		
			listOfLists.add(subList);
		}
		Node<Node<Integer>> list=TestListUtil.getListOfLists(listOfLists);
		Node<Integer> result=getOrderedSequence(list, CMP_REVERSE_ORDER);
		assertTrue(TestListUtil.isSorted(result,CMP_REVERSE_ORDER));
		result=result.next;
		for(int i=0;i<30;i++){
			int index=i%2;
			assertEquals(result.value,listOfLists.get(index).get(i/2));
			result=result.next;
		}
	}
	
	
}
