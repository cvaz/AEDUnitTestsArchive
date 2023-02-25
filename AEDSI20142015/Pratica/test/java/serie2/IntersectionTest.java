package serie2;

import static org.junit.Assert.*;
import static serie2.ListUtils.intersection;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

public class IntersectionTest {
	
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
	public void  intersection_empty_lists(){
		Node<Integer> list1 = ListUtilTest.emptyListWithSentinel(), list2 = ListUtilTest.emptyListWithSentinel();	
		assertTrue(ListUtilTest.isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)));
		list1 = ListUtilTest.getList(0, 1, 1, null); list2 = ListUtilTest.emptyListWithSentinel();
		assertTrue(ListUtilTest.isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)));
		list1 = ListUtilTest.emptyListWithSentinel(); list2 = ListUtilTest.getList(0, 1, 1, null);
		assertTrue(ListUtilTest.isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)));
	}
	
	@Test
	public void intersection_singleton_lists(){
		Node<Integer> list1 = ListUtilTest.getList(0, 1, 1, null), list2 = ListUtilTest.getList(1, 1, 1, null);
		assertTrue(ListUtilTest.isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)));
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list1));
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list2));
		list1 = ListUtilTest.getList(1, 1, 1, null); list2 = ListUtilTest.getList(1, 1, 1, null);
		Node<Integer> res = intersection(list1, list2, CMP_NATURAL_ORDER);
		assertEquals(new Integer(1), res.value);
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list1));
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list2));
	}
	
	@Test
	public void intersection_different_lists(){
		Node<Integer> list1 = ListUtilTest.getList(0, 10, 2, null), list2 = ListUtilTest.getList(1, 10, 2, null);
		assertTrue(ListUtilTest.isEmptyListWithoutSentinel(intersection(list1, list2, CMP_NATURAL_ORDER)));
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list1));
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list2));
	}
	
	@Test
	public void intersection_equal_lists(){
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Node<Integer> list1 = ListUtilTest.getList(0, 10, 1, elements), list2 = ListUtilTest.getList(0, 10, 1, null);
		Node<Integer> res = intersection(list1, list2, CMP_NATURAL_ORDER);
		Node<Integer> curr = res;
		for (int i = 0; i < elements.size(); i++){
			assertTrue(elements.get(i).equals(curr.value));
			curr = curr.next;
		}
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list1));
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list2));
	}

	@Test
	public void intersection_mix_lists(){
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Node<Integer> list1 = ListUtilTest.getList(1, 10, 2, null), list2 = ListUtilTest.getList(1, 10, 4, elements);
		Node<Integer> res = intersection(list1, list2, CMP_NATURAL_ORDER);	
		Node<Integer> curr = res;
		for (int i = 0; i < elements.size(); i++){
			assertTrue(elements.get(i).equals(curr.value));
			curr = curr.next;
		}
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list1));
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list2));
	}
	
	@Test
	public void intersection_with_duplicates_lists(){
		ArrayList<Integer> elements = new ArrayList<Integer>(), elementsDups = new ArrayList<Integer>();
		Node<Integer> list1 = ListUtilTest.getListDups(1, 10, 2, null), list2 = ListUtilTest.getListDups(1, 10, 4, elementsDups);
		Node<Integer> res = intersection(list1, list2, CMP_NATURAL_ORDER);
		Node<Integer> curr = res;
		Integer prevValue = null;
		for (int i = 0; i < elementsDups.size(); i++) {
			if (elementsDups.get(i) != prevValue) {
				elements.add(elementsDups.get(i));
				prevValue = elementsDups.get(i);
			}
		}
		for (int i = 0; i < elements.size(); i++){
			assertTrue(elements.get(i).equals(curr.value));
			curr = curr.next;
		}
		assertFalse(ListUtilTest.isEmptyListWithSentinel(list1));
		assertTrue(ListUtilTest.isEmptyListWithSentinel(list2));
	}
}


