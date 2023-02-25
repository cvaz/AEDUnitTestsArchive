package serie2;

public class HeapUtils {

	public static boolean hasEquals( int[] maxHeap, int sizeHeap ){
		//throw new UnsupportedOperationException();
		if(sizeHeap<=1) return false;
		int element=maxHeap[0];
		while(sizeHeap>1){
			exchange(maxHeap,0,sizeHeap-1);
			sizeHeap--;
			maxHeapify(maxHeap,0, sizeHeap);	
			if(element==maxHeap[0]) return true;
			element=maxHeap[0]; 
			
		}
		return false;
		
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
		maxHeapify(v, largest, sizeHeap );
	}
	
	public static void exchange(int[] v, int i, int j) {
		int tmp = v[i];
		v[i] = v[j];
		v[j] = tmp;
	}

	public static int parent(int i) {
		return (i - 1) >> 1;
	}

	public static int left(int i) {
		return (i << 1) + 1;
	}

	public static int right(int i) {
		return (i << 1) + 2;
	}
		public static int minimum( int[] v, int len ){
			//throw new UnsupportedOperationException();
			int min=v[len-1];
			for(int i=len-2; i>=(len-1)/2; i--){
				if(v[i]<min) min=v[i];
			}
			return min;
			
		}
	}

