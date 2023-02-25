package series.serie1;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static series.serie1.Arrays.partitionPoint;

public class TestPartitionPoint {
    static final int N = 100;
    @Test
    public void test_on_empty_Array(){
        assertEquals(0, partitionPoint(new int[0], 1));
    }

    @Test
    public void test_all_greater(){
        assertEquals( 0, partitionPoint( new int[] {3}, 1 ) );
        assertEquals( 0, partitionPoint( new int[] {5,2}, 1 ) );
        assertEquals( 0, partitionPoint( new int[] {5,2}, 1 ) );
        assertEquals( 0, partitionPoint( new int[] {5,2,3}, 1 ) );
        assertEquals( 0, partitionPoint( getRandomArray(N, 2, N), 1) );
        assertEquals( 0, partitionPoint( getRandomArray(N, 2, N), 1) );
    }

    @Test
    public void test_all_less(){
        assertEquals( 1, partitionPoint( new int[] {3}, Integer.MAX_VALUE ) );
        assertEquals( 2, partitionPoint( new int[] {5,2}, Integer.MAX_VALUE ) );
        assertEquals( 2, partitionPoint( new int[] {5,2}, Integer.MAX_VALUE ) );
        assertEquals( 3, partitionPoint( new int[] {5,2,3}, Integer.MAX_VALUE ) );
        assertEquals( N, partitionPoint( getRandomArray(N, 0, N), Integer.MAX_VALUE) );
    }

    private void test_all_zeros(int n) {
        int [] v= new int[n];
        assertEquals(0, partitionPoint(v, -1));
        assertEquals(0, partitionPoint(v, 0));
        assertEquals(n, partitionPoint(v, 1));
    }

    @Test
    public void test_all_equals(){
        test_all_zeros(1);
        test_all_zeros(2);
        test_all_zeros(3);
        test_all_zeros( N );
    }


    public void test_partition_point( int n, boolean with ){
        int baseValue = n/2 ;
        for (int partitionPoint = 0; partitionPoint < n; ++partitionPoint)
            assertEquals( partitionPoint, partitionPoint( getSegmentedArray(n, partitionPoint, baseValue, with), baseValue ) );
    }

    @Test
    public void test_partition_point_with_value(){
       test_partition_point(N, true);
    }

    @Test
    public void test_partition_point_without_Value(){
       test_partition_point(N, false);
    }

    static Random  rd = new Random();
    private int[] fillRandom(int[] v, int l, int r, int min, int max) {
        for(int i = l ; i<=r ; ++i)
            v[i] = rd.nextInt(max-min+1) + min;
        return v;
    }

    private int[] getRandomArray(int n, int min, int max) {
        return fillRandom(new int[n], 0, n-1, min, max);
    }

    private int[] getSegmentedArray(int n, int partitionPoint, int baseValue, boolean withValue) {
        int[] v = new int[n];
        fillRandom(v, 0, partitionPoint-1, 0, baseValue-1);
        if ( !withValue ) ++ baseValue;
        v[partitionPoint]= baseValue;
        fillRandom(v, partitionPoint + 1, n - 1, baseValue, n );
        return v;
    }

}
