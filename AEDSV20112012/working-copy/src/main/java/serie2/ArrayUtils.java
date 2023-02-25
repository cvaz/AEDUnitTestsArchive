package serie2;

import java.util.*;
public class ArrayUtils {
	public static int NElement(int[] array, int l, int r, int n ) {
		int [] a = Arrays.copyOfRange(array, l, r+1);
		Arrays.sort( a );
		return a[n-1];
	}
}
