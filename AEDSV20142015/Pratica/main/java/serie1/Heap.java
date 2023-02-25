package serie1;
import java.util.Comparator;

public class Heap {
	
	public static  void buildMaxHeap(int[] array,  int n, Comparator<Integer> cmp){
		int p= parent(n-1);	
		  for ( ; p >=0 ; --p) 
		     heapify(array,p, n, cmp);
	}
	
	public static void heapIncreaseKey(int[] v, int i, int key, Comparator<Integer> cmp ) {        
		v[i] = key;
		while(i>0 && cmp.compare(v[i], v[parent(i)])>0){
			exchange(v, i, parent(i));
			i = parent(i);
		}
	}
	
	static int parent(int i ) {
		  return (i-1)>>1;}
	
	private	static int left(int i ) { 
		  return (i<<1)+1;}
	
	private	static int right(int i ) {
		  return (i<<1)+2;}
	
	public static void heapify(int[] v, int p, int hSize, Comparator<Integer> cmp) {
		  int l, r, largest;
		  l = left(p); 
		  r = right(p);
		  largest=p;
		  if(l < hSize &&  cmp.compare(v[l], v[p])>0) largest=l;
		  if ( r < hSize && cmp.compare(v[r], v[largest]) >0 ) largest = r;
		  if ( largest == p ) return;
		  exchange(v, p, largest);
		  heapify(v, largest, hSize,cmp); 
		}
	
	public static void exchange(int[] v, int i, int j){
		  int tmp = v[i];
		  v[i] = v[j];
		  v[j] = tmp;		
		}

}
