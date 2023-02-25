package serie2;

import java.util.ArrayList;

public class TestUtil {
	public static <E> Node<E> emptyList() {
		Node<E> empty= new Node<E>();
		empty.next = empty.previous = empty;
		return empty;
	}

	public static Node<Integer> getList( int start, int length, ArrayList<Node<Integer>> array) {
		Node<Integer> list = TestUtil.<Integer>emptyList();
		for (int i= length-1; i>=0; --i) {
			list.next = newNode(i+start, list, list.next);
			list.next.next.previous = list.next;
		}
		for (Node<Integer> current = list.next; current != list; current= current.next) 
			array.add( current );
		return list;
	}

	public static <E> boolean isEmptyList(Node<E> list) {
		return list.next == list && list.previous == list;
	}
	
	public static <E> Node<E> newNode( E v ) { 
		Node<E> result = new Node<E>();
		result.value = v; 
		return result;
	}
	public  static <E> Node<E> newNode(E v, Node<E> p, Node<E> n) {
		Node<E> result = newNode( v );
		result.previous = p;
		result.next = n;
		return result;
	}
	
	public static boolean existElement(int e, int[] a, int n) {
		for (int i = 0; i < n; i++) 
			if ( a[i] == e ) return true;
		return false;
	}
	public static boolean containsAll(int[] a1, int n1, int[]a2, int n2) {
		for (int i = 0; i < n1; i++) 
			if ( !existElement( a1[i], a2, n2 ) ) return false;
		return true;
	}
	
	public static boolean noDuplicates(int[] a) {
		for (int i = 0; i < a.length; i++)
			for (int j = i+1; j < a.length; j++)
				if (a[i] == a[j]) return false;
		return true;
	}

	public static boolean isMaxHeap(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			int left = 2 * i + 1;	      	
	      	int right = 2 * i + 2;
	      	if ( left < n && a[i] < a[left] || 
	      		 right < n && a[i] < a[right]) return false;
		}
		return true;
	}
}
