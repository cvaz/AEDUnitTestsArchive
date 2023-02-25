package series.serie1;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveSmallerThanTest {

    private static final int[] sortedArrayWithThreeElements = { 1, 2, 3 };
    private static final int[] sortedArrayWithTwelveElements = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private static final int[] minHeapWithElevenElements = { 1, 9, 3, 13, 11, 5, 7, 15, 21, 19, 17 };

    @Test
    public void removeSmallerThan_onEmptyHeapAndEmptyArray(){
        for(int i=0;i<10;i++){
            Assert.assertEquals(0, Arrays.removeSmallerThan(new int[0], 0, i));
        }
    }

    @Test
    public void removeSmallerThan_onEmptyHeap(){
        int[] minHeap = java.util.Arrays.copyOf(sortedArrayWithThreeElements, sortedArrayWithThreeElements.length);
        for(int i=0;i<10;i++){
            Assert.assertEquals(0, Arrays.removeSmallerThan(minHeap, 0, i));
            assertArrayEquals(sortedArrayWithThreeElements, minHeap );
        }
    }

    @Test
    public void removeSmallerThan_onHeapWithOneElement() {
        int[] minHeap = { 1 };
        Assert.assertEquals(1, Arrays.removeSmallerThan(minHeap, 1, 0));
        assertEquals( 1, minHeap[0] );
        Assert.assertEquals(0, Arrays.removeSmallerThan(minHeap, 1, 3));
        assertEquals( 1, minHeap[0]);
    }

    @Test
    public void removeSmallerThan_withOnElementAtEachTimeAtTop() {
        int sizeHeap= sortedArrayWithTwelveElements.length;
        int[] minHeap= java.util.Arrays.copyOf(sortedArrayWithTwelveElements, sizeHeap);
       for (int i=1; i<=sizeHeap; i++ ) {
           Assert.assertEquals(sizeHeap - i, Arrays.removeSmallerThan(minHeap, sizeHeap - i + 1, i));
         //  assertTrue(isMinHeap(minHeap, sizeHeap - i, 0));
           assertTrue(isMinHeap(minHeap, sizeHeap - i + 1, 0));
       }
    }

    @Test
    public void removeSmallerThan_withOddNumbers() {
        int sizeHeap= minHeapWithElevenElements.length;
        int[] minHeap= java.util.Arrays.copyOf(minHeapWithElevenElements, sizeHeap);
        for (int i=1; i<sizeHeap; i++ ) {
            Assert.assertEquals(sizeHeap - i, Arrays.removeSmallerThan(minHeap, sizeHeap - i +1 , 2 * i + 1));
         //   assertTrue(isMinHeap(minHeap, sizeHeap - i, 0));
            assertTrue(isMinHeap(minHeap, sizeHeap - i +1, 0));
        }
    }

    @Test
    public void removeSmallerThan_allLess() {
        int sizeHeap= minHeapWithElevenElements.length;
        int[] minHeap= java.util.Arrays.copyOf(minHeapWithElevenElements, sizeHeap);
        Assert.assertEquals(0, Arrays.removeSmallerThan(minHeap, sizeHeap  , 22));
    }

    @Test
    public void removeSmallerThan_allGreater() {
        int sizeHeap= minHeapWithElevenElements.length;
        int[] minHeap= java.util.Arrays.copyOf(minHeapWithElevenElements, sizeHeap);
        Assert.assertEquals(sizeHeap, Arrays.removeSmallerThan(minHeap, sizeHeap  , 0));
    }

    private static boolean isMinHeap(int[] array,int sizeHeap, int position){
            if (position > sizeHeap) return true;
            int left = 2*position+1, right = 2*position + 2;
            if (left  < sizeHeap && array[position]>array[left])  return false;
            if (right < sizeHeap && array[position]> array[right]) return false;
            return isMinHeap(array,sizeHeap,left) && isMinHeap(array,sizeHeap,right);
        }


}
