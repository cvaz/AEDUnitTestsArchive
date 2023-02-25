package series.serie2;


import org.junit.Assert;
import org.junit.Test;


import static series.serie2.Utils.NElement;

public class NElementTest {
    private static final int[] original = {12, 1, 2, 3, 2, 5, 6, 3, 8, 10, 0};
    private static int[] copy = new int[original.length];

    private void arrayCopy(int[] from, int[] to) {
        for (int i = 0; i < from.length; i++)
            to[i] = from[i];
    }

    @Test
    public void test_NElement_with_empty_array(){
        int[] emptySequence = {};
        Assert.assertEquals(0, NElement(emptySequence, 0, emptySequence.length - 1, 1));
    }

    @Test
    public void test_NElement_at_the_begin(){
        arrayCopy(original, copy);
        Assert.assertEquals(0, NElement(copy, 0, copy.length - 1, 1));
    }

    @Test
    public void test_NElement_at_the_end(){
        arrayCopy(original, copy);
        Assert.assertEquals(12, NElement(copy, 0, copy.length - 1, 11));
    }

    @Test
    public void test_NElement_at_the_middle(){
        arrayCopy(original, copy);
        Assert.assertEquals(5, NElement(copy, 0, copy.length - 1, 7));
    }

    @Test
    public void test_NElement_with_n_greater_than_array(){
        arrayCopy(original, copy);
        Assert.assertEquals(11, NElement(copy, 0, copy.length - 1, 20));
    }
}

