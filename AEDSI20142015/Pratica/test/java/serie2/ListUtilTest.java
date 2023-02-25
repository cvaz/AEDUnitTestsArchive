package serie2;

import java.util.ArrayList;


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
	
	public static Node<Integer> getList(int start, int length, int step) {
		Node<Integer> list = ListUtilTest.<Integer>emptyListWithSentinel();
		for (int i= 0; i<length; i+= step) {
			list.next = newNode(i+start, list, list.next);
			list.next.next.previous = list.next;
		}
		return list;
	}	
	
	public static <E> void showListWithSentinel(Node<E> list) {
		Node<E> current = list.next;
		while (current != list) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> getList(int start, int length, int step, ArrayList<Integer> array) {
		Node<Integer> list = ListUtilTest.<Integer>emptyListWithSentinel();
		for (int i= length-1; i>=0; i-= step) {
			list.next = newNode(i+start, list, list.next);
			list.next.next.previous = list.next;
		}
		if (array != null)
			for (Node<Integer> current = list.next; current != list; current= current.next) 
				array.add(current.value);
		return list;
	}
	
	public static Node<Integer> getListDups(int start, int length, int step, ArrayList<Integer> array) {
		Node<Integer> list = ListUtilTest.<Integer>emptyListWithSentinel();
		int count = 1;
		for (int i= length-1; i>=0; i-= step) {
			for (int k = 0; k < count; k++) {
				list.next = newNode(i+start, list, list.next);
				list.next.next.previous = list.next;
			}
			count++;
		}
		if (array != null)
			for (Node<Integer> current = list.next; current != list; current= current.next) 
				array.add(current.value);
		return list;
	}
	
	public static Node<Integer> getList(int start, int length, ArrayList<Node<Integer>> array) {
		Node<Integer> list = ListUtilTest.<Integer>emptyListWithSentinel();
		for (int i= length-1; i>=0; --i) {
			list.next = newNode(i+start, list, list.next);
			list.next.next.previous = list.next;
		}
		for (Node<Integer> current = list.next; current != list; current= current.next) 
			array.add(current);
		return list;
	}
	
	
	
	
	/*
	 * For non_circular lists with no sentinel
	 * 
	 */
	
	public static <E> Node<E> emptyListWithoutSentinel() {
		return null;
	}
	public static <E> boolean isEmptyListWithoutSentinel(Node<E> list) {
		return list==null;
	}
	
	public static Node<Integer> getListWithoutSentinel(ArrayList<Integer> array){
		if(array.size()==0) return null;
		Node<Integer> list=new Node<Integer>();
		 Node<Integer> cur=list;
		 cur.value=array.get(0);
		 for(int i=1;i<array.size();i++){
			 Node<Integer> next=new Node<Integer>();
		 	 cur.next=next;
		 	 next.previous=cur;
		 	 next.value=array.get(i);
		 	 cur=cur.next;	
		 }
		 return list;		
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
