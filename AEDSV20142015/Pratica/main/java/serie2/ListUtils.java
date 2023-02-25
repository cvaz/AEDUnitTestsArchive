package serie2;

import java.util.Comparator;

public class ListUtils {
	
	//paula
	public static <E> E getKBiggest(Node<E> list, int k, Comparator<E> cmp){
			Node<E> p1 = list, p2 = list;
			while (k > 0 && p1 != null) {
				k--; p1 = p1.next;
			}
			if (k != 0) return null;
			while (p1 != null) {
				p1 = p1.next; p2 = p2.next;
			}
			return (p2 != null) ? p2.value : null;
		}
	
	
	//cvaz
	public static <E> Node<E> 
	occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k){
		Node<E> dummy=new Node<E>();
		dummy.next=dummy.previous=dummy;
		if(lists.length==0) return dummy;
		int n=lists.length;
		int j=0;
	    for(int i=0;i<n;){ 	
	    	if(lists[i]==null){i++;}
	    	else{lists[j]=lists[i];i++;j++;}
	    }
	    n=j;
		buildMinHeap(lists,cmp,n);
		int counter=1; 
		Node<E> previous=null;
		Node<E> current=null;
		while(n>0){
	     current=lists[0];
	     lists[0]=lists[0].next;
	     if(previous==null){previous=current;}
	     else
	    	if(current.value.equals(previous.value)) {counter++;}
	     if(counter>=k){ 
	    	 current.next=dummy;
	    	 current.previous=dummy.previous; 
	    	 dummy.previous.next=current;
	    	 dummy.previous=current;
	    	 counter=1;
	    }
	    previous=current; 
	    if(lists[0]==null) {
	    	n--;
	    	exchange(lists,0,n);	
	       }
	    minHeapify(lists, 0, cmp,n);
		}
		return dummy;
	}

	


	private static <E> void buildMinHeap(Node<E>[] lists, Comparator<E> cmp, int n){
	int p= parent(n-1);
	  for ( ; p >=0 ; --p) 
	     minHeapify(lists, p,cmp,n);
	}

	private static <E> void minHeapify(Node<E>[] lists, int p,Comparator<E> cmp,int n){
	  int l, r, smallest;
	  l = left(p); 
	  r = right(p);
	  smallest=p;
	 
	  if(l < n &&  cmp.compare(lists[l].value, lists[p].value)<0) smallest=l;
	  if ( r < n && cmp.compare(lists[r].value, lists[smallest].value)<0) smallest = r;
	  if ( smallest == p ) return;
	  exchange(lists, p,smallest);	
	  minHeapify(lists, smallest, cmp,n); 
	}

	private static int parent(int i ) {
	  return (i-1)>>1;}
	
	private static int left(int i ) { 
	  return (i<<1)+1;}
	
	private static int right(int i ) {
	  return (i<<1)+2;}

	private static <E> void exchange(Node<E>[] v, int i, int j){
		Node<E> tmp = v[i];
		v[i] = v[j];
		v[j] = tmp;	
	}
	


}
