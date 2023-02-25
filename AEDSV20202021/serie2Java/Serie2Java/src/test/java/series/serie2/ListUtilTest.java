package series.serie2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListUtilTest {
    /*
     * For double linked and circular lists with sentinel
     */
    public static <E> int getSize(Node<E> list) {
        int size = 0;
        Node<E> curr = list;
        while (curr.next != list) {
            ++size;
            curr = curr.next;
        }
        return size;
    }

    public static <E> Node<E> emptyListWithSentinel() {
        Node<E> empty = new Node<E>();
        empty.next = empty.previous = empty;
        return empty;
    }

    public static <E> Node<Integer> getRandomListWithSentinel(int dimension) {
        Random r = new Random();
        Node<Integer> list = ListUtilTest.emptyListWithSentinel();
        for (int i = 0; i < dimension; i++) {
            int v = r.nextInt() % 40;
            list.previous = newNode(v, list.previous, list);
            list.previous.previous.next = list.previous;
        }
        return list;
    }

    protected static <T> void assertListEquals(Node<T> expected, Node<T> result, Comparator<T> cmp) {
        Node<T> listExpected = expected.next;
        Node<T> listResult = result.next;
        while (listExpected != expected && listResult != result) {
            assertEquals(0, cmp.compare(listExpected.value, listResult.value));
            listExpected = listExpected.next;
            listResult = listResult.next;
        }
        assertTrue(listExpected == expected);
        assertTrue(listResult == result);
    }

    public static <E> boolean isEmptyListWithSentinel(Node<E> list) {
        return list.next == list && list.previous == list;
    }

    public static <E> Node<E> makeList(E... array) {
        Node<E> list = emptyListWithSentinel();
        for (E v : array) {
            list.previous = newNode(v, list.previous, list);
            list.previous.previous.next = list.previous;
        }
        return list;
    }

    public static Node<Integer> getListWithSentinel(int begin, int end, int step) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = begin; i <= end; i += step) {
            array.add(i);
        }
        Integer[] intArray = new Integer[array.size()];
        for (int i = 0; i < array.size(); i++) {
            intArray[i] = array.get(i);
        }
        return ListUtilTest.makeList(intArray);
    }

    static <E> boolean isListSortedAndDistinct(Node<E> list, Comparator<E> cmp) {
        Node<E> curr = list.next;
        if (curr == list || curr == list.previous) // List is empty
            return true;
        while (curr.next != list) {
            if (cmp.compare(curr.value, curr.next.value) >= 0)
                return false;
            curr = curr.next;
        }
        return true;
    }
    ////////////////////////////////////////////////////////////////////
    /*
	 * For double linked and non-circular lists with no sentinel
	 */
    public static <E> Node<E> emptyListWithoutSentinel() {
        return null;
    }

    public static Node<Integer> getListWithoutSentinel(int begin, int end, int step) {
        if (end < begin)
            return null;
        Node<Integer> list = new Node<Integer>();
        Node<Integer> cur = list;
        cur.value = begin;
        begin += step;
        for (; begin < end; begin += step) {
            Node<Integer> next = new Node<Integer>();
            cur.next = next;
            next.previous = cur;
            next.value = begin;
            cur = cur.next;
        }
        return list;
    }

    public static Node<Integer> getRandomListWithoutSentinel(int dimension) {
        Random r = new Random();
        Node<Integer> list = ListUtilTest.<Integer>emptyListWithoutSentinel();
        for (int i = 0; i < dimension; i++) {
            Node<Integer> novo = newNode(r.nextInt() % 40);
            novo.next = list;
            if (list != null)
                list.previous = novo;
            list = novo;
        }
        return list;
    }

    public static Node<Integer> getListWithoutSentinel(ArrayList<Integer> array) {
        if (array.size() == 0)
            return null;
        Node<Integer> list = new Node<Integer>();
        Node<Integer> cur = list;
        cur.value = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            Node<Integer> next = new Node<Integer>();
            cur.next = next;
            next.previous = cur;
            next.value = array.get(i);
            cur = cur.next;
        }
        return list;

    }

    public static <E> Node<E> getNNode(int N, Node<E> list) {
        for (int i = 0; i < N; i++) {
            if (list == null)
                return null;
            list = list.next;
        }
        return list;

    }

    public static <E> boolean isSorted(Node<E> list, Node<E> last,
                                       Comparator<E> cmp) {
        Node<E> curr = list;
        if (curr == null || curr == last)
            return true;
        while (curr.next != last) {
            if (cmp.compare(curr.value, curr.next.value) > 0)
                return false;
            curr = curr.next;
        }
        return true;
    }

    static <E> boolean isSorted(Node<E> list, Comparator<E> cmp) {
        Node<E> curr = list.next;
        if (curr == list || curr == list.previous) return true;
        while (curr.next != list) {
            if (cmp.compare(curr.value, curr.next.value) > 0) return false;
            curr = curr.next;
        }
        return true;
    }

    /*
     *
     * Generic Methods
     */

    public static <E> Node<E> newNode(E v) {
        Node<E> result = new Node<E>();
        result.value = v;
        return result;
    }

    public static <E> Node<E> newNode(E v, Node<E> p, Node<E> n) {
        Node<E> result = newNode(v);
        result.previous = p;
        result.next = n;
        return result;
    }
    ////////////////////////////////////////////////////////////////////
    /*
	 * For single linked and non-circular lists with sentinel
	 */
    public static <E> Node<E> emptySListWithSentinel() {
        Node<E> empty = new Node<E>();
        return empty;
    }

    static <E> boolean isSListSorted(Node<E> list, Comparator<E> cmp) {
        Node<E> curr = list.next;
        if (curr == list)
            return true;
        while (curr != null && curr.next != null) {
            if (cmp.compare(curr.value, curr.next.value) > 0) return false;
            curr = curr.next;
        }
        return true;
    }

    public static Node<Integer> getRandomSList(int dimension) {
        Random r = new Random();
        Node<Integer> list = ListUtilTest.<Integer>emptySListWithSentinel();
        for (int i = 0; i < dimension; i++) {
            Node<Integer> novo = newNode(r.nextInt() % 40);
            novo.next = list.next;
            list.next = novo;
        }
        return list;
    }

    public static Node<Integer> getSListWithSentinel(ArrayList<Integer> array) {
        var list = ListUtilTest.<Integer>emptySListWithSentinel();
        if (array.size() == 0)
            return list;
        for (int i = array.size() - 1; i>= 0; --i) {
            Node<Integer> novo = newNode(array.get(i));
            novo.next = list.next;
            list.next = novo;
        }
        return list;
    }

    public static Node<Integer> getSListWithSentinel(int begin, int end, int step) {
        Node<Integer> list = new Node<Integer>();
        var beg = begin;
        if (end < beg)
            return list;
        Node<Integer> cur = list;
        while (beg <= end) {
            Node<Integer> next = new Node<Integer>();
            cur.next = next;
            next.value = beg;
            cur = cur.next;
            beg += step;
        }
        return list;
    }

    ////////////////////////////////////////////////////////////////////
    /*
	 * For double linked lists with sentinel, but non-circular
	 */
    public static <E> Node<E> emptyListWithSentinelNonCircular() {
        Node<E> empty = new Node<E>();
        empty.previous = null;
        empty.next = null;
        return empty;
    }

    public static <E> boolean isEmptyListWithSentinelNonCircular(Node<E> list) {
        return list.next == null && list.previous == null;
    }

    public static <E> Node<E> makeDListNonCircular(E ... array) {
        Node<E> list = emptyListWithSentinelNonCircular();
        Node<E> curr = list;
        for (E v : array) {
            curr.next = newNode(v, list, null);
            curr = curr.next;
        }
        return list;
    }

    public static Node<Integer> getDListWithSentinelNonCircular(int begin, int end, int step) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = begin; i <= end; i += step) {
            array.add(i);
        }
        Integer[] intArray = new Integer[array.size()];
        for (int i = 0; i < array.size(); i++) {
            intArray[i] = array.get(i);
        }
        return makeDListNonCircular(intArray);
    }
}

















