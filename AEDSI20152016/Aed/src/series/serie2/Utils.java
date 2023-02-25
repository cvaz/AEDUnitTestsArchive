package series.serie2;

import java.util.Comparator;

public class Utils {


	public static int NElement( int[] array, int l, int r, int n ){
		int size = r - l + 1;
		int curr = 0;
		buildMinHeap(array, size);
		int i = 0;
		while (n > 0 && size > 0) {
			curr = array[0];
			size--;
			array[0] = array[size];
			minHeapify(array, 0, size);
			n--;
		}
		return (n == 0) ? curr : array.length;
	}

	public static <K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list) {
		 while(list!=null){
			 int index=list.pair.key.hashCode()%hashMap.length;
			 if(index<0) index+=hashMap.length;
			 replace(hashMap[index], list);		 
			 list=list.next;
		 }
	}
	
	private static <K,V> void replace(HashNode<K,V> mapEntryList, HashNode<K,V> mapEntry){
		while(mapEntryList!=null){
			if(mapEntryList.pair.key.equals(mapEntry.pair.key)){
				mapEntryList.pair.value=mapEntry.pair.value; break;
			}
			mapEntryList=mapEntryList.next;
		}
	}


	private	static int left(int i ) { return (i<<1)+1;}

	private	static int right(int i ) { return (i<<1)+2;}

	private static void minHeapify(int[] v, int p, int hSize) {
		int l, r, smallest;
		l = left(p);
		r = right(p);
		smallest=p;
		if(l < hSize &&  v[l]<v[p]) smallest=l;
		if ( r < hSize && v[r] < v[smallest] ) smallest = r;
		if ( smallest == p ) return;
		exchange(v, p, smallest);
		minHeapify(v, smallest, hSize);
	}

	private static void exchange(int[] v, int i, int j){
		int tmp = v[i];
		v[i] = v[j];
		v[j] = tmp;
	}


	private static void buildMinHeap(int[] array, int n){
		int p= parent(n-1);
		for ( ; p >=0 ; --p)
			minHeapify(array,p,n);
	}

	private static int parent(int i){return (i-1)/2;}


}


