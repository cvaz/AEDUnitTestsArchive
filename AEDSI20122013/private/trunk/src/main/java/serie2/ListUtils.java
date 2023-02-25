package serie2;

import java.util.Comparator;

public class ListUtils {

	
	public static <E>void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){
		if(first==null || last==null || first==last || last.next==first) return;
			Node<E> pivot=partition(first,last, cmp);
			quicksort(first, pivot.previous,cmp);
			quicksort(pivot.next, last,cmp);	
		}
	
	
	private static <E> Node<E> partition(Node<E> first, Node<E> last, Comparator<E> cmp){
		E pivot=last.value;
		Node<E> pivotNode=last;
		Node<E> left=first;
		Node<E> right=last.previous;
		if(left==pivot) return left;
		while( right!=null && left!=null &&   right.next!=left ){
			if(cmp.compare(left.value, pivot)<0) {
			 left=left.next;
			 }
			else
				if(cmp.compare(right.value, pivot)>0){
				 right=right.previous;}
				else{
					if(right.next!=left){
					E aux=left.value;
					left.value=right.value;
					right.value=aux;
					left=left.next;
					if(left!=right && right.next!=left) {right=right.previous;}
					}
					}
		}
		E aux=left.value;
		left.value=pivot;
		pivotNode.value=aux;
		return left;
	}
	

	
	
	
	
//Interleaved	
	
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

}
