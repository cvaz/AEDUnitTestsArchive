package series.serie2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ListUtilTest {
	
	/*
	 * For circular lists with sentinel
	 * 
	 */
	
	public static <E> Node<E> emptyListWithSentinel() {
		Node<E> empty= new Node<E>();
		empty.next = empty.previous = empty;
		return empty;
	}

	public static <E> boolean isEmptyListWithSentinel(Node<E> list) {
		return list.next == list && list.previous == list;
	}
	

	public static <E> void addNode(Node<E> x, Node<E> list) {
		x.previous = list.previous; x.next = list;
		list.previous.next = x; list.previous = x;
	}
	
	public static <E> void addNewNode(E v, Node<E> list) {
		Node<E> x = newNode(v);
		x.previous = list.previous; x.next = list;
		list.previous.next = x; list.previous = x;
	}

	
	/*
	 * 
	 * Generic Methods
	 * 
	 * 
	 */
		
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
}
