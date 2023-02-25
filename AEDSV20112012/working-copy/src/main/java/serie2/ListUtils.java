package serie2;
import java.util.Comparator;

public class ListUtils {

	
	public static Node<Node<Integer>> splitByUnit( Node<Integer> list ){
		Node<Integer>[] nodes=(Node<Integer>[])new Node[10];
		Node<Integer> aux;
		while(list!=null){
			int rest=list.value %10;
	        aux=list;
	        list=list.next;
			aux.next=nodes[rest];
			nodes[rest]=aux;
		}
		Node<Node<Integer>> newList, cur, next;
		newList=new Node<Node<Integer>>();
		cur=newList;
		cur.value=nodes[0];
		for(int i=1;i<10;i++){
			next=new Node<Node<Integer>>();
			cur.next=next;
			next.previous=cur;
			next.value=nodes[i];
			cur=cur.next;			
		}
		return newList;
		// throw new UnsupportedOperationException();
	}
	
	
	public static <E> Node<E> getOrderedSequence( Node<Node<E>> list, Comparator<E> cmp ){

		Node < E > result= null;
		
		Node<Node<E>> current=list.next;
		 while(current!=list){
	
			 removeEmpty(current);
			 current=current.next;
		 }
		 //não estou a reutilizar o primeiro nó
			result = new Node<E>( );
			result.next = result.previous = result;

			while(list.next!=list){
				Node<Node<E>> toMove = getLessOfFirsts(list,cmp);
				Node<E> moving=getFirst(toMove);
				toMove.value.next=toMove.value.next.next;//removing from sublist
				removeEmpty(toMove); //remove da lista se esta sublista fica vazia
				moving.next=result;
				moving.previous=result.previous;
				result.previous.next=moving;
				result.previous=moving;
				
			}
		return result;
		//throw new UnsupportedOperationException();
	}
	
	
	public static <E> Node<Node<E>> getLessOfFirsts(Node<Node<E>> list, Comparator<E> cmp){
		Node< Node < E > > current = list.next;
		Node< Node < E > > less=current;
		if(current.next==list) { return current;}
		while(current.next!=list){
			int x=compareFirsts(current,current.next,cmp);
			if(x>0)less=current.next;
			current=current.next;
		}	
		return less;
	}
	
	public static <E> int compareFirsts(Node<Node<E>> list1, Node<Node<E>> list2,Comparator<E> cmp){
		Node<E> first1=getFirst(list1);
		Node<E> first2=getFirst(list2);
		return cmp.compare(first1.value, first2.value);
	}
	
	public static<E> void removeEmpty(Node<Node<E>> list){
		if(list.value.next==list.value.next.next){ //is an empty list
			Node<Node<E>> prev=list.previous;
			Node<Node<E>> next=list.next;
			prev.next=next;
			next.previous=prev;
		}
	}
	
	public static <E> Node<E> getFirst(Node<Node<E>> list){
		return list.value.next;	
	}
}
