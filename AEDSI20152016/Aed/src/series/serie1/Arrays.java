package series.serie1;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Arrays {

    // a solução logaritmica não é esta
    public static int findKthSmallest(int[] array1, int[] array2, int k) {
        if (array1.length + array2.length < k || k==0) throw new NoSuchElementException();
        int k1 = 0, k2 = 0;
        int i = 1;
        while (k1 < array1.length && k2 < array2.length) {
            if (array1[k1] < array2[k2]) {
                if (k  == i ) return array1[k1];
                k1++;
                i++;
            } else {
                if (k == i) return array2[k2];
                k2++;
                i++;
            }
        }
        while (k1 < array1.length) {
            if (k  == i) return array1[k1];
            k1++;
            i++;
        }
        while (k2 < array2.length) {
            if (k  == i) break;
            k2++;
            i++;
        }

        return array2[k2];
    }

    private static int partitionPoint( int[] v, int l, int r, int val ){
        if( l < 0 || r > v.length - 1)
            throw new UnsupportedOperationException();
        if ( l > r ) return l;
        int m = (r+l)>>>1;
        if ( v[m] >= val  )
            return partitionPoint(v, l, r-1, val);
        return partitionPoint(v, m+1, r, val);
    }

    public static int partitionPoint( int[] v, int val ){
        return partitionPoint(v,0, v.length-1, val);
    }

    public static int countInverses(String[] v, int l, int r) {
        Comparator<String> naturalOrder= (s1,s2)-> s1.compareTo(s2);
        quicksort(v,l,r,naturalOrder);
        int count=0;
        Comparator<String> cmp=new Comparator<String>(){
            public int compare(String s1,String s2) {
                    for (int i = 0, j = s2.length() - 1; i <= j; i++, j--) {
                        if (s1.charAt(i) != s2.charAt(j)) return s1.charAt(i) - s2.charAt(j);
                    }
                 return s1.length()==s2.length()?0:s1.length()-s2.length();
            }

        };
        for(int i=0;i<=r;i++){
            int x=i+1,y=r;
            while(x<=y){
                int mid=(x+y)/2;
                int c=cmp.compare(v[mid], v[i]);
                if(c==0) {count++;break;}
                else
                if(c>0) y=mid-1;
                else x=mid+1;
            }

        }
        return count;
    }

    public static int removeSmallerThan(int[] minHeap, int sizeHeap, int k){
            while(sizeHeap>0){
                if(minHeap[0]>=k)return sizeHeap;
                minHeap[0]=minHeap[--sizeHeap];
                minHeapify(minHeap, 0, sizeHeap);
            }
            return 0;
    }


    /*
     * AUXILIARY METHODS
     */
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

    private static void exchange(String[] v, int i, int j){
        String tmp = v[i];
        v[i] = v[j];
        v[j] = tmp;
    }


    private static int partition(String[] a, int l, int r,Comparator<String> cmp){
        String x=a[r];
        int i=l-1;
        for(int j=l; j<r;j++){
            if(cmp.compare(a[j],x)<=0){
                i++;
                exchange(a, i, j);
            }
        }
        i++;
        exchange(a, r, i);
        return i;
    }


    private static void quicksort(String[] a, int l, int r,Comparator<String> cmp){
        int partition;
        if(l<r){
            partition=partition(a,l,r,cmp);
            quicksort(a,l, partition-1,cmp);
            quicksort(a,partition+1,r,cmp);
        }
    }


}
