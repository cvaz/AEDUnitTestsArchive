package serie2;

import static org.junit.Assert.*;
import static serie2.Utils.histogram;
import static serie2.IterablesTest.*;

import java.util.*;

import org.junit.Test;

public class HistogramTest {
	static final Integer[] arrayEmpty = {},
		arrayS1 = {1},
		arraySeq = {1,2,3,4,5,6,7,8,9},
		arraySeq2 = {1,2,2,3,3,3,4,4,4,4},
		arraySeq3 = {21,1,1,1,3,3,23,23,23,4};
	
	static final Iterable<Integer> empty = Collections.<Integer>emptyList();

	static final List<Pair<Integer, Integer>> seq = Arrays.<Pair<Integer, Integer>>asList(
		new Pair<Integer, Integer>(9,1), new Pair<Integer, Integer>(1,1), new Pair<Integer, Integer>(2,1), 
		new Pair<Integer, Integer>(3,1), new Pair<Integer, Integer>(4,1), new Pair<Integer, Integer>(5,1), 
		new Pair<Integer, Integer>(6,1), new Pair<Integer, Integer>(7,1), new Pair<Integer, Integer>(8,1)
		),
	seq2 = Arrays.<Pair<Integer, Integer>>asList(
		new Pair<Integer, Integer>(1,1), new Pair<Integer, Integer>(2,2), 
		new Pair<Integer, Integer>(3,3), new Pair<Integer, Integer>(4,4)
		),
	seq3 = Arrays.<Pair<Integer, Integer>>asList(
		new Pair<Integer, Integer>(1,3), new Pair<Integer, Integer>(21,1), 
		new Pair<Integer, Integer>(23,3), new Pair<Integer, Integer>(3,2),
		new Pair<Integer, Integer>(4,1)
		);
	
	@Test 
	public void histogram_withEmptySequence(){
		assertIterableEmpty(histogram(arrayEmpty));	
	}
	
	@Test 
	public void histogram_withOneElementSequence(){
		List<Pair<Integer, Integer>> s1 = Collections.<Pair<Integer, Integer>>singletonList(new Pair<Integer, Integer>(1,1));
		assertIterableEquals(s1, histogram(arrayS1));
	}
	
	@Test 
	public void histogram_withASequence_noRepeat_noCollisions(){
		Iterator<Pair<Integer,Integer>> it=histogram(arraySeq).iterator();
		List<Pair<Integer,Integer>> listAux=new ArrayList<Pair<Integer,Integer>>();
		while(it.hasNext())listAux.add(it.next());
		assertTrue(seq.containsAll(listAux));
		assertTrue(listAux.containsAll(seq));
	}
	
	@Test 
	public void histogram_withASequence_repeat_noCollisions(){
		Iterator<Pair<Integer,Integer>> it=histogram(arraySeq2).iterator();
		List<Pair<Integer,Integer>> listAux=new ArrayList<Pair<Integer,Integer>>();
		while(it.hasNext())listAux.add(it.next());
		assertTrue(seq2.containsAll( listAux));
		assertTrue(listAux.containsAll(seq2));
	}
	
	@Test 
	public void histogram_withASequence_repeat_collisions(){
		Iterator<Pair<Integer,Integer>> it=histogram(arraySeq3).iterator();
		List<Pair<Integer,Integer>> listAux=new ArrayList<Pair<Integer,Integer>>();
		while(it.hasNext())listAux.add(it.next());
		assertTrue(seq3.containsAll( listAux));
		assertTrue(listAux.containsAll(seq3));
	}
}
