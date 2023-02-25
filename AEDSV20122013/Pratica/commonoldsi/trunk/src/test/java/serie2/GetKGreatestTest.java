package serie2;
import static org.junit.Assert.*;
import static serie2.Iterables.getKGreatest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	public class GetKGreatestTest {
		
		static final Comparator<Integer> CMP_REVERSE_ORDER= new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2.compareTo(i1);
			}
		};	

		static final Comparator<Integer> CMP_NATURAL_ORDER= new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};	
		@Test
		public void getKGreatest_onArrayWithNoElements(){
			Integer result[]={};
			List<Integer> iterables=new ArrayList<Integer>();
			getKGreatest(result, iterables, CMP_NATURAL_ORDER);
			Integer[] expecteds={};
			assertArrayEquals(expecteds, result);
			
		}

		@Test
		public void getKGreatest_onArrayWithKElements_returnsAllTheArray(){
			List<Integer> iterables = Arrays.asList(1,3,2,5,4,7,6,9,8);
			Integer[] result = new Integer[iterables.size()];
			getKGreatest(result, iterables, CMP_REVERSE_ORDER);
			Collections.sort(iterables, CMP_REVERSE_ORDER);
			Integer[] expecteds = iterables.toArray(new Integer[iterables.size()]);
			Arrays.sort(result, CMP_REVERSE_ORDER);
			assertArrayEquals(expecteds, result);
		}

		@Test
		public void getKGreatest_KEqualTo1_returnsArrayWithMaximum(){
			List<Integer> iterables = Arrays.asList(1,3,2,5,4,7,6,9,8);
			Integer[] result = new Integer[1];
			getKGreatest(result, iterables, CMP_NATURAL_ORDER);
			assertEquals(1, result.length);
			assertEquals(9, result[0].intValue());
		}

		@Test
		public void getKGreatest_KEqualTo1_returnsArrayWithMinimum(){
			List<Integer> iterables = Arrays.asList(1,3,2,5,4,7,6,9,8);
			Integer[] result = new Integer[1];
			getKGreatest(result, iterables, CMP_REVERSE_ORDER);
			assertEquals(1, result.length);
			assertEquals(1, result[0].intValue());
		}

		
		@Test
		public void getKGreatest_onArrayWithKElements_returnsTheArrayWithoutTwoGreat(){
			List<Integer> iterables = Arrays.asList(1,3,2,8,4,7,6,9,5);
			Integer[] result = new Integer[iterables.size()-2];
			getKGreatest(result, iterables, CMP_REVERSE_ORDER);
			Collections.sort(iterables, CMP_REVERSE_ORDER);
			Integer[] expecteds = iterables.subList(2, iterables.size()).toArray(new Integer[iterables.size()-2]);
			Arrays.sort(result, CMP_REVERSE_ORDER);
			assertArrayEquals(expecteds, result);		
		}

		@Test
		public void getKGreatest_onArrayWithKElements_returnsTheArrayWithoutThreeSmaller(){
			List<Integer> iterables = Arrays.asList(1,3,2,8,4,7,6,9,5);
			Integer[] result = new Integer[iterables.size()-3];
			getKGreatest(result, iterables, CMP_NATURAL_ORDER);
			Arrays.sort(result, CMP_NATURAL_ORDER);
			Collections.sort(iterables, CMP_NATURAL_ORDER);
			Integer[] expecteds = iterables.subList(3, iterables.size()).toArray(new Integer[iterables.size()-3]);
			assertArrayEquals(expecteds, result);		
		}
	}

