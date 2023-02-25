package serie2;


import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;
import static serie2.ListUtils.splitBySentence;

public class SplitBySentenceTest {

	@Test
	public void splitBySentence_emptyList() {
		Node<String> list = TestListUtil.emptyListWithSentinel();
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.isEmptyListWithSentinel(result));
		assertEquals(0,TestListUtil.countElements(result));
	}

	@Test
	public void splitBySentence_withOneWord() throws IOException {
		Node<String> list = TestListUtil.getListFromFile("OneWord.txt");
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.withoutDots(result.next.value));
		assertEquals(1,TestListUtil.countElements(result));
	}

	@Test
	public void splitBySentence_withOneWordAndOneDot() throws IOException {
		Node<String> list = TestListUtil.getListFromFile("OneWordAndDot.txt");
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.withoutDots(result.next.value));
		assertTrue(TestListUtil.onlyDots(list));
		assertEquals(1,TestListUtil.countElements(result));
	}

	@Test
	public void splitByUnit_oneSingleElementInEachList() throws IOException {
		Node<String> list = TestListUtil
				.getListFromFile("OneWordBySentence.txt");
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.onlyDots(list));
		Node<Node<String>> curr = result.next;
		while (curr != result) {
			assertTrue(TestListUtil.withoutDots(curr.value));
			assertEquals(1,TestListUtil.nonCircularlistSize(curr.value));
			curr = curr.next;
		}
		assertEquals(3,TestListUtil.circularListSize(result));
		assertEquals(3,TestListUtil.countElements(result));

	}
	
	@Test
	public void splitByUnit_WithMoreDots() throws IOException {
		Node<String> list = TestListUtil.getListFromFile("WithMoreDots.txt");
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.onlyDots(list));
		Node<Node<String>> curr = result.next;
		while (curr != result) {
			assertTrue(TestListUtil.withoutDots(curr.value));
			curr = curr.next;
		}
		assertEquals(3,TestListUtil.countElements(result));
		assertEquals(6, TestListUtil.countDots(list));

	}


	@Test
	public void splitByUnit_MoreThanOneElementInEachList() throws IOException {
		Node<String> list = TestListUtil.getListFromFile("carochinhaShort.txt");
		Node<Node<String>> result = splitBySentence(list);
		assertTrue(TestListUtil.onlyDots(list));
		Node<Node<String>> curr = result.next;
		while (curr != result) {
			assertTrue(TestListUtil.withoutDots(curr.value));
			curr = curr.next;
		}
		assertEquals(62,TestListUtil.countElements(result));
		assertEquals(3, TestListUtil.countDots(list));

	}

	@Test
	public void splitByUnit_MoreThanOneElementInEachListAndWithOtherPonctuation()
			throws IOException {
		Node<String> list = TestListUtil.getListFromFile("carochinha.txt");
		Node<Node<String>> result = splitBySentence(list);	
		assertTrue(TestListUtil.onlyDots(list));
		Node<Node<String>> curr = result.next;
		while (curr != result) {
			assertTrue(TestListUtil.withoutDots(curr.next.value));
			curr = curr.next;
		}
		assertEquals(58,TestListUtil.circularListSize(result));
		assertEquals(1137,TestListUtil.countElements(result));
		assertEquals(63, TestListUtil.countDots(list));

	}
	
	
	
}
