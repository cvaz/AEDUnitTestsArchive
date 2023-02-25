package serie2;

import java.util.Random;

public class TestHeapUtils {

	public static void buildMaxHeap(int[] array) {
		int p = (array.length >> 1) - 1;
		for (; p >= 0; --p) {
			maxHeapify(array, p,array.length);
		}
	}

	public static void maxHeapify(int[] v, int p, int sizeHeap) {
		int l, r, largest;
		l = left(p);
		r = right(p);
		largest = p;
		if (l < sizeHeap && v[l] > v[p])
			largest = l;
		if (r < sizeHeap && v[r] > v[largest])
			largest = r;
		if (largest == p)
			return;
		exchange(v, p, largest);
		maxHeapify(v, largest,sizeHeap );
	}

	public static void exchange(int[] v, int i, int j) {
		int tmp = v[i];
		v[i] = v[j];
		v[j] = tmp;
	}

	public static int left(int i) {
		return (i << 1) + 1;
	}

	public static int right(int i) {
		return (i << 1) + 2;
	}
	
	public static int[] randomHeap(int n, int seed){
		int[] array=new int[n];
		Random r=new Random();
		for(int i=0;i<n;i++){
			array[i]=r.nextInt();
		}
		TestHeapUtils.buildMaxHeap(array);
		return array;
	}
}
