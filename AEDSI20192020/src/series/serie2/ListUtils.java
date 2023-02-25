package series.serie2;

import java.util.Comparator;

public class ListUtils {



	//lista duplamente ligada, sem sentinela e não circular de listas duplamente ligadas, sem sentinela e não circulares.
	public static <E> void internalReverse(Node<Node<E>> list){
		Node<E> subHead=null;
		while(list!=null){
			subHead= reverse(list.value);
			list.value=subHead;
			//	while(subHead!=null){ System.out.println(subHead.value); subHead=subHead.next;}
			list=list.next;
		}
	}

	private static <E> Node<E> reverse(Node<E> head) {
		Node<E> iter = head, aux;
		while( iter != null ) {
			head = iter;
			aux = iter.next;
			iter.next = iter.previous;
			iter.previous = aux;
			iter = aux;
		}
		return head;
	}


	//lista duplamente ligada, com sentinela e circular
	public static <E> Node<E> intersection(Node<E> list1, Node<E> list2, Comparator<E> cmp){
		Node<E> res = null, curr1 = list1.previous, curr2 = list2.previous;
		E prevValue = null;
		while (curr1 != list1 && curr2 != list2) {
			if (cmp.compare(curr1.value, curr2.value) > 0) curr1 = curr1.previous;
			else if (cmp.compare(curr1.value, curr2.value) < 0) curr2 = curr2.previous;
			else {
				// remove from list1
				Node<E> x = curr1;
				curr1.previous.next = curr1.next; curr1.next.previous = curr1.previous;
				curr1 = curr1.previous;
				// remove from list2
				curr2.previous.next = curr2.next; curr2.next.previous = curr2.previous;
				curr2 = curr2.previous;
				// insert

				//first element
				if(prevValue==null){ res=x; prevValue=x.value; }
				else
				if (cmp.compare(x.value, prevValue) != 0) {
					x.next = res; x.previous = null;
					if (res != null) res.previous = x;
					res = x; prevValue = res.value;
				}
			}
		}
		return res;
	}


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
