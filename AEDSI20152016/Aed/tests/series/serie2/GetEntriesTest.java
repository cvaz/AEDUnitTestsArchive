package series.serie2;

import static org.junit.Assert.*;
import static series.serie2.HashMapUtilTest.containsEntry;
import static series.serie2.Iterables.getEntries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.Test;

public class GetEntriesTest {
	
	ArrayList<Integer> mapKeys = new ArrayList<Integer>(
		Arrays.asList(2101, 2002, 2103, 2104, 2205, 2106, 2407, 2408, 2409, 2410, 2311, 2212));
	
	ArrayList<String> mapValues = new ArrayList<String>(
		Arrays.asList("Aquario", "Peixes", "Carneiro", "Touro", "Gemeos", "Caranguejo", 
				"Leao", "Virgem", "Balanca", "Escorpiao", "Sagitario", "Capricornio"));	
	
	@Test
	public void  getEntries_emptyTable(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.emptyHashMap(10);
		assertTrue(HashMapUtilTest.isEmptyHashMap(hashMap));
		Iterable<Pair<Integer,String>> iterable = getEntries(hashMap);
		IterablesTest.assertIterableEmpty(iterable);
	}
	
	@Test
	public void  getEntries_fullTableWithCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 10);
		Iterator<Pair<Integer,String>> it = getEntries(hashMap).iterator();
		int k=0;
		while(it.hasNext()){
			Pair<Integer, String> p =it.next();
			assertTrue(containsEntry(p.key, p.value, hashMap));
			k++;
		}
		assertEquals(12,k);
	}
	
	@Test
	public void  getKeys_notFulltableWithCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 30);
		Iterator<Pair<Integer,String>>  it = getEntries(hashMap).iterator();
		int k=0;
		for(; it.hasNext();k++){
			assertTrue(containsEntry(it.next(), hashMap));
		}
		assertEquals(12,k);
	}
	
	@Test
	public void  getKeys_notFulltableWithNoCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 20);
		Iterator<Pair<Integer,String>>  it = getEntries(hashMap).iterator();
		int k=0;
		for(; it.hasNext();k++){
			assertTrue(containsEntry(it.next(), hashMap));
		}
		assertEquals(12,k);
	}
}


