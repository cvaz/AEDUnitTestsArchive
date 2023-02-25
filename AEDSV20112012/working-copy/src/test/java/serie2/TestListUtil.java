package serie2;

import java.util.ArrayList;
import java.util.Comparator;

public class TestListUtil {
	
	
	/*
	 * For non circular lists with no sentinel
	 * 
	 */
	public static <E> Node<E> emptyListWithoutSentinel() {
		return null;
	}
	public static <E> boolean isEmptyListWithoutSentinel(Node<E> list) {
		return list==null;
	}

	public static Node<Integer> getNodeList(int begin, int end, int step) {
        if(end<begin) return null; 
		Node<Integer> list=new Node<Integer>();
		 Node<Integer> cur=list;
		 cur.value=begin;
		 begin+=step;
		 for(;begin<end;begin+=step){
		 	 Node<Integer> next=new Node<Integer>();
		 	 cur.next=next;
		 	 next.previous=cur;
		 	 next.value=begin;
		 	 cur=cur.next;	
		 }
		return list;
	}
	
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
	
	public static <E> Node<Node<E>> getListOfLists(ArrayList<ArrayList<E>> lists){
		Node<Node<E>> listOfLists=TestListUtil.<Node<E>>emptyListWithSentinel();
		if(lists.size()==0) return listOfLists;
		ArrayList<E> current=null;
		for(int i=0; i<lists.size();i++){
			current=lists.get(i);
			Node<E> list =getList(current);
			Node<Node<E>> newNode=new Node<Node<E>>();
			
			newNode.value=list;
			
			newNode.next=listOfLists;
			newNode.previous=listOfLists.previous;
			listOfLists.previous.next=newNode;
			listOfLists.previous=newNode;
		}
	   return listOfLists;
	}
	
	
	public static <E> Node<E> getList(ArrayList<E> list){
		Node<E> node=TestListUtil.<E>emptyListWithSentinel();
		if(list.size()==0) return node;
		Node<E> newNode=null;
		for(int i=0; i<list.size();i++){
			newNode=new Node<E>();
			newNode.value=list.get(i);
			newNode.next=node;
			newNode.previous=node.previous;
			node.previous.next=newNode;
			node.previous=newNode;
		}
		return node;
	}
	
	public static  <E> boolean isSorted(Node<E> list, Comparator<E> cmp){
		Node<E> curr=list.next;
		while(curr.next!=list){
			if(cmp.compare(curr.value, curr.next.value)>0) return false;
			curr=curr.next;
		}
		return true;
	}	
}
