package serie1;

import java.util.NoSuchElementException;
import java.util.Comparator;
import serie1.Heap;

public class Arrays {
	
	public static int findMinDifference(int[] elem1, int[] elem2) {
	
		if (elem1.length == 0 || elem2.length == 0) return -1;
		int minDiff = Math.abs(elem1[0] - elem2[0]), currDiff = 0;
		int i = 0, j = 0;
		while (i < elem1.length && j < elem2.length) {
			currDiff = Math.abs(elem1[i] - elem2[j]);
			if (elem1[i] < elem2[j]) i++;
			else if (elem1[i] > elem2[j]) j++;
			else return 0;
			if (currDiff < minDiff) minDiff = currDiff;
		}
		return minDiff;
		
	}
	
	public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k){
		if(v.length==0 || r<l || k<=0) return new int[0];
		int[] toReturn;
		if(r-l+1<k) {
			toReturn=new int[r-l+1]; 
			System.arraycopy(v, l, toReturn, 0, r-l+1); 
			return toReturn;
		};
		toReturn=new int[k];
		System.arraycopy(v, l, toReturn, 0, k);
		final int aux=x;
		Comparator<Integer> cmp=new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				return Math.abs(i1-aux) - Math.abs(i2-aux);
			}
		};
		Heap.buildMaxHeap(v,k,cmp);
		for(int i=k;i<=r;i++){
			if(cmp.compare(v[i], toReturn[0])<0){
				toReturn[0]=v[i];
				Heap.heapify(v, 0, k, cmp);		
			}
		}
		return toReturn;
	}
	

	/**
	 * MEDIAN
	 */
	public static int median(int[] v, int l, int r){
		if(r<l) throw new NoSuchElementException();
		int mid=v.length/2;
		putTheElementForPos(v,l,r,mid);
		if(v.length % 2==0) {
		putTheElementForPos(v,l,mid-1,mid-1);
			return (v[mid]+ v[mid-1])/2;
		}
		else{
			return v[mid];
		}

	}	
	private static void putTheElementForPos(int[] v, int l, int r, int pos){
		int i=partition(v,l,r);
		while(i!=pos){
			if(i>pos){
				i=partition(v,l,i-1);
			}
			else{
				i=partition(v,i+1,r);
			}
		}
	}
	
	
	private static int partition(int[] a, int l, int r){
	    int x=a[r];
	    int i=l-1;
	    for(int j=l; j<r;j++){
	      if(a[j]<=x){
	        i++;
	        exch(a,i,j);
	       }
	      }
	      i++;
	      exch(a,r,i);
	      return i;
	}
	
	
	
	private static void exch(int[] a, int k, int p){
		int aux=a[k];
		a[k]=a[p];
		a[p]=aux;
	}
	
	
	
	/**
	 * GREATER COMMON PREFIX
	 * @param v
	 * @param l
	 * @param r
	 * @param word
	 * @return
	 */
	
	 public static String greaterCommonPrefix( String[] v, int l, int r, String word) {
		 /*Caso o sub-array (v,l,r) não contenha palavras, o método deverá retornar null*/
		 if(r<l)return null;
		    int m;
		    Comparator<String> cmp=new Comparator<String>(){
				public int compare(String s1, String s2){
					int count=0;
					for(int i=0, j=0; i<s1.length() && j<s2.length(); i++, j++){
						if(s1.charAt(i)== s2.charAt(j)) count++;
						else break;
					}
					return count;
				}
			};
			//se eu tiver so um elemento, significa que o maior prefixo commum poderá ser ou não a subtring vazia
			//logo retorno o próprio.
			if(l==r) return v[l];

			String toReturn=null;
			//fim do sub_array
		    int rInit=r;
		    while ( l <= r ) {
		      m =( l+r )/2;
		      int cp=v[m].compareTo(word);
		      if (cp <= 0){
		         l = m+1; 
		      }
		      else{	
	           r = m-1;	 
		      }
		    }
	    if(l<=rInit) toReturn=(cmp.compare(v[l],word)>= cmp.compare(v[l-1],word))?v[l]:v[l-1];
		     else{
		    	 toReturn=v[l-1];
		     }  
	    //caso o maior prefixo commum seja a string vazia
		    return (cmp.compare(toReturn,word)==0)? v[rInit]:toReturn;
		   // return toReturn; 
		  }
	 
	 

}
