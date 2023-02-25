package series.serie2;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.util.function.IntSupplier;

import static series.serie2.Iterables.cycle;
import static series.serie2.IterablesTest.assertIterableEmpty;
import static series.serie2.IterablesTest.assertIterableEquals;
import static series.serie2.IterablesTest.singleton;


public class CycleTest {
    private static final int  N = 4; // > 3

    @Test
    public void emptyCycle(){
        assertIterableEmpty( cycle(Collections.emptyList()) );
    }

    private <E> void testCycle(Iterable<E> expected, Iterable<E> test) {
        Iterator<E> it = test.iterator();
        for (int n= 0, k= 2; n < N; ++n, --k) {
            for (E e: expected ) {
               for(int i=0; i < k; ++i ) assertTrue(it.hasNext());
               assertEquals(e, it.next());
            }
        };
        assertTrue( it.hasNext() );
    }

    @Test
    public void singleton_iterable(){
        Iterable<String> singleton=singleton("word");
        testCycle( singleton, cycle( singleton ));
   }

    @Test
    public void group_even_iterable(){
        List<Integer> groupEven = Arrays.asList( 1, 2, 3, 4 );
        testCycle( groupEven, cycle( groupEven ));
    }

    @Test
    public void group_odd_iterable(){
        List<Integer> groupOdd = Arrays.asList( 1, 2, 3 );
        testCycle( groupOdd, cycle( groupOdd ));
    }
}
