package series.serie1;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static series.serie1.Arrays.lessFrequent;


public class LessFrequentTest {

    @Test
    public void lessFrequent_onArrayWithNoElements(){
        assertThrows(NoSuchElementException.class, () -> lessFrequent(new int[]{}));
    }

    @Test
    public void lessFrequent_onArrayWithOneElement(){
        assertEquals(1,lessFrequent(new int[]{1}));
    }

    @Test
    public void lessFrequent_onArrayWithTwoDistinctElements(){
        assertEquals(3,lessFrequent(new int[]{3,2}));
    }

    @Test
    public void lessFrequent_onArrayWithSameElements(){
        assertEquals(3,lessFrequent(new int[]{3,3,3,3,3,3,3}));
    }

    @Test
    public void lessFrequent_onArrayWithTwoAlternateElements(){
        assertEquals(2,lessFrequent(new int[]{3,2,3,2,3,2,3,2,3}));
    }

    @Test
    public void lessFrequent_onArrayWithThreeAlternateElements(){
        assertEquals(1,lessFrequent(new int[]{3,1,3,2,3,2,3,1,3}));
    }

}
