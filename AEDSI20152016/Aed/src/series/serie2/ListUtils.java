package series.serie2;

import java.util.Comparator;

public class ListUtils {


	public static <E> E mostOccurrent(Node<E>[] lists, Comparator<E> cmp){
		E bestUntilNow=null;
		int bestCounterUntilNow=0;
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
	     if(previous==null){previous=current; bestCounterUntilNow=1; bestUntilNow=previous.value;}
	     else
	    	if(current.value.equals(previous.value)) {counter++;}
			else{
				if(counter>bestCounterUntilNow || (counter==bestCounterUntilNow && cmp.compare(bestUntilNow,previous.value)>0)){

					bestCounterUntilNow=counter;
					bestUntilNow=previous.value;
				}
	    	 counter=1;
	    }
	    previous=current; 
	    if(lists[0]==null) {
	    	n--;
	    	exchange(lists,0,n);	
	       }
	    minHeapify(lists, 0, cmp,n);
		}
		return bestUntilNow;
	}


	public static <E> Node<E> interleaved( Node< Node < E >> list ) {
		Node< Node < E > > current = list.next;
		Node < E > result= new Node<E>( );
		result.next = result.previous = result;
		boolean moveSome = true;
		while ( moveSome ) {
			moveSome = false;
			current = list.next;
			while (current != list ) {
				moveSome |= moveFirst(result, current.value);
				current = current.next;
			}
		}
		list.next = list.previous = list;
		return result;
	}


	private static <E> boolean moveFirst(Node < E > result, Node<E> list ) {
		if ( list.next == list ) return false;
		Node<E> first = list.next;
		list.next = first.next;
		first.previous= result.previous;
		first.next = result;
		result.previous.next = result.previous= first;
		return true;
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
