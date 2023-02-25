package series.serie1;

import java.util.Comparator;

/**
 * Created by cvaz on 21/09/2017.
 */
public class Arrays {

    /*
     *
     * Exercício 1
     * Solução O(N^3)
     */
     public static int printEachThreeElementsThatSumTo(int[] v, int l, int r, int s){
         int count = 0;
         for(int i=l; i<=r;i++) {
             for (int j = l; j <= r; j++) {
                 for (int k = l; k <= r; k++) {
                     if (i < j && j < k && v[i] + v[j] + v[k] == s) {
                         System.out.println(v[i] + " " + v[j] + " " + v[k]);
                         count++;
                     }
                 }
             }
         }
             return count;
         }

     /**
      *
      * Exercício 2
     *
     */

    public static int removeIndexes(int v[], int l, int r, int[] vi, int li, int ri) {
       	 int put = l - 1, get = l;
        while (get <= r && li <= ri) {
            if (get <= vi[li]) {
                if (get < vi[li])
                    v[++put] = v[get];
                else
                    ++li;
                ++get;
            } else
                ++li;
        }
        int n = r - get + 1;
        System.arraycopy(v, get, v, put + 1, n);
        return put - l + 1 + n;
    }

    /**
     *
     * Exercício 3
     *
     */
    public static String greaterCommonPrefix(String[] v, int l, int r, String word) {
		 /*Caso o sub-array (v,l,r) não contenha palavras, o método deverá retornar null*/
        if (r < l) return null;
        int m;
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                int count = 0;
                for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
                    if (s1.charAt(i) == s2.charAt(j)) count++;
                    else break;
                }
                return count;
            }
        };
        //se eu tiver so um elemento, significa que o maior prefixo commum poderá ser ou não a subtring vazia
        //logo retorno o próprio.
        if (l == r) return v[l];

        String toReturn = null;
        //fim do sub_array
        int rInit = r;
        while (l <= r) {
            m = (l + r) / 2;
            int cp = v[m].compareTo(word);
            if (cp <= 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (l <= rInit) toReturn = (cmp.compare(v[l], word) >= cmp.compare(v[l - 1], word)) ? v[l] : v[l - 1];
        else {
            toReturn = v[l - 1];
        }
        //caso o maior prefixo commum seja a string vazia
        return (cmp.compare(toReturn, word) == 0) ? v[rInit] : toReturn;
        // return toReturn;
    }

    /**
     *
     * Exercício 4
     *
     */
     public static int sumGivenN(int n){
             if(n==0) return 1;
             int start = 1, end = 1;
             int sum = 1;
             int count=0;
             while (start <= n)
             {
                 if (sum < n)
                 {
                     end += 1;
                     sum += end;
                 }
                 else if (sum > n)
                 {
                     sum -= start;
                     start += 1;
                 }
                 else if (sum == n)
                 {
                     for (int i = start; i <= end; ++i) {
                         System.out.print(i);

                     }
                     count++;
                     System.out.println();
                     sum -= start;
                     start += 1;
                 }
             }
             return count;
         }


    /**
     *
     * Exercício 5
     *
     */

    /*number of elements that remain*/
    public static int deleteMin(int[] maxHeap, int sizeHeap) {
        if (sizeHeap == 0) return 0;
        int min = sizeHeap - 1;
        int pai = (min - 1) / 2;
		/*the heap size is 1 or 2.
		 * In theses cases, we do not change the heap*/
        if (pai < 0) {
            if (maxHeap[0] < maxHeap[1]) maxHeap[0] = maxHeap[1];
            return sizeHeap - 1;
        }
        for (int i = sizeHeap - 1; i > pai; i--) {
            if (maxHeap[min] > maxHeap[i]) min = i;
        }
        removeMinFromMaxHeap(maxHeap, sizeHeap, min);
        return sizeHeap - 1;
    }

    private static void removeMinFromMaxHeap(int[] maxHeap, int heapSize, int min) {
        maxHeap[min] = maxHeap[heapSize - 1];
        int pai = (min - 1) / 2;
        int aux = 0;
        while (maxHeap[pai] < maxHeap[min]) {
            aux = maxHeap[pai];
            maxHeap[pai] = maxHeap[min];
            maxHeap[min] = aux;
            min = pai;
            pai = (min - 1) / 2;
        }
    }
}
