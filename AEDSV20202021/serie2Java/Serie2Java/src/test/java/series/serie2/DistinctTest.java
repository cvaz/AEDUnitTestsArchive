package series.serie2;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static series.serie2.ListUtilTest.*;
import static series.serie2.ListUtils.distinct;

public class DistinctTest {
    @Test
    public void distinct_empty_list() {
        Node<Integer> list = emptyListWithSentinelNonCircular();
        Node<Integer> returnList = distinct(list, CMP_NATURAL_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER));
        assertEquals(0, getSize(returnList));
    }

    @Test
    public void distinct_with_oneElement_list() {
        Node<Integer> list = makeDListNonCircular(10);
        Node<Integer> returnList = distinct(list, CMP_NATURAL_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER));
        assertEquals(1, getSize(returnList));
    }

    @Test
    public void distinct_with_SomeElements1_list() {
        Integer[] intArray = new Integer[4];
        intArray[0] = 4;
        intArray[1] = 3;
        intArray[2] = 2;
        intArray[3] = 1;
        Node<Integer> list = makeDListNonCircular(intArray);
        Node<Integer> returnList = distinct(list, CMP_REVERSE_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_REVERSE_ORDER));
        assertEquals(4, getSize(returnList));
    }

    @Test
    public void distinct_with_SomeElements2_list() {
        Integer[] intArray = new Integer[7];
        intArray[0] = 4;
        intArray[1] = 4;
        intArray[2] = 4;
        intArray[3] = 3;
        intArray[4] = 2;
        intArray[5] = 2;
        intArray[6] = 1;
        Node<Integer> list = makeDListNonCircular(intArray);
        Node<Integer> returnList = distinct(list, CMP_REVERSE_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_REVERSE_ORDER));
        assertEquals(4, getSize(returnList));
    }

    @Test
    public void distinct_with_SomeElements3_list() {
        Integer[] intArray = new Integer[8];
        intArray[0] = 1;
        intArray[1] = 1;
        intArray[2] = 1;
        intArray[3] = 2;
        intArray[4] = 2;
        intArray[5] = 2;
        intArray[6] = 2;
        intArray[7] = 2;
        Node<Integer> list = makeDListNonCircular(intArray);
        Node<Integer> returnList = distinct(list, CMP_NATURAL_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER));
        assertEquals(2, getSize(returnList));
    }

    @Test
    public void distinct_with_SomeElements4_list() {
        Integer[] intArray = new Integer[6];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 2;
        intArray[3] = 2;
        intArray[4] = 2;
        intArray[5] = 2;
        Node<Integer> list = makeDListNonCircular(intArray);
        Node<Integer> returnList = distinct(list, CMP_NATURAL_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER));
        assertEquals(2, getSize(returnList));
    }

    @Test
    public void distinct_with_SomeElements5_list() {
        Integer[] intArray = new Integer[7];
        intArray[0] = -10;
        intArray[1] = -1;
        intArray[2] = -1;
        intArray[3] = 2;
        intArray[4] = 2;
        intArray[5] = 20;
        intArray[6] = 20;
        Node<Integer> list = makeDListNonCircular(intArray);
        Node<Integer> returnList = distinct(list, CMP_NATURAL_ORDER);
        assertTrue(isEmptyListWithSentinelNonCircular(list));
        assertTrue(isListSortedAndDistinct(returnList, CMP_NATURAL_ORDER));
        assertEquals(4, getSize(returnList));
    }

    static final Comparator<Integer> CMP_REVERSE_ORDER = (i1, i2) -> i2.compareTo(i1);

    static final Comparator<Integer> CMP_NATURAL_ORDER = (i1, i2) -> i1.compareTo(i2);

}






