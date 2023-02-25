package series.serie2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static series.serie2.ListUtilTest.*;
import static series.serie2.ListUtils.getMiddle;

public class GetMiddleTest {
    @Test
    public void middle_empty_list() {
        Node<Integer> list = emptyListWithSentinel();
        assertEquals(list, getMiddle(list));
    }

    @Test
    public void middle_singleton_list() {
        Node<Integer> list = getRandomListWithSentinel(1);
        assertEquals(list.next, getMiddle(list));
    }

    @Test
    public void middle_list_with_odd_dimension() {
        Node<Integer> list = getListWithSentinel(1, 20, 1);
        assertEquals(10, getMiddle(list).value);
    }

    @Test
    public void middle_list_with_even_dimension() {
        Node<Integer> list = getListWithSentinel(0, 20, 1);
        assertEquals(10, getMiddle(list).value);
    }
}

















