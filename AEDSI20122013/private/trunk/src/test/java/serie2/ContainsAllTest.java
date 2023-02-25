package serie2;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Comparator;
import static serie2.Utils.containsAll;

	public class ContainsAllTest {
		
		private static class NodeComparator implements Comparator<Integer>{
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}
		
		private static final int H_LENGTH = 10;
		HashNode<Integer>[] emptyHashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
		HashNode<Integer>[] hashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
		HashNode<Integer>[] hashTableContained = (HashNode<Integer>[]) new HashNode[H_LENGTH];
		
		@Test
		public void containsAll_with_empty_tables(){
			assertTrue(containsAll(emptyHashTable, emptyHashTable, new NodeComparator()));
		}
		
		@Test
		public void containsAll_with_empty_table(){
			hashTableContained = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 20; i -= 12) insert(hashTableContained, i);
			assertFalse(containsAll(hashTableContained, emptyHashTable, new NodeComparator()));
		}
		
		@Test
		public void containsAll_with_empty_contained_table(){
			hashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 1; i -= 12) insert(hashTable, i);
			assertTrue(containsAll(emptyHashTable, hashTable, new NodeComparator()));
		}

		@Test
		public void containsAll_with_equal_tables(){
			hashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 1; i -= 12) insert(hashTable, i);
			assertTrue(containsAll(hashTable, hashTable, new NodeComparator()));
		}
		
		@Test
		public void containsAll_with_contained_table(){
			hashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 1; i -= 12) insert(hashTable, i);
			hashTableContained = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 20; i -= 12) insert(hashTableContained, i);
			assertTrue(containsAll(hashTableContained, hashTable, new NodeComparator()));
		}
		
		@Test
		public void containsAll_with_not_contained_table(){
			hashTable = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 1; i -= 12) insert(hashTable, i);
			hashTableContained = (HashNode<Integer>[]) new HashNode[H_LENGTH];
			for (int i = 99; i > 20; i -= 12) insert(hashTableContained, i);
			assertFalse(containsAll(hashTable, hashTableContained, new NodeComparator()));
		}
		
		
		
		private static <E> int index(HashNode<E>[] hashTable, E e){
			int m = hashTable.length;
			int h = e.hashCode() % m;
			return (h < 0) ? h + m : h;
		}
		
		
		public static <E> void insert(HashNode<E>[] hashTable, E e){
			int i = index(hashTable, e);
			HashNode<E> n = new HashNode<E>();
			n.value=e;
			n.next = hashTable[i];
			hashTable[i] = n;
		}
	}

