package serie2;

import org.junit.Test;
import java.util.*;

import static serie2.ListUtils.concat;
import static org.junit.Assert.*;
import static serie2.TestUtil.*;

public class ConcatTest {

	@Test
	public void  concat_empty_list(){
		Node<Node<Integer>> list = TestUtil.<Node<Integer>>emptyList();
		assertTrue( isEmptyList( concat(list) ) );
	}
	
	@Test
	public void  concat_empty_lists(){
		Node<Node<Integer>> list = new Node<Node<Integer>>();
		Node<Node<Integer>> current = list;
		for (int i= 0; i < 3; ++i ) {
		  current.next = newNode( TestUtil.<Integer>emptyList(), current, list);
		  current= current.next;
		}
		list.previous =  current;
		assertTrue( isEmptyList( concat(list) ) );
		assertTrue( isEmptyList( list ) );
	}
	
	@Test
	public void  concat_lists(){
		Node<Node<Integer>> list, current;
		ArrayList<Node<Integer>> array;
		for (int  numberOfLists=1; numberOfLists <=4; ++numberOfLists) {
			for (int lengthOfLists =1; lengthOfLists <=3; ++lengthOfLists) {
			    list = new Node<Node<Integer>>();
				current = list;
				array= new ArrayList<Node<Integer>>();
				for ( int i= 0; i < numberOfLists; ++i ) {
				  current.next =  newNode( TestUtil.<Integer>emptyList(), current, list);
				  current= current.next;
				  current.next =  newNode( getList(i*lengthOfLists, lengthOfLists, array), current, list);
				  current= current.next;
				  current.next =  newNode( TestUtil.<Integer>emptyList(), current, list);
				  current= current.next;
				}
				list.previous = current;
				Node<Integer> result = concat(list), currResult = result.next;
				for (int i=0; i < array.size(); ++i, currResult= currResult.next  ) {
					assertTrue( array.get(i) == currResult );
					assertEquals(i, currResult.value.intValue() );
				}
				assertTrue( currResult == result);
				assertTrue( isEmptyList( list ) );
			}
		}
	}
}
