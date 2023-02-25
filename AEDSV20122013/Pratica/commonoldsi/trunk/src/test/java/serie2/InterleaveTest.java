package serie2;

import static org.junit.Assert.*;
import static serie2.ListUtils.interleave;

import java.util.ArrayList;

import static serie2.TestUtil.*;
import org.junit.Test;

public class InterleaveTest {
	@Test
	public void  interleave_empty_list(){
		Node<Node<Integer>> list = TestUtil.<Node<Integer>>emptyList();
		assertTrue( isEmptyList( interleave(list) ) );
	}

	@Test
	public void  interleave_empty_lists(){
		Node<Node<Integer>> list = new Node<Node<Integer>>();
		Node<Node<Integer>> current = list;
		for (int i= 0; i < 3; ++i ) {
		  current.next =  newNode( TestUtil.<Integer>emptyList(), current, list );
		  current= current.next;
		}
		list.previous = current;
		assertTrue( isEmptyList( interleave(list) ) );
		assertTrue( isEmptyList( list ) );
	}

	@Test
	public void  interleave_lists(){
		Node<Node<Integer>> list, current;
		ArrayList<Node<Integer>> array;
		for (int  numberOfLists=1; numberOfLists <=4; ++numberOfLists) {
			for (int lengthOfLists=1; lengthOfLists <=3; ++lengthOfLists) {
			    list = new Node<Node<Integer>>();
				current = list;
				array= new ArrayList<Node<Integer>>();
				for ( int i= 0; i < numberOfLists; ++i ) {
					  current.next =  newNode( TestUtil.<Integer>emptyList(), current, list);
					  current= current.next;
					  current.next =  newNode( getList(i*lengthOfLists, lengthOfLists, array), current, list );
					  current= current.next;
					}
				list.previous = current;
				
				Node<Integer> result = interleave(list), currResult = result.next;
				for (int i=0; i < lengthOfLists; ++ i ) {
					for (int j=0; j < numberOfLists; ++ j ) {
						assertTrue( array.get(currResult.value) == currResult );
						assertEquals(j*lengthOfLists+i, currResult.value.intValue() );
						currResult= currResult.next;
					}
				}
				assertTrue( currResult == result );
				assertTrue( isEmptyList( list ) );
			}
		}
	}
}
