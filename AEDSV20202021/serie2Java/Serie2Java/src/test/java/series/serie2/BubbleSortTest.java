package series.serie2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static series.serie2.ListUtilTest.*;
import static series.serie2.ListUtils.bubbleSort;

public class BubbleSortTest {
    @Test
    public void bubblesort_empty_list() {
        Node<Integer> list = ListUtilTest.emptySListWithSentinel();
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    @Test
    public void bubblesort_with_oneElement_list() {
        Node<Integer> list = getRandomSList(1);
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    @Test
    public void bubblesort_with_SomeElements1_list() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(4);
        array.add(3);
        array.add(2);
        array.add(1);
        Node<Integer> list = getSListWithSentinel(array);
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    @Test
    public void bubblesort_with_increasingElements() {
        Node<Integer> list = getSListWithSentinel(0, 20, 1);
        bubbleSort(list, CMP_REVERSE_ORDER);
        assertTrue(isSListSorted(list, CMP_REVERSE_ORDER));
    }

    @Test
    public void bubblesort_with_SomeElements2_list() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(22);
        array.add(-30);
        array.add(-30);
        array.add(32);
        array.add(-38);
        array.add(-34);
        array.add(-36);
        Node<Integer> list = getSListWithSentinel(array);
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    @Test
    public void bubblesort_with_someElements3_list() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(27);
        array.add(-12);
        array.add(33);
        array.add(27);
        array.add(26);
        array.add(-33);
        array.add(14);
        array.add(26);
        array.add(8);
        array.add(9);
        array.add(-19);
        Node<Integer> list = getSListWithSentinel(array);
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    @Test
    public void bubblesort_with_randomElements_list() {
        Node<Integer> list = getRandomSList(11);
        bubbleSort(list, CMP_NATURAL_ORDER);
        assertTrue(isSListSorted(list, CMP_NATURAL_ORDER));
    }

    static final Comparator<Integer> CMP_REVERSE_ORDER = (i1, i2) -> i2.compareTo(i1);

    static final Comparator<Integer> CMP_NATURAL_ORDER = (i1, i2) -> i1.compareTo(i2);

}








